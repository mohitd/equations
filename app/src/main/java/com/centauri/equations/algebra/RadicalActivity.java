package com.centauri.equations.algebra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.centauri.equations.ImageFormulaActivity;
import com.centauri.equations.R;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.util.RadicalNumber;

public class RadicalActivity extends ImageFormulaActivity {

    public static final String ACTION_RADICAL = "com.centauri.equations.action.RADICAL";

    @Override
    protected Fragment getFragment() {
        return new RadicalFragment();
    }

    public static class RadicalFragment extends ImageFormulaFragment implements OnClickListener {

        private EditText a_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            a_txt = ((EditText) getView().findViewById(R.id.area_a));

            a_txt.setHint(R.string.radicand);
            ((EditText) getView().findViewById(R.id.area_b)).setVisibility(View.GONE);
            ((EditText) getView().findViewById(R.id.area_c)).setVisibility(View.GONE);
            ((Spinner) getView().findViewById(R.id.area_polygon)).setVisibility(View.GONE);
            ((Button) getView().findViewById(R.id.area_solve)).setOnClickListener(this);
        }

        public void onClick(View v) {
            int radicand = 0;
            if (a_txt.getText().toString().equals("")) {
                Toast.makeText(getActivity(), getResources().getString(R.string.blank_field),
                        Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                radicand = Integer.parseInt(a_txt.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), getResources().getString(R.string.must_be_integer),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (radicand > 0) {
                RadicalNumber radical = new RadicalNumber(radicand);

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle(R.string.answer);
                dialog.setMessage(Html.fromHtml(radical.simplify().toString()));
                dialog.setOnCancelListener(new OnCancelListener() {

                    public void onCancel(DialogInterface dialog) {
                        clear();
                    }
                });
                dialog.create().show();
            }
        }

        private void clear() {
            a_txt.setText("");
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

        @Override
        protected long getID() {
            return getArguments().getLong(Formula._ID);
        }

    }
}
