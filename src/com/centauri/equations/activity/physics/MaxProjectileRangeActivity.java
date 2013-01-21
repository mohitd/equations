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

public class MaxProjectileRangeActivity extends FormulaActivity {

    public static final String ACTION_MAX_PROJECTILE_RANGE = "com.centauri.equations.action.MAX_PROJECTILE_RANGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new MaxProjectileRangeFragment())
		.commit();
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.maximum_range_of_a_projectile);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[4]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class MaxProjectileRangeFragment extends FormulaFragment
	    implements OnClickListener, OnItemSelectedListener {

	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;

	private EditText a_txt, b_txt;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_phy_trajectory_distance);

	    a_txt = ((EditText) getView().findViewById(R.id.area_a));
	    b_txt = ((EditText) getView().findViewById(R.id.area_b));

	    a_txt.setHint(getResources().getStringArray(
		    R.array.projectile_range)[1]);
	    b_txt.setHint(getResources().getStringArray(
		    R.array.projectile_range)[2]);
	    ((EditText) getView().findViewById(R.id.area_c))
		    .setVisibility(View.GONE);

	    adapter = ArrayAdapter.createFromResource(getActivity(),
		    R.array.projectile_height,
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
		    R.array.projectile_range)[0])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[1]);
		b_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[2]);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.projectile_range)[1])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[0]);
		b_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[2]);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.projectile_range)[2])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[0]);
		b_txt.setHint(getResources().getStringArray(
			R.array.projectile_range)[1]);
	    }
	}

	public void onNothingSelected(AdapterView<?> parent) {
	}

	public void onClick(View v) {
	    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
	    dialog.setTitle(getResources().getString(R.string.answer));

	    if (a_txt.getText().toString().equals("")
		    || b_txt.getText().toString().equals("")) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.blank_field),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    double a = 0;
	    double b = 0;
	    try {
		a = Double.parseDouble(a_txt.getText().toString());
		b = Double.parseDouble(b_txt.getText().toString());
	    } catch (NumberFormatException e) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.number_too_large),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    String variable = spinner.getSelectedItem().toString();
	    Complex result = null;

	    if (variable.equals(getResources().getStringArray(
		    R.array.projectile_range)[0])) {
		result = Physics.maxProjectileRange(Double.NEGATIVE_INFINITY,
			a, b);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.projectile_range)[1])) {
		result = Physics.maxProjectileRange(a,
			Double.NEGATIVE_INFINITY, b);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.projectile_range)[2])) {
		result = Physics.maxProjectileRange(a, b,
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
	    ((EditText) getView().findViewById(R.id.area_c)).setText("");
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
