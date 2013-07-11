package com.centauri.equations.activity;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;

import com.centauri.equations.BuildConfig;
import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.EquationsProvider;

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
            Cursor result = EquationsProvider.getSuggestions(query);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, result, from, to, 0);
            getListView().setAdapter(adapter);
        } else if (Intent.ACTION_VIEW.equals(action)) {
            Uri data = intent.getData();
            Cursor formulaCursor = getContentResolver().query(data, PROJECTION,
                    null, null, null);
            formulaCursor.moveToFirst();
            int id = formulaCursor.getInt(formulaCursor
                    .getColumnIndex(Equations.Formula._ID));
            startActivity(FormulaMap.getIntent(id));
        }

        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }
}
