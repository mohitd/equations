package com.centauri.equations.provider;

import java.util.HashMap;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;

import com.centauri.equations.provider.Equations.Formula;

public class EquationsProvider extends ContentProvider {

    // Database
    private static final String DATABASE_NAME = "formula.db";
    private static final String FORMULA_TABLE_NAME = "formula";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper dbHelper;

    // Content Provider
    private static final UriMatcher uriMatcher;
    private static HashMap<String, String> projectionMap;
    private static final int FORMULAS = 1;
    private static final int FORMULA_ID = 2;
    private static final int SEARCH_SUGGEST = 3;

    static {
	uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	uriMatcher.addURI(Equations.AUTHORITY, "formulas", FORMULAS);
	uriMatcher.addURI(Equations.AUTHORITY, "formulas/#", FORMULA_ID);
	uriMatcher.addURI(Equations.AUTHORITY,
		SearchManager.SUGGEST_URI_PATH_QUERY, SEARCH_SUGGEST);
	uriMatcher.addURI(Equations.AUTHORITY,
		SearchManager.SUGGEST_URI_PATH_QUERY + "/*", SEARCH_SUGGEST);

	projectionMap = new HashMap<String, String>();
	projectionMap.put(Formula._ID, Formula._ID);
	projectionMap.put(SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID,
		"_id AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
	projectionMap.put(SearchManager.SUGGEST_COLUMN_SHORTCUT_ID, "_id AS "
		+ SearchManager.SUGGEST_COLUMN_SHORTCUT_ID);
	projectionMap.put(Formula.FORMULA_NAME, Formula.FORMULA_NAME);
	projectionMap.put(Formula.CATEGORY, Formula.CATEGORY);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	    db.execSQL("CREATE TABLE " + FORMULA_TABLE_NAME + " ("
		    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
		    + SearchManager.SUGGEST_COLUMN_TEXT_1 + " TEXT,"
		    + Formula.CATEGORY + " TEXT" + ");");
	    addFormula(db, "Quadratic Formula", "Algebra");
	    addFormula(db, "Distance Formula", "Algebra");
	    addFormula(db, "Radical Simplification", "Algebra");
	    addFormula(db, "Slope", "Algebra");

	    addFormula(db, "Area", "Geometry");
	    addFormula(db, "Pythagorean Theorem", "Geometry");
	    addFormula(db, "Heron's Formula", "Geometry");

	    addFormula(db, "Law of Sines", "Trigonometry");
	    addFormula(db, "Law of Cosines", "Trigonometry");
	    addFormula(db, "Law of Tangents", "Trigonometry");
	    addFormula(db, "Product to Sum Formulas", "Trigonometry");
	    addFormula(db, "Sum to Product Formulas", "Trigonometry");
	    addFormula(db, "Power Reduction Formulas", "Trigonometry");
	    addFormula(db, "Sum/Difference Formulas", "Trigonometry");
	    addFormula(db, "Even/Odd Identities", "Trigonometry");
	    addFormula(db, "Cofunction Formulas", "Trigonometry");
	    addFormula(db, "Pythagorean Identities", "Trigonometry");
	    addFormula(db, "Quotient Formulas", "Trigonometry");
	    addFormula(db, "Right Triangle Definitions", "Trigonometry");
	    addFormula(db, "Reciprocal Identities", "Trigonometry");

	    addFormula(db, "Ideal Gas Law", "Chemistry");
	    addFormula(db, "Ideal Gas Constant", "Chemistry");
	    addFormula(db, "Functional Groups", "Chemistry");

	    addFormula(db, "Logarithm Definition", "Algebra");
	    addFormula(db, "Logarithmic Identities", "Algebra");
	    addFormula(db, "Logarithmic Properties", "Algebra");
	    addFormula(db, "Summation Definition", "Algebra");
	    addFormula(db, "Summation Properties", "Algebra");

	    addFormula(db, "Boyle's Law", "Chemistry");
	    addFormula(db, "Charles' Law", "Chemistry");
	    addFormula(db, "Gay-Lussac's Law", "Chemistry");
	    addFormula(db, "Dalton's Law", "Chemistry");
	    addFormula(db, "Combined Gas Law", "Chemistry");

	    addFormula(db, "One Dimensional Motion", "Physics");
	    addFormula(db, "Force", "Physics");
	    addFormula(db, "Torque", "Physics");
	    addFormula(db, "Centripetal Force", "Physics");
	    addFormula(db, "Centripetal Acceleration", "Physics");
	    addFormula(db, "Newton's Law of Universal Gravitation", "Physics");
	    addFormula(db, "Maximum Height of a Projectile", "Physics");
	    addFormula(db, "Maximum Range of a Projectile", "Physics");
	    addFormula(db, "Coulumb's Law", "Physics");
	    addFormula(db, "Escape Velocity", "Physics");
	    addFormula(db, "Momentum", "Physics");
	    addFormula(db, "Work", "Physics");
	    addFormula(db, "Ohm's Law", "Physics");
	    addFormula(db, "Particle Energy", "Physics");
	    addFormula(db, "Resistance", "Physics");
	    addFormula(db, "Bernoulli's Law", "Physics");

	    addFormula(db, "Planck Constant", "Physics");
	    addFormula(db, "Speed of Light", "Physics");
	    addFormula(db, "Permittivity of Free Space", "Physics");
	    addFormula(db, "Gravitation Constant", "Physics");
	    addFormula(db, "Gravitational Acceleration", "Physics");

	    addFormula(db, "Acid/Base Equations", "Chemistry");

	    db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=1", null);
	    db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=2", null);
	    db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=21", null);
	    db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=55", null);
	    db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=7", null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	private long addFormula(SQLiteDatabase db, String formulaName,
		String category) {
	    ContentValues values = new ContentValues();
	    values.put(Formula.FORMULA_NAME, formulaName);
	    values.put(Formula.CATEGORY, category);
	    return db.insert(FORMULA_TABLE_NAME, null, values);
	}

    }

    @Override
    public boolean onCreate() {
	dbHelper = new DatabaseHelper(getContext());
	return true;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
	SQLiteDatabase db = dbHelper.getWritableDatabase();
	int count;

	switch (uriMatcher.match(uri)) {
	case FORMULAS:
	    count = db.delete(FORMULA_TABLE_NAME, selection, selectionArgs);
	    break;
	case FORMULA_ID:
	    String formulaId = uri.getPathSegments().get(1);
	    count = db.delete(FORMULA_TABLE_NAME, Formula._ID
		    + "="
		    + formulaId
		    + (!TextUtils.isEmpty(selection) ? " AND (" + selection
			    + ')' : ""), selectionArgs);
	    break;
	default:
	    throw new IllegalArgumentException("Unknown URI: " + uri);
	}

	getContext().getContentResolver().notifyChange(uri, null);
	return count;
    }

    @Override
    public String getType(Uri uri) {
	switch (uriMatcher.match(uri)) {
	case FORMULAS:
	    return Formula.CONTENT_TYPE;
	case FORMULA_ID:
	    return Formula.CONTENT_ITEM_TYPE;
	default:
	    throw new IllegalArgumentException("Unknown URI: " + uri);
	}
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
	if (uriMatcher.match(uri) != FORMULAS) {
	    throw new IllegalArgumentException("Unknown URI: " + uri);
	}

	// TODO Values checking here
	SQLiteDatabase db = dbHelper.getWritableDatabase();
	long rowId = db.insert(FORMULA_TABLE_NAME, null, values);
	if (rowId > 0) {
	    Uri formulaUri = ContentUris.withAppendedId(Formula.CONTENT_URI,
		    rowId);
	    getContext().getContentResolver().notifyChange(uri, null);
	    return formulaUri;
	}

	throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
	    String[] selectionArgs, String sortOrder) {
	SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	qb.setProjectionMap(projectionMap);
	qb.setTables(FORMULA_TABLE_NAME);

	switch (uriMatcher.match(uri)) {
	case FORMULAS:
	    qb.setTables(FORMULA_TABLE_NAME);
	    qb.setProjectionMap(projectionMap);
	    break;
	case FORMULA_ID:
	    qb.setTables(FORMULA_TABLE_NAME);
	    qb.setProjectionMap(projectionMap);
	    qb.appendWhere(Formula._ID + "=" + uri.getPathSegments().get(1));
	    break;
	case SEARCH_SUGGEST:
	    if (selectionArgs == null) {
		throw new IllegalArgumentException(
			"selectionArgs cannot be null!");
	    }
	    return getSuggestions(selectionArgs[0]);
	default:
	    throw new IllegalArgumentException("Unknown URI: " + uri);
	}

	SQLiteDatabase db = dbHelper.getWritableDatabase();
	Cursor cursor = qb.query(db, projection, selection, selectionArgs,
		null, null, sortOrder);

	cursor.setNotificationUri(getContext().getContentResolver(), uri);
	return cursor;
    }

    public static Cursor getSuggestions(String query) {
	SQLiteDatabase db = dbHelper.getReadableDatabase();
	String selection = Formula.FORMULA_NAME + " LIKE ?";
	String[] selectionArgs = { "%" + query + "%" };
	Cursor cursor = db.query(FORMULA_TABLE_NAME, new String[] {
		BaseColumns._ID,
		SearchManager.SUGGEST_COLUMN_TEXT_1,
		BaseColumns._ID + " AS "
			+ SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID },
		selection, selectionArgs, null, null, null);
	return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
	    String[] selectionArgs) {
	SQLiteDatabase db = dbHelper.getWritableDatabase();
	int count;

	switch (uriMatcher.match(uri)) {
	case FORMULAS:
	    count = db.update(FORMULA_TABLE_NAME, values, selection,
		    selectionArgs);
	    break;
	case FORMULA_ID:
	    String formulaId = uri.getPathSegments().get(1);
	    count = db.update(FORMULA_TABLE_NAME, values, Formula._ID
		    + "="
		    + formulaId
		    + (!TextUtils.isEmpty(selection) ? " AND (" + selection
			    + ')' : ""), selectionArgs);
	    break;
	default:
	    throw new IllegalArgumentException("Unknown URI: " + uri);
	}

	getContext().getContentResolver().notifyChange(uri, null);
	return count;
    }

}
