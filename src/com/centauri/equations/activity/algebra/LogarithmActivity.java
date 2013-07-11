package com.centauri.equations.activity.algebra;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class LogarithmActivity extends FormulaActivity {

    public static final String ACTION_LOG_DEF = "com.centauri.equations.action.LOG_DEF";
    public static final String ACTION_LOG_IDENTITY = "com.centauri.equations.action.LOG_IDENTITY";
    public static final String ACTION_LOG_PROP = "com.centauri.equations.action.LOG_PROP";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        final String action = getIntent().getAction();

        if (action.equals(ACTION_LOG_DEF)) {
            transaction.add(android.R.id.content, new LogarithmDefFragment());
        } else if (action.equals(ACTION_LOG_IDENTITY)) {
            transaction.add(android.R.id.content,
                    new LogarithmIdentityFragment());
        } else if (action.equals(ACTION_LOG_PROP)) {
            transaction.add(android.R.id.content, new LogarithmPropFragment());
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

    public static class LogarithmDefFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_alg_log_def);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.log_def);
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

    public static class LogarithmIdentityFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_alg_log_identity);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.log_identity);
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

    public static class LogarithmPropFragment extends FormulaFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ImageView image = (ImageView) getView().findViewById(
                    R.id.img_formula);
            image.setImageResource(R.drawable.img_alg_log_prop);
            ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                    .setTitle(R.string.log_prop);
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
