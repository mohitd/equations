/**
 * 
 */
package com.centauri.equations.activity.algebra;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;
import com.centauri.equations.provider.Equations.Formula;

/**
 * @author mohitd2000
 * 
 */
public class DeMoivreActivity extends Categories {
    public static final String ACTION_DE_MOIVRE = "com.centauri.equations.action.DE_MOIVRE";

    private static boolean favorite;
    private static String id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	FragmentTransaction transaction = getSupportFragmentManager()
		.beginTransaction();

	final String action = getIntent().getAction();

	if (action.equals(ACTION_DE_MOIVRE)) {
	    transaction.add(android.R.id.content, new DeMoivreFragment());
	}

	transaction.commit();

	id = getIntent().getData().getPathSegments().get(1);
	Cursor cursor = getContentResolver().query(Formula.CONTENT_URI,
		new String[] { Formula._ID, Formula.FAVORITE },
		Formula._ID + "=" + id, null, null);
	favorite = (cursor.getInt(cursor
		.getColumnIndexOrThrow(Formula.FAVORITE)) == 0) ? false : true;

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

    public static class DeMoivreFragment extends SherlockFragment {

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
	    image.setImageResource(R.drawable.img_alg_demoivre);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.de_moivre);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.actionbarsherlock.app.SherlockFragment#onCreateOptionsMenu(com
	 * .actionbarsherlock.view.Menu,
	 * com.actionbarsherlock.view.MenuInflater)
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    inflater.inflate(R.menu.formula_menu, menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.actionbarsherlock.app.SherlockFragment#onPrepareOptionsMenu(com
	 * .actionbarsherlock.view.Menu)
	 */
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    if (favorite) {
		MenuItem item = menu.findItem(R.id.menu_fav);
		item.setIcon(R.drawable.rate_star_big_on);
	    }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.actionbarsherlock.app.SherlockFragment#onOptionsItemSelected(
	 * com.actionbarsherlock.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_fav:
		Uri uri = ContentUris.withAppendedId(Formula.CONTENT_URI,
			Long.parseLong(id));
		ContentValues values = new ContentValues();
		if (favorite) {
		    favorite = false;
		    values.put(Formula.FAVORITE, 0);

		    Toast.makeText(
			    getActivity(),
			    getResources().getString(
				    R.string.removed_from_favorites),
			    Toast.LENGTH_SHORT).show();
		} else if (!favorite) {
		    favorite = true;
		    values.put(Formula.FAVORITE, 1);

		    Toast.makeText(
			    getActivity(),
			    getResources().getString(
				    R.string.added_to_favorites),
			    Toast.LENGTH_SHORT).show();
		}
		getActivity().getContentResolver().update(uri, values, null,
			null);
		getActivity().invalidateOptionsMenu();
		return true;

	    default:
		return false;
	    }
	}
    }
}
