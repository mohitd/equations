package com.centauri.equations.activity.geometry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.centauri.equations.R;
import com.centauri.equations.activity.ImageFormulaActivity;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.util.shape2d.Triangle;

public class HeronsFormulaActivity extends ImageFormulaActivity {

    public static final String ACTION_HERON = "com.centauri.equations.action.HERON";

    /**
     * @see com.centauri.equations.activity.ImageFormulaActivity#getFragment()
     */
    @Override
    protected Fragment getFragment() {
        return new HeronsFormulaFragment();
    }

    public static class HeronsFormulaFragment extends ImageFormulaFragment
            implements OnClickListener {

        private EditText a_txt, b_txt, c_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((ImageView) getView().findViewById(R.id.img_formula))
                    .setImageResource(R.drawable.img_geo_heron);

            a_txt = ((EditText) getView().findViewById(R.id.area_a));
            b_txt = ((EditText) getView().findViewById(R.id.area_b));
            c_txt = ((EditText) getView().findViewById(R.id.area_c));

            a_txt.setHint(R.string.a);
            b_txt.setHint(R.string.b);
            c_txt.setHint(R.string.c);

            c_txt.setVisibility(View.VISIBLE);
            ((Spinner) getView().findViewById(R.id.area_polygon))
                    .setVisibility(View.GONE);
            ((Button) getView().findViewById(R.id.area_solve))
                    .setOnClickListener(this);
        }

        public void onClick(View v) {

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

            Triangle triangle = new Triangle(a, b, c);

            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle(R.string.answer);
            dialog.setMessage(triangle.area().toString());
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

        /**
         * @see BaseFormulaFragment.activity.BaseFormulaActivity.FormulaFragment#getFragmentView()
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
