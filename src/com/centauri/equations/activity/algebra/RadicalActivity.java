package com.centauri.equations.activity.algebra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;
import com.centauri.equations.util.RadicalNumber;

public class RadicalActivity extends FormulaActivity {

    public static final String ACTION_RADICAL = "com.centauri.equations.action.RADICAL";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new RadicalFragment()).commit();
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.radicand_simp);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class RadicalFragment extends FormulaFragment implements
	    OnClickListener {

	private EditText a_txt;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_alg_radical);

	    a_txt = ((EditText) getView().findViewById(R.id.area_a));

	    a_txt.setHint(R.string.radicand);
	    ((EditText) getView().findViewById(R.id.area_b))
		    .setVisibility(View.GONE);
	    ((EditText) getView().findViewById(R.id.area_c))
		    .setVisibility(View.GONE);
	    ((Spinner) getView().findViewById(R.id.area_polygon))
		    .setVisibility(View.GONE);
	    ((Button) getView().findViewById(R.id.area_solve))
		    .setOnClickListener(this);
	}

	public void onClick(View v) {
	    int radicand = 0;
	    if (a_txt.getText().toString().equals("")) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.blank_field),
			Toast.LENGTH_SHORT).show();
		return;
	    }
	    try {
		radicand = Integer.parseInt(a_txt.getText().toString());
	    } catch (NumberFormatException e) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.must_be_integer),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    if (radicand > 0) {
		RadicalNumber radical = new RadicalNumber(radicand);

		AlertDialog.Builder dialog = new AlertDialog.Builder(
			getActivity());
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
	 * @see com.centauri.equations.activity.FormulaActivity.FormulaFragment#
	 * getFragmentView()
	 */
	@Override
	protected int getFragmentView() {
	    return R.layout.variable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.centauri.equations.activity.FormulaActivity#getID()
	 */
	@Override
	protected long getID() {
	    return FormulaMap
		    .getId(this, getActivity().getIntent().getAction());
	}

    }
}
