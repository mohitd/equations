/**
 * 
 */
package com.centauri.equations.activity.physics;

import android.os.Bundle;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

/**
 * @author mohitd2000
 * 
 */
public class TangentAccelActivity extends FormulaActivity {
    public static final String ACTION_TANGENT_ACCEL = "com.centauri.equations.action.TANGENT_ACCEL";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new TangentAccelFragment()).commit();
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.tangent_accel);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[4]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class TangentAccelFragment extends FormulaFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_formula))
		    .setImageResource(R.drawable.img_phy_tangential_acceleration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.centauri.equations.activity.FormulaActivity.FormulaFragment#
	 * getFragmentView()
	 */
	@Override
	protected int getFragmentView() {
	    return R.layout.single_image;
	}

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
    }
}
