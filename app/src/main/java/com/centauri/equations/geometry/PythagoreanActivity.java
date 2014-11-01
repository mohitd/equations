package com.centauri.equations.geometry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.centauri.equations.ImageFormulaActivity;
import com.centauri.equations.R;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.shape2d.Triangle;

public class PythagoreanActivity extends ImageFormulaActivity {

    public static final String ACTION_PYTHAGOREAN = "com.centauri.equations.action.PYTHAGOREAN";

    @Override
    protected Fragment getFragment() {
        return new PythagoreanFragment();
    }

    public static class PythagoreanFragment extends ImageFormulaFragment implements
            OnClickListener, OnItemSelectedListener {

        private ArrayAdapter<CharSequence> adapter;
        private Spinner spinner;

        private EditText a_txt, b_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((Button) getView().findViewById(R.id.area_solve)).setOnClickListener(this);

            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.pythagorean,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner = (Spinner) getView().findViewById(R.id.area_polygon);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            spinner.setSelection(0);

            a_txt = (EditText) getView().findViewById(R.id.area_a);
            b_txt = (EditText) getView().findViewById(R.id.area_b);

            a_txt.setVisibility(View.VISIBLE);
            b_txt.setVisibility(View.VISIBLE);
            ((EditText) getView().findViewById(R.id.area_c)).setVisibility(View.GONE);
        }

        public void onClick(View view) {

            if (a_txt.getText().toString().equals("") || b_txt.getText().toString().equals("")) {
                Toast.makeText(getActivity(), getResources().getString(R.string.blank_field),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int position = spinner.getSelectedItemPosition();
            double a = 0;
            double b = 0;
            try {
                a = Double.parseDouble(a_txt.getText().toString());
                b = Double.parseDouble(b_txt.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), getResources().getString(R.string.number_too_large),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Triangle triangle;

            switch (position) {
            case 0:
                triangle = new Triangle(0, a, b);
                break;
            case 1:
                triangle = new Triangle(a, 0, b);
                break;
            case 2:
                triangle = new Triangle(a, b, 0);
                break;
            default:
                triangle = new Triangle(0, 0, 0);
                break;
            }

            Complex[] sides = triangle.getSides();

            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("Answer");
            dialog.setMessage(sides[0].toString() + "," + sides[1].toString() + ","
                    + sides[2].toString());
            dialog.setOnCancelListener(new OnCancelListener() {

                public void onCancel(DialogInterface dialog) {
                    clear();
                }
            });
            dialog.create().show();
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
            case 0:
                a_txt.setHint(R.string.b);
                b_txt.setHint(R.string.c);
                break;
            case 1:
                a_txt.setHint(R.string.a);
                b_txt.setHint(R.string.c);
                break;
            case 2:
                a_txt.setHint(R.string.a);
                b_txt.setHint(R.string.b);
                break;
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }

        private void clear() {
            a_txt.setText("");
            b_txt.setText("");
        }

        @Override
        protected int getFragmentView() {
            return R.layout.variable;
        }

        @Override
        protected long getID() {
            return getArguments().getLong(Formula._ID);
        }
    }
}