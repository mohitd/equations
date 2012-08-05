package com.centauri.equations.activity.chem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;

public class AcidBaseActivity extends Categories {

    public static final String ACTION_ACID_BASE_EQUATIONS = "com.centauri.equations.action.ACID_BASE_EQUATIONS";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new AcidBaseFragment()).commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
	return true;
    }

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
	getSupportActionBar().setTitle(R.string.acid_base_eq);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[3]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class AcidBaseFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_formula))
		    .setImageResource(R.drawable.img_chem_acid_base);
	}
    }

}
