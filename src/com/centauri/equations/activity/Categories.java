package com.centauri.equations.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.settings.SettingsActivity;
import com.centauri.equations.provider.Equations;

public class Categories extends SherlockFragmentActivity implements
        ActionBar.OnNavigationListener {

    private final String[] PROJECTION = { Equations.Formula._ID,
            Equations.Formula.FORMULA_NAME, Equations.Formula.FAVORITE };

    private static int spinnerPosition = 0;

    public static boolean dualPane = false;

    private ArrayAdapter<String> adapter;

    private SimpleCursorAdapter algebraAdapter;

    private SimpleCursorAdapter geometryAdapter;

    private SimpleCursorAdapter trigAdapter;

    private SimpleCursorAdapter chemAdapter;

    private SimpleCursorAdapter physicsAdapter;

    private SimpleCursorAdapter favoritesAdapter;

    private FormulasListFragment formulasFragment;

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
                android.R.layout.simple_list_item_1, algebraCursor, from, to, 0);
        geometryAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, geometryCursor, from, to,
                0);
        trigAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, trigCursor, from, to, 0);
        chemAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, chemCursor, from, to, 0);
        physicsAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, physicsCursor, from, to, 0);
        favoritesAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, favoritesCursor, from, to,
                0);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        formulasFragment = (FormulasListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.formulasList);

        if (formulasFragment == null) {
            formulasFragment = new FormulasListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.formulasList, formulasFragment).commit();
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

    /*
     * (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
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
            formulasFragment.getListView().setAdapter(algebraAdapter);
            break;
        case 1:
            formulasFragment.getListView().setAdapter(geometryAdapter);
            break;
        case 2:
            formulasFragment.getListView().setAdapter(trigAdapter);
            break;
        case 3:
            formulasFragment.getListView().setAdapter(chemAdapter);
            break;
        case 4:
            formulasFragment.getListView().setAdapter(physicsAdapter);
            break;
        case 5:
            formulasFragment.getListView().setAdapter(favoritesAdapter);
            break;
        }
        return true;
    }

    public static class FormulasListFragment extends SherlockListFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            if (dualPane)
                getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setListShown(true);

            setRetainInstance(true);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            if (dualPane) {
                getListView().setSelection(position);
                getListView().setItemChecked(position, true);
                Fragment replaceFragment = FormulaMap.getFragment(id);
                FragmentManager fragmentManager = getActivity()
                        .getSupportFragmentManager();
                Fragment currentFragment = fragmentManager
                        .findFragmentById(R.id.details);

                if (replaceFragment.equals(currentFragment)) return;

                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.details, FormulaMap.getFragment(id));
                transaction
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            } else {
                Intent intent = FormulaMap.getIntent(id);
                startActivity(intent);
            }
        }

    }

}