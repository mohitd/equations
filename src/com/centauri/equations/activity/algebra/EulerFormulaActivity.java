/**
 * 
 */
package com.centauri.equations.activity.algebra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;

/**
 * @author mohitd2000
 * 
 */
public class EulerFormulaActivity extends Categories {
    public static final String ACTION_EULER_FORMULA = "com.centauri.equations.action.EULER_FORMULA";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	FragmentTransaction transaction = getSupportFragmentManager()
		.beginTransaction();

	final String action = getIntent().getAction();

	if (action.equals(ACTION_EULER_FORMULA)) {
	    transaction.add(android.R.id.content, new EulerFormulaFragment());
	}

	transaction.commit();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.centauri.equations.activity.Categories#onPrepareOptionsMenu(com.
     * actionbarsherlock.view.Menu)
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.centauri.equations.activity.Categories#onCreateOptionsMenu(com.
     * actionbarsherlock.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case android.R.id.home:
	    Intent parentIntent = new Intent(this, Categories.class);
	    parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
		    | Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(parentIntent);
	    finish();
	    return true;
	}
	return false;
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class EulerFormulaFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_euler_formula);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.euler_formula);
	}
    }
}
