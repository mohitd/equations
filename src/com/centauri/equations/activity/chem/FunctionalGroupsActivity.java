package com.centauri.equations.activity.chem;

import android.support.v4.app.Fragment;

import com.centauri.equations.R;
import com.centauri.equations.activity.ImageFormulaActivity;

public class FunctionalGroupsActivity extends ImageFormulaActivity {

    public static final String ACTION_FUNCTION_GROUPS = "com.centauri.equations.action.FUNCTION_GROUPS";

    /**
     * @see com.centauri.equations.activity.ImageFormulaActivity#getFragment()
     */
    @Override
    protected Fragment getFragment() {
        return new FunctionalGroupFragment();
    }

    public static class FunctionalGroupFragment extends ImageFormulaFragment {

        /*
         * (non-Javadoc)
         * @see FormulaActivity#getID()
         */
        @Override
        protected long getID() {
            return super.getID();
        }

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.table_functional_groups;
        }
    }
}
