package com.centauri.equations.activity.chem;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class FunctionalGroupsActivity extends FormulaActivity {

    public static final String ACTION_FUNCTION_GROUPS = "com.centauri.equations.action.FUNCTION_GROUPS";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new FunctionalGroupFragment())
		.commit();
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.functional_groups);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[3]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class FunctionalGroupFragment extends FormulaFragment {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.centauri.equations.activity.FormulaActivity#getID()
	 */
	@Override
	protected long getID() {
	    return FormulaMap
		    .getId(this, getActivity().getIntent().getAction());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.centauri.equations.activity.FormulaActivity.FormulaFragment#
	 * getFragmentView()
	 */
	@Override
	protected int getFragmentView() {
	    return R.layout.table_functional_groups;
	}
    }
}
