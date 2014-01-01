/**
 * 
 */
package com.centauri.equations.activity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.centauri.equations.BuildConfig;
import com.centauri.equations.R;
import com.centauri.equations.provider.Equations;
import com.centauri.equations.provider.Equations.Formula;

/**
 * @author mohitd2000
 * 
 */
public class ImageFormulaActivity extends SherlockFragmentActivity {

    public static final String ACTION_VIEW_FORMULA = "com.centauri.equations.action.VIEW_FORMULA";

    private static final String[] PROJECTION = { Equations.Formula._ID,
        Equations.Formula.FORMULA_NAME, Equations.Formula.CATEGORY, };

    /**
     * @see com.centauri.equations.activity.BaseFormulaActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long id = getIntent().getLongExtra(Formula._ID, 0);

        if (savedInstanceState == null) {
            Fragment fragment = getFragment();
            Bundle arguments = new Bundle();
            arguments.putLong(Formula._ID, id);
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment)
                    .commit();
        }

        Cursor cursor = getContentResolver().query(Equations.Formula.CONTENT_URI, PROJECTION,
                Equations.Formula._ID + "=" + id, null, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String formulaName = cursor.getString(cursor
                    .getColumnIndexOrThrow(Formula.FORMULA_NAME));
            String formulaCategory = cursor.getString(cursor
                    .getColumnIndexOrThrow(Formula.CATEGORY));
            getSupportActionBar().setTitle(formulaName);
            getSupportActionBar().setSubtitle(formulaCategory);
        }
        cursor.close();

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected Fragment getFragment() {
        return new ImageFormulaFragment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class ImageFormulaFragment extends SherlockFragment {

        private static final String[] PROJECTION = { Equations.Formula._ID,
            Equations.Formula.FAVORITE };

        private boolean favorite;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (BuildConfig.DEBUG) Log.d("Base Fragment", "Id is " + getID());
            Cursor cursor = getActivity().getContentResolver().query(Equations.Formula.CONTENT_URI,
                    PROJECTION, Equations.Formula._ID + "=" + getID(), null, null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                favorite = (cursor.getInt(cursor.getColumnIndexOrThrow(Equations.Formula.FAVORITE)) != 0);
            }
            cursor.close();

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            setHasOptionsMenu(true);
            return inflater.inflate(getFragmentView(), container, false);
        }

        @Override
        public void onPrepareOptionsMenu(Menu menu) {
            MenuItem item = menu.findItem(R.id.menu_fav);
            if (favorite) {
                item.setIcon(R.drawable.ic_action_rating_important);
            } else {
                item.setIcon(R.drawable.ic_action_rating_not_important);
            }
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            super.onCreateOptionsMenu(menu, inflater);
            inflater.inflate(R.menu.formula_menu, menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
            case R.id.menu_fav:
                Uri uri = ContentUris.withAppendedId(Equations.Formula.CONTENT_URI, getID());
                ContentValues values = new ContentValues();
                if (favorite) {
                    favorite = false;
                    values.put(Equations.Formula.FAVORITE, 0);

                    Toast.makeText(getActivity(),
                            getResources().getString(R.string.removed_from_favorites),
                            Toast.LENGTH_SHORT).show();
                } else if (!favorite) {
                    favorite = true;
                    values.put(Equations.Formula.FAVORITE, 1);

                    Toast.makeText(getActivity(),
                            getResources().getString(R.string.added_to_favorites),
                            Toast.LENGTH_SHORT).show();
                }
                getActivity().getContentResolver().update(uri, values, null, null);
                getActivity().invalidateOptionsMenu();
                return true;

            default:
                return super.onOptionsItemSelected(item);
            }
        }

        /**
         * @see android.support.v4.app.Fragment#onStart()
         */
        @Override
        public void onStart() {
            super.onStart();
            ImageView imageView = (ImageView) getView().findViewById(R.id.img_formula);
            int imageResource = FormulaMap.getImage(getID());
            if (imageResource != 0) imageView.setImageResource(imageResource);
        }

        protected int getFragmentView() {
            return R.layout.single_image;
        }

        protected long getID() {
            return getArguments().getLong(Formula._ID);
        }

    }
}
