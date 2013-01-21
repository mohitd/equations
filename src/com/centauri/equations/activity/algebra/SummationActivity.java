package com.centauri.equations.activity.algebra;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class SummationActivity extends FormulaActivity {

    public static final String ACTION_SUM_DEF = "com.centauri.equations.action.SUM_DEF";
    public static final String ACTION_SUM_PROP = "com.centauri.equations.action.SUM_PROP";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	FragmentTransaction transaction = getSupportFragmentManager()
		.beginTransaction();

	final String action = getIntent().getAction();

	if (action.equals(ACTION_SUM_DEF)) {
	    transaction.add(android.R.id.content, new SummationDefFragment());
	} else if (action.equals(ACTION_SUM_PROP)) {
	    transaction.add(android.R.id.content, new SummationPropFragment());
	}

	transaction.commit();

    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class SummationDefFragment extends FormulaFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_sum_def);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.sum_def);
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

    public static class SummationPropFragment extends FormulaFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_sum_prop);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.sum_prop);
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
