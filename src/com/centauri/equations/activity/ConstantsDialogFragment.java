/**
 * 
 */
package com.centauri.equations.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.centauri.equations.R;

/**
 * @author mohitd2000
 * 
 */
public class ConstantsDialogFragment extends DialogFragment implements
        OnItemClickListener {

    /**
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
     *      android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.constantsdialog, container, false);
        ListView listview = (ListView) view.findViewById(R.id.lv_constants);
        listview.setOnItemClickListener(this);
        return view;
    }

    /**
     * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView,
     *      android.view.View, int, long)
     */
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {

    }

}
