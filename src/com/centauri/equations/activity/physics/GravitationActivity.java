package com.centauri.equations.activity.physics;

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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.centauri.equations.R;
import com.centauri.equations.activity.ImageFormulaActivity;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.physics.Physics;

public class GravitationActivity extends ImageFormulaActivity {

    public static final String ACTION_GRAVITATION = "com.centauri.equations.action.GRAVITATION";

    /**
     * @see com.centauri.equations.activity.ImageFormulaActivity#getFragment()
     */
    @Override
    protected Fragment getFragment() {
        return new GravitationFragment();
    }

    public static class GravitationFragment extends ImageFormulaFragment implements
            OnClickListener, OnItemSelectedListener {

        private ArrayAdapter<CharSequence> adapter;
        private Spinner spinner;

        private EditText a_txt, b_txt, c_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((ImageView) getView().findViewById(R.id.img_formula))
                    .setImageResource(R.drawable.img_phy_universal_gravitation);

            a_txt = ((EditText) getView().findViewById(R.id.area_a));
            b_txt = ((EditText) getView().findViewById(R.id.area_b));
            c_txt = ((EditText) getView().findViewById(R.id.area_c));

            a_txt.setHint(getResources().getStringArray(R.array.gravitation)[1]);
            b_txt.setHint(getResources().getStringArray(R.array.gravitation)[2]);
            c_txt.setHint(getResources().getStringArray(R.array.gravitation)[3]);
            c_txt.setVisibility(View.VISIBLE);

            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.gravitation,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner = (Spinner) getView().findViewById(R.id.area_polygon);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(this);
            ((Button) getView().findViewById(R.id.area_solve)).setOnClickListener(this);
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String variable = adapter.getItem(position).toString();

            if (variable.equals(getResources().getStringArray(R.array.gravitation)[0])) {
                a_txt.setHint(getResources().getStringArray(R.array.gravitation)[1]);
                b_txt.setHint(getResources().getStringArray(R.array.gravitation)[2]);
                c_txt.setHint(getResources().getStringArray(R.array.gravitation)[3]);
            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[1])) {
                a_txt.setHint(getResources().getStringArray(R.array.gravitation)[0]);
                b_txt.setHint(getResources().getStringArray(R.array.gravitation)[2]);
                c_txt.setHint(getResources().getStringArray(R.array.gravitation)[3]);
            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[2])) {
                a_txt.setHint(getResources().getStringArray(R.array.gravitation)[0]);
                b_txt.setHint(getResources().getStringArray(R.array.gravitation)[1]);
                c_txt.setHint(getResources().getStringArray(R.array.gravitation)[3]);
            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[3])) {
                a_txt.setHint(getResources().getStringArray(R.array.gravitation)[0]);
                b_txt.setHint(getResources().getStringArray(R.array.gravitation)[1]);
                c_txt.setHint(getResources().getStringArray(R.array.gravitation)[2]);
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }

        public void onClick(View v) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle(getResources().getString(R.string.answer));

            if (a_txt.getText().toString().equals("") || b_txt.getText().toString().equals("")
                    || c_txt.getText().toString().equals("")) {
                Toast.makeText(getActivity(), getResources().getString(R.string.blank_field),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            double a = 0;
            double b = 0;
            double c = 0;
            try {
                a = Double.parseDouble(a_txt.getText().toString());
                b = Double.parseDouble(b_txt.getText().toString());
                c = Double.parseDouble(c_txt.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), getResources().getString(R.string.number_too_large),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String variable = spinner.getSelectedItem().toString();
            Complex result = null;

            if (variable.equals(getResources().getStringArray(R.array.gravitation)[0])) {
                result = Physics.universalGravitation(Double.NEGATIVE_INFINITY, a, b, c);

            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[1])) {
                result = Physics.universalGravitation(a, Double.NEGATIVE_INFINITY, b, c);
            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[2])) {
                result = Physics.universalGravitation(a, b, Double.NEGATIVE_INFINITY, c);
            } else if (variable.equals(getResources().getStringArray(R.array.gravitation)[3])) {
                result = Physics.universalGravitation(a, b, c, Double.NEGATIVE_INFINITY);
            }

            dialog.setMessage(result.toString());
            dialog.setOnCancelListener(new OnCancelListener() {

                public void onCancel(DialogInterface dialog) {
                    clear();
                }
            });
            dialog.create().show();
        }

        private void clear() {
            a_txt.setText("");
            b_txt.setText("");
            c_txt.setText("");
        }

        /*
         * (non-Javadoc)
         * 
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.variable;
        }

        /**
         * @see com.centauri.equations.activity.ImageFormulaActivity.ImageFormulaFragment#getID()
         */
        @Override
        protected long getID() {
            return getArguments().getLong(Formula._ID);
        }
    }

}
