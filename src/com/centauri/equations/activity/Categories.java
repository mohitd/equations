package com.centauri.equations.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.algebra.QuadraticFormulaActivity.QuadraticFormulaFragment;
import com.centauri.equations.activity.settings.SettingsActivity;
import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.Equations.Formula;

public class Categories extends SherlockFragmentActivity implements
	OnNavigationListener {

    private final String[] PROJECTION = { Formula._ID, Formula.FORMULA_NAME, };

    private final String[] from = { Formula.FORMULA_NAME };

    private final int[] to = { android.R.id.text1 };

    private static int spinnerPosition = 0;

    private static boolean dualPane = false;

    private SpinnerAdapter adapter;

    private OnNavigationListener listener;

    private SimpleCursorAdapter algebraAdapter;

    private SimpleCursorAdapter geometryAdapter;

    private SimpleCursorAdapter trigAdapter;

    private SimpleCursorAdapter chemAdapter;

    private SimpleCursorAdapter physicsAdapter;

    private FormulasListFragment formulasFragment;

    private QuadraticFormulaFragment formulaFragment;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	String[] categories = getResources().getStringArray(R.array.categories);

	Cursor algebraCursor = getContentResolver().query(
		Equations.Formula.CONTENT_URI, PROJECTION,
		"category=\"" + categories[0] + "\"", null, null);
	Cursor geometryCursor = getContentResolver().query(
		Equations.Formula.CONTENT_URI, PROJECTION,
		"category=\"" + categories[1] + "\"", null, null);
	Cursor trigCursor = getContentResolver().query(
		Equations.Formula.CONTENT_URI, PROJECTION,
		"category=\"" + categories[2] + "\"", null, null);
	Cursor chemCursor = getContentResolver().query(
		Equations.Formula.CONTENT_URI, PROJECTION,
		"category=\"" + categories[3] + "\"", null, null);
	Cursor physicsCursor = getContentResolver().query(
		Equations.Formula.CONTENT_URI, PROJECTION,
		"category=\"" + categories[4] + "\"", null, null);

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

	ArrayAdapter<String> _adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, categories);
	_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

	listener = this;
	adapter = _adapter;

	formulasFragment = (FormulasListFragment) getSupportFragmentManager()
		.findFragmentById(R.id.formulasList);
	formulaFragment = (QuadraticFormulaFragment) getSupportFragmentManager()
		.findFragmentById(R.id.details);

	if (formulasFragment == null) {
	    formulasFragment = new FormulasListFragment();
	    getSupportFragmentManager().beginTransaction()
		    .add(R.id.formulasList, formulasFragment).commit();
	}

	if (formulaFragment == null && findViewById(R.id.details) != null) {
	    formulaFragment = new QuadraticFormulaFragment();
	    getSupportFragmentManager().beginTransaction()
		    .add(R.id.details, formulaFragment).commit();
	}

	View details = findViewById(R.id.details);
	dualPane = details != null && details.getVisibility() == View.VISIBLE;

	setupActionBar();

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
     * 
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
	getSupportActionBar().setListNavigationCallbacks(adapter, listener);
	getSupportActionBar().setSelectedNavigationItem(spinnerPosition);
    }

    public boolean onNavigationItemSelected(int position, long id) {
	Categories.spinnerPosition = position;
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
	}
	return false;
    }

    public static class FormulasListFragment extends SherlockListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    if (dualPane)
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	    setListShown(true);
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

		if (replaceFragment.equals(currentFragment))
		    return;

		android.support.v4.app.FragmentTransaction transaction = getActivity()
			.getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.details, FormulaMap.getFragment(id));
		transaction
			.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaction.commit();
	    } else {
		Intent intent = FormulaMap.getIntent(id);
		startActivity(intent);
	    }
	}

    }

}