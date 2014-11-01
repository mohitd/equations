package com.centauri.equations;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
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

    private ArrayAdapter<CharSequence> adapter;

    private SimpleCursorAdapter algebraAdapter;
    private SimpleCursorAdapter geometryAdapter;
    private SimpleCursorAdapter trigAdapter;
    private SimpleCursorAdapter chemAdapter;
    private SimpleCursorAdapter physicsAdapter;
    private SimpleCursorAdapter calcAdapter;
    private SimpleCursorAdapter statsAdapter;
    private SimpleCursorAdapter favoritesAdapter;
    SimpleCursorAdapter searchAdapter;

    private FormulaListFragment formulaListFragment;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AppRater.appLaunched(this);

        final String[] from = { Equations.Formula.FORMULA_NAME };
        final int[] to = { android.R.id.text1 };

        Cursor algebraCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Algebra\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor geometryCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Geometry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor trigCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Trigonometry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor chemCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Chemistry\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor physicsCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, "category=\"Physics\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor calcCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Calculus\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor statsCursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"Statistics\"", null, Equations.Formula.FORMULA_NAME + " ASC");
        Cursor favoritesCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");

        algebraAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, algebraCursor, from, to, 0);
        geometryAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, geometryCursor, from, to, 0);
        trigAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_activated_1,
                trigCursor, from, to, 0);
        chemAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_activated_1,
                chemCursor, from, to, 0);
        physicsAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, physicsCursor, from, to, 0);
        calcAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_activated_1,
                calcCursor, from, to, 0);
        statsAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_activated_1,
                statsCursor, from, to, 0);
        favoritesAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, favoritesCursor, from, to, 0);

        searchAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, null, from, to, 0);

        adapter = ArrayAdapter.createFromResource(getSupportActionBar().getThemedContext(),
                R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        formulaListFragment = (FormulaListFragment) getSupportFragmentManager().findFragmentById(
                R.id.formulasList);

        if (formulaListFragment == null) {
            formulaListFragment = new FormulaListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.formulasList, formulaListFragment).commit();
        }

        View details = findViewById(R.id.details);
        dualPane = details != null && details.getVisibility() == View.VISIBLE;

        setupActionBar();

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Gingerbread is the only version that has a black legacy menu
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD
                || Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD_MR1) {
            MenuItem prefs = menu.findItem(R.id.menu_settings);
            prefs.setIcon(R.drawable.ic_menu_settings_dark);
        }

        return true;
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
        switch (position) {
        case 0:
            formulaListFragment.getListView().setAdapter(algebraAdapter);
            break;
        case 1:
            formulaListFragment.getListView().setAdapter(geometryAdapter);
            break;
        case 2:
            formulaListFragment.getListView().setAdapter(trigAdapter);
            break;
        case 3:
            formulaListFragment.getListView().setAdapter(chemAdapter);
            break;
        case 4:
            formulaListFragment.getListView().setAdapter(physicsAdapter);
            break;
        case 5:
            formulaListFragment.getListView().setAdapter(calcAdapter);
            break;
        case 6:
            formulaListFragment.getListView().setAdapter(statsAdapter);
            break;
        case 7:
            refreshFavorites();
            formulaListFragment.getListView().setAdapter(favoritesAdapter);
            break;
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

            Fragment replaceFragment = FormulaMap.getFragment(id);
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
            Intent intent = FormulaMap.getIntent(id).putExtra(Formula._ID, id);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.shrink_fade_out);
        }
    }

    private void setupActionBar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(adapter, this);
    }

    private void refreshFavorites() {
        Cursor newFavoritesCursor = getContentResolver().query(Equations.Formula.CONTENT_URI,
                PROJECTION, Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        favoritesAdapter.changeCursor(newFavoritesCursor);
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
        startActivity(FormulaMap.getIntent(id).putExtra(Formula._ID, id));
        overridePendingTransition(R.anim.slide_in_right, R.anim.shrink_fade_out);
        return true;
    }
}