package com.centauri.equations;

import android.app.SearchManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.settings.SettingsActivity;

public class MainActivity extends ActionBarActivity implements
        ActionBar.OnNavigationListener, FormulaListFragment.OnFormulaSelectedListener, SearchView.OnQueryTextListener, SearchView.OnSuggestionListener {

    private final String[] PROJECTION = { Equations.Formula._ID, Equations.Formula.FORMULA_NAME,
        Equations.Formula.FAVORITE };

    private SearchView searchView;
    private MenuItem searchItem;

    private static boolean dualPane = false;
    private static int spinnerPosition = 0;
    private String[] categories;

    private ArrayAdapter<CharSequence> spinnerAdapter;

    private Cursor algebraCursor;
    private Cursor geometryCursor;
    private Cursor trigCursor;
    private Cursor chemCursor;
    private Cursor physicsCursor;
    private Cursor calcCursor;
    private Cursor statsCursor;
    private Cursor favoritesCursor;

    private SimpleCursorAdapter searchAdapter;

    private FormulaListFragment formulaListFragment;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] from = { Equations.Formula.FORMULA_NAME };
        final int[] to = { R.id.title };

        algebraCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Algebra\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        geometryCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Geometry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        trigCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Trigonometry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        chemCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Chemistry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        physicsCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Physics\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        calcCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Calculus\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        statsCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Statistics\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        favoritesCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");

        searchAdapter = new SimpleCursorAdapter(this,
                R.layout.row_item, null, from, to, 0);

        categories = getResources().getStringArray(R.array.categories);

        spinnerAdapter = ArrayAdapter.createFromResource(getSupportActionBar().getThemedContext(),
                R.array.categories, R.layout.spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        formulaListFragment = (FormulaListFragment) getSupportFragmentManager().findFragmentById(
                R.id.formulasList);

        if (formulaListFragment == null) {
            formulaListFragment = new FormulaListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.formulasList, formulaListFragment).commit();
        }

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_item, algebraCursor, from, to, 0);
        formulaListFragment.setListAdapter(adapter);

        View details = findViewById(R.id.details);
        dualPane = details != null && details.getVisibility() == View.VISIBLE;

        setupActionBar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setOnSuggestionListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_search:
            searchView.setIconified(false);
            return true;
        case R.id.menu_settings:
            startActivity(new Intent(SettingsActivity.ACTION_PREFERENCES));
            return true;
        }
        return false;
    }

    /**
     * @see android.support.v4.app.FragmentActivity#onStart()
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        if (spinnerPosition == 7) {
            refreshFavorites();
        }
    }

    public boolean onNavigationItemSelected(int position, long id) {
        spinnerPosition = position;
        Cursor c = null;
        switch (position) {
        case 0:
            c = algebraCursor;
            break;
        case 1:
            c = geometryCursor;
            break;
        case 2:
            c = trigCursor;
            break;
        case 3:
            c = chemCursor;
            break;
        case 4:
            c = physicsCursor;
            break;
        case 5:
            c = calcCursor;
            break;
        case 6:
            c = statsCursor;
            break;
        case 7:
            refreshFavorites();
            c = favoritesCursor;
            break;
        }

        if (c != null) {
            ((SimpleCursorAdapter) formulaListFragment.getListView().getAdapter()).swapCursor(c);
        }

        return true;
    }


    @Override
    public void onFormulaSelected(ListView listView, int position, long id) {
        if (dualPane) {
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listView.setSelection(position);

            Bundle arguments = new Bundle();
            arguments.putLong(Formula._ID, id);

            Fragment replaceFragment = new ImageFormulaActivity.ImageFormulaFragment();
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.details);

            if (replaceFragment.equals(currentFragment)) return;

            try {
                replaceFragment.setArguments(arguments);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                // Fragment is already active, so we can't set arguments
                replaceFragment.getArguments().putAll(arguments);
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.details, replaceFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Intent intent = new Intent(ImageFormulaActivity.ACTION_VIEW_FORMULA);
            intent.putExtra(Formula._ID, id);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.shrink_fade_out);
        }
    }

    private void setupActionBar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(spinnerAdapter, this);
    }

    private void refreshFavorites() {
        favoritesCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
    }

    private Cursor getCursorCategory(String category) {
        if (category.equals("Algebra")) {
            return algebraCursor;
        } else {
            return null;
        }
    }

    private int getSpinnerPosition(String category) {
        int pos = -1;
        for (int i = 0; i < categories.length; i++) {
            if (category.equals(categories[i])) pos = i;
        }
        return pos;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (BuildConfig.DEBUG) Log.v("Search", "Query=" + query);
        String selection = Equations.Formula.FORMULA_NAME + " LIKE ?";
        String[] selectionArgs = { "%" + query + "%" };
        Cursor result = getContentResolver().query(
                Equations.Formula.CONTENT_URI,
                new String[] { BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1,
                        BaseColumns._ID + " AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID },
                selection, selectionArgs, null);
        searchAdapter.changeCursor(result);
        searchView.setSuggestionsAdapter(searchAdapter);
        return true;
    }

    @Override
    public boolean onSuggestionSelect(int position) {
        return false;
    }

    @Override
    public boolean onSuggestionClick(int position) {
        long id = searchAdapter.getItemId(position);
        if (BuildConfig.DEBUG) Log.v("Search", "This id is " + id);
        searchView.setIconified(true);
        searchItem.collapseActionView();
        MenuItemCompat.collapseActionView(searchItem);

        if (dualPane) {
            Fragment replaceFragment = new ImageFormulaActivity.ImageFormulaFragment();
            Bundle arguments = new Bundle();
            arguments.putLong(Formula._ID, id);
            replaceFragment.setArguments(arguments);

            Uri uri = ContentUris.withAppendedId(Formula.CONTENT_URI, id);
            Cursor c = getContentResolver().query(uri, new String[] { Formula._ID, Formula.FORMULA_NAME, Formula.CATEGORY }, null, null, null);
            c.moveToFirst();

            String category = c.getString(c.getColumnIndexOrThrow(Formula.CATEGORY));
            Cursor categoryCursor = getCursorCategory(category);

            ((SimpleCursorAdapter) formulaListFragment.getListView().getAdapter()).swapCursor(categoryCursor);
            getSupportActionBar().setSelectedNavigationItem(getSpinnerPosition(category));

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.details, replaceFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();

        } else {
            startActivity(new Intent(ImageFormulaActivity.ACTION_VIEW_FORMULA).putExtra(Formula._ID, id));
            overridePendingTransition(R.anim.slide_in_right, R.anim.shrink_fade_out);
        }
        return true;
    }
}