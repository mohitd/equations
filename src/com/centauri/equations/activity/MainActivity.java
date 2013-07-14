package com.centauri.equations.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.settings.SettingsActivity;
import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.Equations.Formula;

public class MainActivity extends SherlockFragmentActivity implements
        ActionBar.OnNavigationListener,
        FormulaListFragment.OnFormulaSelectedListener {

    private final String[] PROJECTION = { Equations.Formula._ID,
            Equations.Formula.FORMULA_NAME, Equations.Formula.FAVORITE };

    private static final String KEY_LIST_STATE = "listViewState";

    private static int spinnerPosition = 0;

    private static boolean dualPane = false;

    private Parcelable listViewState = null;

    private ArrayAdapter<String> adapter;

    private SimpleCursorAdapter algebraAdapter;
    private SimpleCursorAdapter geometryAdapter;
    private SimpleCursorAdapter trigAdapter;
    private SimpleCursorAdapter chemAdapter;
    private SimpleCursorAdapter physicsAdapter;
    private SimpleCursorAdapter favoritesAdapter;

    private FormulaListFragment formulaListFragment;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AppRater.appLaunched(this);

        String[] categories = getResources().getStringArray(R.array.categories);
        final String[] from = { Equations.Formula.FORMULA_NAME };
        final int[] to = { android.R.id.text1 };

        Cursor algebraCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"" + categories[0] + "\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        Cursor geometryCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"" + categories[1] + "\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        Cursor trigCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"" + categories[2] + "\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        Cursor chemCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"" + categories[3] + "\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        Cursor physicsCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                "category=\"" + categories[4] + "\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        Cursor favoritesCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");

        algebraAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, algebraCursor,
                from, to, 0);
        geometryAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, geometryCursor,
                from, to, 0);
        trigAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, trigCursor,
                from, to, 0);
        chemAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, chemCursor,
                from, to, 0);
        physicsAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, physicsCursor,
                from, to, 0);
        favoritesAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_activated_1, favoritesCursor,
                from, to, 0);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        formulaListFragment = (FormulaListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.formulasList);

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
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_search:
            onSearchRequested();
            return true;
        case R.id.menu_settings:
            startActivity(new Intent(SettingsActivity.ACTION_PREFERENCES));
            return true;
        }
        return false;
    }

    /**
     * @see com.actionbarsherlock.app.SherlockFragmentActivity#onSaveInstanceState(android.os.Bundle)
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        listViewState = formulaListFragment.getListView().onSaveInstanceState();
        outState.putParcelable(KEY_LIST_STATE, listViewState);
    }

    /**
     * @see com.actionbarsherlock.app.SherlockFragmentActivity#onRestoreInstanceState(android.os.Bundle)
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listViewState = savedInstanceState.getParcelable(KEY_LIST_STATE);
    }

    /*
     * (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (listViewState != null)
            formulaListFragment.getListView().onRestoreInstanceState(
                    listViewState);
        listViewState = null;
        setupActionBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void setupActionBar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(adapter, this);
        getSupportActionBar().setSelectedNavigationItem(spinnerPosition);
    }

    public boolean onNavigationItemSelected(int position, long id) {
        spinnerPosition = position;
        Cursor newFavoritesCursor = getContentResolver().query(
                Equations.Formula.CONTENT_URI, PROJECTION,
                Equations.Formula.FAVORITE + " = \"1\"", null,
                Equations.Formula.FORMULA_NAME + " ASC");
        favoritesAdapter.changeCursor(newFavoritesCursor);
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
            formulaListFragment.getListView().setAdapter(favoritesAdapter);
            break;
        }

        return true;
    }

    /**
     * @see com.centauri.equations.activity.FormulaListFragment.OnFormulaSelectedListener#onFormulaSelected(long)
     */
    @Override
    public void onFormulaSelected(ListView listView, int position, long id) {
        if (dualPane) {
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listView.setSelection(position);

            Bundle arguments = new Bundle();
            arguments.putLong(Formula._ID, id);

            Fragment replaceFragment = FormulaMap.getFragment(id);
            Fragment currentFragment = getSupportFragmentManager()
                    .findFragmentById(R.id.details);

            if (replaceFragment.equals(currentFragment)) return;

            try {
                replaceFragment.setArguments(arguments);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                // Fragment is already active, so we can't set arguments
                replaceFragment.getArguments().putAll(arguments);
            }

            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            transaction.replace(R.id.details, replaceFragment);
            transaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Intent intent = FormulaMap.getIntent(id).putExtra(Formula._ID, id);
            startActivity(intent);
        }
    }
}