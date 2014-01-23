package com.centauri.equations.activity.algebra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.centauri.equations.R;
import com.centauri.equations.activity.ImageFormulaActivity;
import com.centauri.equations.provider.Equations.Formula;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.Point2D;

public class SlopeActivity extends ImageFormulaActivity {

    public static final String ACTION_SLOPE = "com.centauri.equations.action.SLOPE";

    /**
     * @see com.centauri.equations.activity.ImageFormulaActivity#getFragment()
     */
    @Override
    protected Fragment getFragment() {
        return new SlopeFragment();
    }

    public static class SlopeFragment extends ImageFormulaFragment implements OnClickListener {

        private EditText x1_txt, y1_txt, x2_txt, y2_txt;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            x1_txt = ((EditText) getView().findViewById(R.id.dist_x1));
            y1_txt = ((EditText) getView().findViewById(R.id.dist_y1));
            x2_txt = ((EditText) getView().findViewById(R.id.dist_x2));
            y2_txt = ((EditText) getView().findViewById(R.id.dist_y2));

            ((Button) getView().findViewById(R.id.dist_solve)).setOnClickListener(this);
        }

        public void onClick(View v) {

            if (x1_txt.getText().toString().equals("") || y1_txt.getText().toString().equals("")
                    || x2_txt.getText().toString().equals("")
                    || y2_txt.getText().toString().equals("")) {
                Toast.makeText(getActivity(), getResources().getString(R.string.blank_field),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;
            try {
                x1 = Integer.parseInt(x1_txt.getText().toString());
                y1 = Integer.parseInt(y1_txt.getText().toString());
                x2 = Integer.parseInt(x2_txt.getText().toString());
                y2 = Integer.parseInt(y2_txt.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), getResources().getString(R.string.must_be_integer),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Point2D point1 = new Point2D(x1, y1);
            Point2D point2 = new Point2D(x2, y2);

            Complex slope = point1.slope(point2);

            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle(R.string.answer);
            dialog.setMessage(point1.toString() + point2.toString() + " = " + slope.toString());
            dialog.setOnCancelListener(new OnCancelListener() {

                public void onCancel(DialogInterface dialog) {
                    clear();
                }
            });
            dialog.create().show();
        }

        private void clear() {
            x1_txt.setText("");
            y1_txt.setText("");
            x2_txt.setText("");
            y2_txt.setText("");
        }

        /*
         * (non-Javadoc)
         * 
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.points2d;
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
