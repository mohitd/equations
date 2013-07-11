package com.centauri.equations.activity.physics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
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

import com.actionbarsherlock.app.ActionBar;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.physics.Physics;

public class CentripetalForceActivity extends FormulaActivity {

    public static final String ACTION_CENTRIPETAL_FORCE = "com.centauri.equations.action.CENTRIPETAL_FORCE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, new CentripetalForceFragment())
                .commit();
    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setTitle(R.string.centripetal_force);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[4]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class CentripetalForceFragment extends FormulaFragment
            implements OnClickListener, OnItemSelectedListener {

        private ArrayAdapter<CharSequence> adapter;
        private Spinner spinner;

        private EditText a_txt, b_txt, c_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((ImageView) getView().findViewById(R.id.img_area))
                    .setImageResource(R.drawable.img_phy_centripetal_force);

            a_txt = ((EditText) getView().findViewById(R.id.area_a));
            b_txt = ((EditText) getView().findViewById(R.id.area_b));
            c_txt = ((EditText) getView().findViewById(R.id.area_c));

            a_txt.setHint(getResources().getStringArray(
                    R.array.centripetal_force)[1]);
            b_txt.setHint(getResources().getStringArray(
                    R.array.centripetal_force)[2]);
            c_txt.setHint(getResources().getStringArray(
                    R.array.centripetal_force)[3]);
            c_txt.setVisibility(View.VISIBLE);

            adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.centripetal_force,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner = (Spinner) getView().findViewById(R.id.area_polygon);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(this);
            ((Button) getView().findViewById(R.id.area_solve))
                    .setOnClickListener(this);
        }

        public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {

            String variable = adapter.getItem(position).toString();

            if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[0])) {
                a_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[1]);
                b_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[2]);
                c_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[3]);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[1])) {
                a_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[0]);
                b_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[2]);
                c_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[3]);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[2])) {
                a_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[0]);
                b_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[1]);
                c_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[3]);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[3])) {
                a_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[0]);
                b_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[1]);
                c_txt.setHint(getResources().getStringArray(
                        R.array.centripetal_force)[2]);
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }

        public void onClick(View v) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle(getResources().getString(R.string.answer));

            if (a_txt.getText().toString().equals("")
                    || b_txt.getText().toString().equals("")
                    || c_txt.getText().toString().equals("")) {
                Toast.makeText(getActivity(),
                        getResources().getString(R.string.blank_field),
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
                Toast.makeText(getActivity(),
                        getResources().getString(R.string.number_too_large),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String variable = spinner.getSelectedItem().toString();
            Complex result = null;

            if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[0])) {
                result = Physics.centripetalForce(Double.NEGATIVE_INFINITY, a,
                        b, c);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[1])) {
                result = Physics.centripetalForce(a, Double.NEGATIVE_INFINITY,
                        b, c);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[2])) {
                result = Physics.centripetalForce(a, b,
                        Double.NEGATIVE_INFINITY, c);
            } else if (variable.equals(getResources().getStringArray(
                    R.array.centripetal_force)[3])) {
                result = Physics.centripetalForce(a, b, c,
                        Double.NEGATIVE_INFINITY);
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
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.variable;
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
