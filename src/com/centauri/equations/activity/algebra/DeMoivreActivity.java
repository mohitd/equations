package com.centauri.equations.activity.algebra;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

/**
 * @author mohitd2000
 * 
 */
public class DeMoivreActivity extends FormulaActivity {

    public static final String ACTION_DE_MOIVRE = "com.centauri.equations.action.DE_MOIVRE";

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

    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[0]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class DeMoivreFragment extends FormulaFragment {

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
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }

        /*
         * (non-Javadoc)
         * @see FormulaActivity#getID()
         */
        @Override
        protected long getID() {
            return FormulaMap
                    .getId(this, getActivity().getIntent().getAction());
        }

    }
}
