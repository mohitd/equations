package com.centauri.equations.activity.chem;

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
import com.centauri.equations.util.chem.IdealGas;

public class IdealGasActivity extends FormulaActivity {

    public static final String ACTION_GAS_LAW = "com.centauri.equations.action.GAS_LAW";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new IdealGasFragment()).commit();
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.ideal_gas_law);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[3]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class IdealGasFragment extends FormulaFragment implements
	    OnClickListener, OnItemSelectedListener {

	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;

	private EditText a_txt, b_txt, c_txt;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);

	    a_txt = (EditText) getView().findViewById(R.id.area_a);
	    b_txt = (EditText) getView().findViewById(R.id.area_b);
	    c_txt = (EditText) getView().findViewById(R.id.area_c);

	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_chem_ideal_gas);

	    a_txt.setHint(R.string.moles);
	    b_txt.setHint(R.string.temperature);
	    c_txt.setHint(R.string.volume);
	    c_txt.setVisibility(View.VISIBLE);

	    adapter = ArrayAdapter.createFromResource(getActivity(),
		    R.array.ideal_gas, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

	    spinner = (Spinner) getView().findViewById(R.id.area_polygon);
	    spinner.setAdapter(adapter);

	    spinner.setOnItemSelectedListener(this);
	    ((Button) getView().findViewById(R.id.area_solve))
		    .setOnClickListener(this);
	}

	public void onItemSelected(AdapterView<?> parent, View view,
		int position, long id) {

	    String p = getResources().getStringArray(R.array.ideal_gas)[0];
	    String v = getResources().getStringArray(R.array.ideal_gas)[1];
	    String n = getResources().getStringArray(R.array.ideal_gas)[2];
	    String t = getResources().getStringArray(R.array.ideal_gas)[3];

	    a_txt.setHint(R.string.moles);
	    String variable = adapter.getItem(position).toString();

	    if (variable.equals(p)) {
		a_txt.setHint(R.string.moles);
		b_txt.setHint(R.string.temperature);
		c_txt.setHint(R.string.volume);
	    } else if (variable.equals(v)) {
		a_txt.setHint(R.string.moles);
		b_txt.setHint(R.string.temperature);
		c_txt.setHint(R.string.pressure);
	    } else if (variable.equals(n)) {
		a_txt.setHint(R.string.pressure);
		b_txt.setHint(R.string.volume);
		c_txt.setHint(R.string.temperature);
	    } else if (variable.equals(t)) {
		a_txt.setHint(R.string.pressure);
		b_txt.setHint(R.string.volume);
		c_txt.setHint(R.string.moles);
	    }
	}

	public void onNothingSelected(AdapterView<?> parent) {
	}

	public void onClick(View view) {
	    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
	    dialog.setTitle(R.string.answer);

	    if (a_txt.getText().toString().equals("")
		    || b_txt.getText().toString().equals("")
		    || c_txt.getText().toString().equals("")) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.blank_field),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    String p = getResources().getStringArray(R.array.ideal_gas)[0];
	    String v = getResources().getStringArray(R.array.ideal_gas)[1];
	    String n = getResources().getStringArray(R.array.ideal_gas)[2];
	    String t = getResources().getStringArray(R.array.ideal_gas)[3];

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

	    if (variable.equals(p)) {
		result = IdealGas.solveEquation(p.charAt(0), 0, c, a, b);
	    } else if (variable.equals(v)) {
		result = IdealGas.solveEquation(v.charAt(0), c, 0, a, b);
	    } else if (variable.equals(n)) {
		result = IdealGas.solveEquation(n.charAt(0), a, b, 0, c);
	    } else if (variable.equals(t)) {
		result = IdealGas.solveEquation(t.charAt(0), a, b, c, 0);
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
