package com.centauri.equations;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;

import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.Equations.Formula;

public class SearchActivity extends ListActivity {

    private static final String[] PROJECTION = { Equations.Formula._ID, };

    private String[] from = { Equations.Formula.FORMULA_NAME };

    private int[] to = { android.R.id.text1 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {

        final String action = intent.getAction();

        if (Intent.ACTION_SEARCH.equals(action)) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            if (BuildConfig.DEBUG) Log.v("Search", "Query=" + query);
            String selection = Equations.Formula.FORMULA_NAME + " LIKE ?";
            String[] selectionArgs = { "%" + query + "%" };
            Cursor result = getContentResolver().query(
                    Equations.Formula.CONTENT_URI,
                    new String[] { BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1,
                        BaseColumns._ID + " AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID },
                    selection, selectionArgs, null);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, result, from, to, 0);
            getListView().setAdapter(adapter);
        } else if (Intent.ACTION_VIEW.equals(action)) {
            Uri data = intent.getData();
            Cursor formulaCursor = getContentResolver().query(data, PROJECTION, null, null, null);
            formulaCursor.moveToFirst();
            long id = formulaCursor.getLong(formulaCursor.getColumnIndex(Equations.Formula._ID));
            if (BuildConfig.DEBUG) Log.v("Search", "This id is " + id);
            startActivity(new Intent(ImageFormulaActivity.ACTION_VIEW_FORMULA).putExtra(Formula._ID, id));
            overridePendingTransition(R.anim.slide_in_right, R.anim.shrink_fade_out);
        }

        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }
}
