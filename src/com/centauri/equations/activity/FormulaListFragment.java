/**
 * 
 */
package com.centauri.equations.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;

/**
 * @author mohitd2000
 * 
 */
public class FormulaListFragment extends SherlockListFragment {

    private OnFormulaSelectedListener callback;

    public interface OnFormulaSelectedListener {

        public void onFormulaSelected(ListView listView, int position, long id);
    }

    /**
     * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListShown(true);
        setRetainInstance(true);
    }

    /**
     * @see com.actionbarsherlock.app.SherlockListFragment#onAttach(android.app.Activity)
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (OnFormulaSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFormulaSelectedListener");
        }
    }

    /**
     * @see android.support.v4.app.ListFragment#onListItemClick(android.widget.ListView,
     *      android.view.View, int, long)
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        callback.onFormulaSelected(l, position, id);
    }

}
