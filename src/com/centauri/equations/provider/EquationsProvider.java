package com.centauri.equations.provider;

import android.app.AlertDialog;
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
import android.util.Log;

import com.centauri.equations.BuildConfig;

import java.io.IOException;
import java.util.HashMap;

public class EquationsProvider extends ContentProvider {

    private static final String TAG = EquationsProvider.class.getSimpleName();

    // Database
    private static final String DATABASE_NAME = "formula.db";
    private static final String FORMULA_TABLE_NAME = "formula";
    private static final int DATABASE_VERSION = 10;
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
        uriMatcher
                .addURI(Equations.AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY, SEARCH_SUGGEST);
        uriMatcher.addURI(Equations.AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY + "/*",
                SEARCH_SUGGEST);

        projectionMap = new HashMap<String, String>();
        projectionMap.put(Equations.Formula._ID, Equations.Formula._ID);
        projectionMap.put(SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID, "_id AS "
                + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
        projectionMap.put(SearchManager.SUGGEST_COLUMN_SHORTCUT_ID, "_id AS "
                + SearchManager.SUGGEST_COLUMN_SHORTCUT_ID);
        projectionMap.put(Equations.Formula.FORMULA_NAME, Equations.Formula.FORMULA_NAME);
        projectionMap.put(Equations.Formula.CATEGORY, Equations.Formula.CATEGORY);
        projectionMap.put(Equations.Formula.FAVORITE, Equations.Formula.FAVORITE);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            if (BuildConfig.DEBUG) Log.w(TAG, "Recreating the database...");
            try {
                DbUtils.executeSqlScript(context, db, "Equations.sql");
            } catch (IOException e) {
                e.printStackTrace();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Unable to create the database!");
                builder.create().show();
                return;
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Recreates the database as to check for new formulas
            db.execSQL("DROP TABLE IF EXISTS " + FORMULA_TABLE_NAME);
            onCreate(db);
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
            count = db.delete(FORMULA_TABLE_NAME, Equations.Formula._ID + "=" + formulaId
                    + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""),
                    selectionArgs);
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
            return Equations.Formula.CONTENT_TYPE;
        case FORMULA_ID:
            return Equations.Formula.CONTENT_ITEM_TYPE;
        default:
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (uriMatcher.match(uri) != FORMULAS) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        if (values.getAsString(Equations.Formula.FORMULA_NAME).length() == 0) throw new IllegalArgumentException(
                "Cannot have an empty formula name!");
        if (values.getAsString(Equations.Formula.CATEGORY).length() == 0) throw new IllegalArgumentException(
                "Cannot have an empty category name!");

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long rowId = db.insert(FORMULA_TABLE_NAME, null, values);
        if (rowId > 0) {
            Uri formulaUri = ContentUris.withAppendedId(Equations.Formula.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(uri, null);
            return formulaUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) {
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
            qb.appendWhere(Equations.Formula._ID + "=" + uri.getPathSegments().get(1));
            break;
        case SEARCH_SUGGEST:
            if (selectionArgs == null) {
                throw new IllegalArgumentException("selectionArgs cannot be null!");
            }
            return getSuggestions(selectionArgs[0]);
        default:
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    public static Cursor getSuggestions(String query) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = Equations.Formula.FORMULA_NAME + " LIKE ?";
        String[] selectionArgs = { "%" + query + "%" };
        Cursor cursor = db.query(FORMULA_TABLE_NAME, new String[] { BaseColumns._ID,
            SearchManager.SUGGEST_COLUMN_TEXT_1,
            BaseColumns._ID + " AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID }, selection,
                selectionArgs, null, null, null);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int count;

        switch (uriMatcher.match(uri)) {
        case FORMULAS:
            count = db.update(FORMULA_TABLE_NAME, values, selection, selectionArgs);
            break;
        case FORMULA_ID:
            String formulaId = uri.getPathSegments().get(1);
            count = db.update(FORMULA_TABLE_NAME, values, Equations.Formula._ID + "=" + formulaId
                    + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""),
                    selectionArgs);
            break;
        default:
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

}
