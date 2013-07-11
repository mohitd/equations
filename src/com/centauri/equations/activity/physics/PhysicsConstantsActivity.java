package com.centauri.equations.activity.physics;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class PhysicsConstantsActivity extends FormulaActivity {

    public static final String ACTION_PLANCK_CONSTANT = "com.centauri.equations.action.PLANCK_CONSTANT";
    public static final String ACTION_SPEED_OF_LIGHT = "com.centauri.equations.action.SPEED_OF_LIGHT";
    public static final String ACTION_PERMITTIVITY = "com.centauri.equations.action.PERMITTIVITY";
    public static final String ACTION_GRAVITATION_CONSTANT = "com.centauri.equations.action.GRAVITATION_CONSTANT";
    public static final String ACTION_GRAVITATION_ACCEL = "com.centauri.equations.action.GRAVITATIONAL_ACCEL";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        final String action = getIntent().getAction();

        if (action.equals(ACTION_PLANCK_CONSTANT)) {
            transaction
                    .add(android.R.id.content, new PlancksConstantFragment());
        } else if (action.equals(ACTION_SPEED_OF_LIGHT)) {
            transaction.add(android.R.id.content, new SpeedOfLightFragment());
        } else if (action.equals(ACTION_PERMITTIVITY)) {
            transaction.add(android.R.id.content, new PermittivityFragment());
        } else if (action.equals(ACTION_GRAVITATION_CONSTANT)) {
            transaction.add(android.R.id.content,
                    new GravitationConstantFragment());
        } else if (action.equals(ACTION_GRAVITATION_ACCEL)) {
            transaction.add(android.R.id.content,
                    new GravitationAccelFragment());
        }

        transaction.commit();

    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[4]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class PlancksConstantFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_phy_planck_constant);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.planck_constant);
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

    public static class SpeedOfLightFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_phy_speed_of_light);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.speed_of_light);
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

    public static class PermittivityFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_phy_permittivity);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.permittivity_of_free_space);
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

    public static class GravitationConstantFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_phy_gravitation_constant);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.gravitation_constant);
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

    public static class GravitationAccelFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_phy_gravitational_accel);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.gravitational_acceleration);
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
