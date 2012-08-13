package com.centauri.equations.activity.physics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.physics.Physics;

public class EscapeVelocityActivity extends Categories {

    public static final String ACTION_ESCAPE_VELOCITY = "com.centauri.equations.action.ESCAPE_VELOCITY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new EscapeVelocityFragment())
		.commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
	return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case android.R.id.home:
	    Intent parentIntent = new Intent(this, Categories.class);
	    parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
		    | Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(parentIntent);
	    finish();
	    return true;
	}
	return false;
    }

    @Override
    protected void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.escape_velocity);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[4]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class EscapeVelocityFragment extends SherlockFragment
	    implements OnClickListener, OnItemSelectedListener {

	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;

	private EditText a_txt, b_txt;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.variable, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_phy_escape_velocity);

	    a_txt = ((EditText) getView().findViewById(R.id.area_a));
	    b_txt = ((EditText) getView().findViewById(R.id.area_b));

	    a_txt.setHint(getResources()
		    .getStringArray(R.array.escape_velocity)[1]);
	    b_txt.setHint(getResources()
		    .getStringArray(R.array.escape_velocity)[2]);
	    ((EditText) getView().findViewById(R.id.area_c))
		    .setVisibility(View.GONE);

	    adapter = ArrayAdapter.createFromResource(getActivity(),
		    R.array.escape_velocity,
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
		    R.array.escape_velocity)[0])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[1]);
		b_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[2]);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.escape_velocity)[1])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[0]);
		b_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[2]);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.escape_velocity)[2])) {
		a_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[0]);
		b_txt.setHint(getResources().getStringArray(
			R.array.escape_velocity)[1]);
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
		    R.array.escape_velocity)[0])) {
		result = Physics.escapeVelocity(Double.NEGATIVE_INFINITY, a, b);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.escape_velocity)[1])) {
		result = Physics.escapeVelocity(a, Double.NEGATIVE_INFINITY, b);
	    } else if (variable.equals(getResources().getStringArray(
		    R.array.escape_velocity)[2])) {
		result = Physics.escapeVelocity(a, b, Double.NEGATIVE_INFINITY);
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
    }

}
