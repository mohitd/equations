package com.centauri.equations.activity.geometry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.centauri.equations.util.shape2d.Triangle;

public class HeronsFormulaActivity extends Categories {

    public static final String ACTION_HERON = "com.centauri.equations.action.HERON";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new HeronsFormulaFragment())
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
	getSupportActionBar().setTitle(R.string.herons_formula);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[1]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class HeronsFormulaFragment extends SherlockFragment
	    implements OnClickListener {

	private EditText a_txt, b_txt, c_txt;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.variable, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_heron);

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
	    dialog.setIcon(android.R.drawable.ic_dialog_info);
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
    }
}
