package com.centauri.equations.activity.chem;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class GasLawsActivity extends FormulaActivity {

    public static final String ACTION_GAS_CONSTANT = "com.centauri.equations.action.GAS_CONSTANT";
    public static final String ACTION_BOYLE_LAW = "com.centauri.equations.action.BOYLES_LAW";
    public static final String ACTION_CHARLES_LAW = "com.centauri.equations.action.CHARLES_LAW";
    public static final String ACTION_GAY_LUSSAC_LAW = "com.centauri.equations.action.GAY_LUSSAC_LAW";
    public static final String ACTION_DALTON_LAW = "com.centauri.equations.action.DALTON_LAW";
    public static final String ACTION_COMBINED_LAW = "com.centauri.equations.action.COMBINED_LAW";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        String action = getIntent().getAction();

        if (action.equals(ACTION_GAS_CONSTANT)) {
            transaction.add(android.R.id.content, new GasConstantFragment());
        } else if (action.equals(ACTION_BOYLE_LAW)) {
            transaction.add(android.R.id.content, new BoylesLawFragment());
        } else if (action.equals(ACTION_CHARLES_LAW)) {
            transaction.add(android.R.id.content, new CharlesLawFragment());
        } else if (action.equals(ACTION_GAY_LUSSAC_LAW)) {
            transaction.add(android.R.id.content, new GayLussacLawFragment());
        } else if (action.equals(ACTION_DALTON_LAW)) {
            transaction.add(android.R.id.content, new DaltonsFragment());
        } else if (action.equals(ACTION_COMBINED_LAW)) {
            transaction.add(android.R.id.content, new CombinedGasLawFragment());
        }

        transaction.commit();
    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[3]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class GasConstantFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_gas_constant);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.ideal_gas_const);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

    public static class BoylesLawFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_boyle);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.boyle_law);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

    public static class CharlesLawFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_charles);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.charles_law);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

    public static class GayLussacLawFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_gay_lussac);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.gay_lussacs_law);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

    public static class DaltonsFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_dalton);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.daltons_law);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

    public static class CombinedGasLawFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_chem_combined_gas);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.combined_gas_law);
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

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }
    }

}
