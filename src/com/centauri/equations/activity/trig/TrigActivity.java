package com.centauri.equations.activity.trig;

import android.os.Bundle;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class TrigActivity extends FormulaActivity {

    public static final String ACTION_SINES = "com.centauri.equations.action.LAW_OF_SINES";
    public static final String ACTION_COSINES = "com.centauri.equations.action.LAW_OF_COSINES";
    public static final String ACTION_TANGENTS = "com.centauri.equations.action.LAW_OF_TANGENTS";
    public static final String ACTION_PRODUCT_SUM = "com.centauri.equations.action.PRODUCT_TO_SUM";
    public static final String ACTION_SUM_PRODUCT = "com.centauri.equations.action.SUM_TO_PRODUCT";
    public static final String ACTION_POWER_REDUCTION = "com.centauri.equations.action.POWER_REDUCTION";
    public static final String ACTION_SUM_DIFFERENCE = "com.centauri.equations.action.SUM_DIFFERENCE";
    public static final String ACTION_EVEN_ODD = "com.centauri.equations.action.EVEN_ODD";
    public static final String ACTION_COFUNCTION = "com.centauri.equations.action.COFUNCTION";
    public static final String ACTION_PYTHAGOREAN_IDENTITY = "com.centauri.equations.action.PYTHAGOREAN_IDENTITY";
    public static final String ACTION_QUOTIENT = "com.centauri.equations.action.QUOTIENT";
    public static final String ACTION_RIGHT_TRIANGLE = "com.centauri.equations.action.RIGHT_TRIANGLE";
    public static final String ACTION_RECIPROCAL = "com.centauri.equations.action.RECIPROCAL";
    public static final String ACTION_TRIG_FORM = "com.centauri.equations.action.TRIG_FORM";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        final String action = getIntent().getAction();

        if (action.equals(ACTION_SINES)) {
            transaction.add(android.R.id.content, new LawOfSinesFragment());
        } else if (action.equals(ACTION_COSINES)) {
            transaction.add(android.R.id.content, new LawOfCosinesFragment());
        } else if (action.equals(ACTION_TANGENTS)) {
            transaction.add(android.R.id.content, new LawOfTangentsFragment());
        } else if (action.equals(ACTION_PRODUCT_SUM)) {
            transaction.add(android.R.id.content, new ProductToSumFragment());
        } else if (action.equals(ACTION_SUM_PRODUCT)) {
            transaction.add(android.R.id.content, new SumToProductFragment());
        } else if (action.equals(ACTION_POWER_REDUCTION)) {
            transaction.add(android.R.id.content, new PowerReductionFragment());
        } else if (action.equals(ACTION_SUM_DIFFERENCE)) {
            transaction.add(android.R.id.content, new SumDifferenceFragment());
        } else if (action.equals(ACTION_EVEN_ODD)) {
            transaction.add(android.R.id.content, new EvenOddFragment());
        } else if (action.equals(ACTION_COFUNCTION)) {
            transaction.add(android.R.id.content, new CofunctionFragment());
        } else if (action.equals(ACTION_PYTHAGOREAN_IDENTITY)) {
            transaction.add(android.R.id.content,
                    new PythagoreanIdentitiesFragment());
        } else if (action.equals(ACTION_QUOTIENT)) {
            transaction.add(android.R.id.content, new QuotientFragment());
        } else if (action.equals(ACTION_RIGHT_TRIANGLE)) {
            transaction.add(android.R.id.content, new RightTriangleFragment());
        } else if (action.equals(ACTION_RECIPROCAL)) {
            transaction.add(android.R.id.content, new ReciprocalFragment());
        } else if (action.equals(ACTION_TRIG_FORM)) {
            transaction.add(android.R.id.content, new TrigFormFragment());
        }

        transaction.commit();

    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[2]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class LawOfSinesFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_law_of_sines);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.law_of_sines);
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

    public static class LawOfCosinesFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_law_of_cosines);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.law_of_cosines);
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

    public static class LawOfTangentsFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_law_of_tangents);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.law_of_tangents);
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

    public static class ProductToSumFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_product_sum);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.product_sum_formulas);
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

    public static class SumToProductFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_sum_product);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.sum_product_formulas);
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

    public static class PowerReductionFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_power_reduce);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.power_reduction_formulas);
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

    public static class SumDifferenceFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_sum_difference);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.sum_difference_formulas);
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

    public static class EvenOddFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_even_odd);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.even_odd_formulas);
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

    public static class CofunctionFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_cofunction);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.cofunction_formulas);
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

    public static class PythagoreanIdentitiesFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_pythagorean_identities);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.pythagorean_identities);
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

    public static class QuotientFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_quotient);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.quotient_formulas);
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

    public static class RightTriangleFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_right_triangle);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.right_triangle_definitions);
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

    public static class ReciprocalFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_reciprocal);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.reciprocal_identities);
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

    public static class TrigFormFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_trig_trig_form);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.trig_form);
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
