package com.centauri.equations.provider;

import java.util.HashMap;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;

import com.centauri.equations.R;
import com.centauri.equations.provider.Equations.Formula;

public class EquationsProvider extends ContentProvider {

    // Database
    private static final String DATABASE_NAME = "formula.db";
    private static final String FORMULA_TABLE_NAME = "formula";
    private static final int DATABASE_VERSION = 6;
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
	projectionMap.put(Formula.FAVORITE, Formula.FAVORITE);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

	private Context context;

	public DatabaseHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	    db.execSQL("CREATE TABLE IF NOT EXISTS " + FORMULA_TABLE_NAME
		    + " (" + BaseColumns._ID
		    + " INTEGER PRIMARY KEY AUTOINCREMENT,"
		    + SearchManager.SUGGEST_COLUMN_TEXT_1 + " TEXT,"
		    + Formula.CATEGORY + " TEXT," + Formula.FAVORITE
		    + " INTEGER" + ");");
	    Resources res = context.getResources();

	    // 1
	    addFormula(db, res.getString(R.string.quad_formula), "Algebra");
	    addFormula(db, res.getString(R.string.distance_formula), "Algebra");
	    addFormula(db, res.getString(R.string.radicand_simp), "Algebra");
	    addFormula(db, res.getString(R.string.slope), "Algebra");

	    addFormula(db, res.getString(R.string.area_formulas), "Geometry");
	    addFormula(db, res.getString(R.string.pythagorean_theorem),
		    "Geometry");
	    addFormula(db, res.getString(R.string.herons_formula), "Geometry");

	    addFormula(db, res.getString(R.string.law_of_sines), "Trigonometry");
	    addFormula(db, res.getString(R.string.law_of_cosines),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.law_of_tangents),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.product_sum_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.sum_product_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.power_reduction_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.sum_difference_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.even_odd_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.cofunction_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.pythagorean_identities),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.quotient_formulas),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.right_triangle_definitions),
		    "Trigonometry");
	    addFormula(db, res.getString(R.string.reciprocal_identities),
		    "Trigonometry");

	    addFormula(db, res.getString(R.string.ideal_gas_law), "Chemistry");
	    addFormula(db, res.getString(R.string.ideal_gas_const), "Chemistry");
	    addFormula(db, res.getString(R.string.functional_groups),
		    "Chemistry");

	    addFormula(db, res.getString(R.string.log_def), "Algebra");
	    addFormula(db, res.getString(R.string.log_identity), "Algebra");
	    addFormula(db, res.getString(R.string.log_prop), "Algebra");
	    addFormula(db, res.getString(R.string.sum_def), "Algebra");
	    addFormula(db, res.getString(R.string.sum_prop), "Algebra");

	    addFormula(db, res.getString(R.string.boyle_law), "Chemistry");
	    addFormula(db, res.getString(R.string.charles_law), "Chemistry");
	    addFormula(db, res.getString(R.string.gay_lussacs_law), "Chemistry");
	    addFormula(db, res.getString(R.string.daltons_law), "Chemistry");
	    addFormula(db, res.getString(R.string.combined_gas_law),
		    "Chemistry");

	    addFormula(db, res.getString(R.string.one_dimensional_motion),
		    "Physics");
	    addFormula(db, res.getString(R.string.force), "Physics");
	    addFormula(db, res.getString(R.string.torque), "Physics");
	    addFormula(db, res.getString(R.string.centripetal_force), "Physics");
	    addFormula(db, res.getString(R.string.centripetal_acceleration),
		    "Physics");
	    addFormula(db, res.getString(R.string.universal_gravitation),
		    "Physics");
	    addFormula(db,
		    res.getString(R.string.maximum_height_of_a_projectile),
		    "Physics");
	    addFormula(db,
		    res.getString(R.string.maximum_range_of_a_projectile),
		    "Physics");
	    addFormula(db, res.getString(R.string.coulombs_law), "Physics");
	    addFormula(db, res.getString(R.string.escape_velocity), "Physics");
	    addFormula(db, res.getString(R.string.momentum), "Physics");
	    addFormula(db, res.getString(R.string.work), "Physics");
	    addFormula(db, res.getString(R.string.ohms_law), "Physics");
	    addFormula(db, res.getString(R.string.particle_energy), "Physics");
	    addFormula(db, res.getString(R.string.resistance), "Physics");
	    addFormula(db, res.getString(R.string.bernoullis_law), "Physics");

	    addFormula(db, res.getString(R.string.planck_constant), "Physics");
	    addFormula(db, res.getString(R.string.speed_of_light), "Physics");
	    addFormula(db, res.getString(R.string.permittivity_of_free_space),
		    "Physics");
	    addFormula(db, res.getString(R.string.gravitation_constant),
		    "Physics");
	    addFormula(db, res.getString(R.string.gravitational_acceleration),
		    "Physics");

	    addFormula(db, res.getString(R.string.acid_base_eq), "Chemistry");

	    // 2
	    addPhysicsFormula(db, res.getString(R.string.angular_speed));
	    addPhysicsFormula(db, res.getString(R.string.average_acceleration));
	    addPhysicsFormula(db, res.getString(R.string.average_angular_accel));
	    addPhysicsFormula(db, res.getString(R.string.average_velocity));
	    addPhysicsFormula(db, res.getString(R.string.displacement));
	    addPhysicsFormula(db,
		    res.getString(R.string.gravitational_pot_energy));
	    addPhysicsFormula(db, res.getString(R.string.hookes_law));
	    addPhysicsFormula(db, res.getString(R.string.impulse));
	    addPhysicsFormula(db, res.getString(R.string.instantaneous_accel));
	    addPhysicsFormula(db,
		    res.getString(R.string.instantaneous_velocity));
	    addPhysicsFormula(db, res.getString(R.string.keplers_third_law));
	    addPhysicsFormula(db, res.getString(R.string.kinetic_energy));
	    addPhysicsFormula(db, res.getString(R.string.newtons_third_law));
	    addPhysicsFormula(db, res.getString(R.string.power));
	    addPhysicsFormula(db, res.getString(R.string.static_friction));
	    addPhysicsFormula(db, res.getString(R.string.tangent_accel));
	    addPhysicsFormula(db, res.getString(R.string.tangent_speed));
	    addPhysicsFormula(db, res.getString(R.string.vector_comp));
	    addPhysicsFormula(db, res.getString(R.string.velocity_equ));

	    // 3
	    addAlgebraicFormula(db, res.getString(R.string.vec_add_sub));
	    addAlgebraicFormula(db, res.getString(R.string.vec_def));
	    addAlgebraicFormula(db, res.getString(R.string.vec_dot));
	    addAlgebraicFormula(db, res.getString(R.string.vec_prop));
	    addAlgebraicFormula(db, res.getString(R.string.vec_scal));

	    // 4
	    addAlgebraicFormula(db, res.getString(R.string.de_moivre));
	    addAlgebraicFormula(db, res.getString(R.string.dot_prop));
	    addAlgebraicFormula(db, res.getString(R.string.euler_formula));
	    addFormula(db, res.getString(R.string.trig_form), "Trigonometry");
	    addAlgebraicFormula(db, res.getString(R.string.vec_proj));
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    // Recreates the database as to check for new formulas
	    db.execSQL("DROP TABLE IF EXISTS " + FORMULA_TABLE_NAME);
	    onCreate(db);
	}

	private long addFormula(SQLiteDatabase db, String formulaName,
		String category) {
	    ContentValues values = new ContentValues();
	    values.put(Formula.FORMULA_NAME, formulaName);
	    values.put(Formula.CATEGORY, category);
	    return db.insert(FORMULA_TABLE_NAME, null, values);
	}

	private long addPhysicsFormula(SQLiteDatabase db, String formulaName) {
	    return addFormula(db, formulaName, "Physics");
	}

	private long addAlgebraicFormula(SQLiteDatabase db, String formulaName) {
	    return addFormula(db, formulaName, "Algebra");
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
