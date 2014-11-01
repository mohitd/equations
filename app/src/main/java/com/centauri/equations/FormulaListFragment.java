/**
 * 
 */
package com.centauri.equations;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

/**
 * @author mohitd2000
 * 
 */
public class FormulaListFragment extends ListFragment {

    private int top, index = 0;

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
     * @see android.support.v4.app.Fragment#onPause()
     */
    @Override
    public void onPause() {
        super.onPause();
        index = getListView().getFirstVisiblePosition();
        View v = getListView().getChildAt(0);
        top = (v == null) ? 0 : v.getTop();
    }

    /**
     * @see android.support.v4.app.Fragment#onResume()
     */
    @Override
    public void onResume() {
        super.onResume();
        getListView().setSelectionFromTop(index, top);
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
