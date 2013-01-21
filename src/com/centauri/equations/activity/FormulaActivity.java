/**
 * 
 */
package com.centauri.equations.activity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.provider.Equations.Formula;

/**
 * @author mohitd2000
 * 
 */
public abstract class FormulaActivity extends SherlockFragmentActivity {

    protected static boolean favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setupActionBar();
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

    protected abstract void setupActionBar();

    public abstract static class FormulaFragment extends SherlockFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Log.d("Base Fragment", "Id is " + getID());
	    Cursor cursor = getActivity().getContentResolver().query(
		    Formula.CONTENT_URI,
		    new String[] { Formula._ID, Formula.FAVORITE },
		    Formula._ID + "=" + getID(), null, null);
	    cursor.moveToFirst();
	    if (cursor != null && cursor.getCount() > 0)
		favorite = (cursor.getInt(cursor
			.getColumnIndexOrThrow(Formula.FAVORITE)) == 0) ? false
			: true;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    setHasOptionsMenu(true);
	    return inflater.inflate(getFragmentView(), container, false);
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    if (favorite) {
		MenuItem item = menu.findItem(R.id.menu_fav);
		item.setIcon(R.drawable.rate_star_big_on_holo_light);
	    }
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    inflater.inflate(R.menu.formula_menu, menu);
	    super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_fav:
		Uri uri = ContentUris.withAppendedId(Formula.CONTENT_URI,
			getID());
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

	protected abstract int getFragmentView();

	protected abstract long getID();
    }
}
