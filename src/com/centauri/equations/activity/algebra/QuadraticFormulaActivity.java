package com.centauri.equations.activity.algebra;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.Quadratic;

public class QuadraticFormulaActivity extends SherlockFragmentActivity {

    public static final String ACTION_QUADRATIC = "com.centauri.equations.action.QUADRATIC";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new QuadraticFormulaFragment())
		.commit();
	setupActionBar();
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

    private void setupActionBar() {
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.quad_formula);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class QuadraticFormulaFragment extends SherlockFragment
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
	    a_txt = (EditText) getView().findViewById(R.id.area_a);
	    b_txt = (EditText) getView().findViewById(R.id.area_b);
	    c_txt = (EditText) getView().findViewById(R.id.area_c);

	    ((ImageView) getView().findViewById(R.id.img_area))
		    .setImageResource(R.drawable.img_quadratic);

	    a_txt.setHint(R.string.a);
	    b_txt.setHint(R.string.b);
	    c_txt.setHint(R.string.c);
	    c_txt.setVisibility(View.VISIBLE);

	    a_txt.setInputType(InputType.TYPE_CLASS_NUMBER
		    | InputType.TYPE_NUMBER_FLAG_SIGNED);
	    b_txt.setInputType(InputType.TYPE_CLASS_NUMBER
		    | InputType.TYPE_NUMBER_FLAG_SIGNED);
	    c_txt.setInputType(InputType.TYPE_CLASS_NUMBER
		    | InputType.TYPE_NUMBER_FLAG_SIGNED);

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

	    Quadratic quadratic = new Quadratic(a, b, c);

	    double discriminant = b * b - 4 * a * c;

	    ArrayList<Complex> roots = quadratic.getRoots();

	    StringBuilder text = new StringBuilder();

	    DecimalFormat style = new DecimalFormat("0.##########");

	    Iterator<Complex> iterator = roots.iterator();

	    // If complex number, do special complex number formatting
	    if (discriminant < 0) {
		Complex result = iterator.next();
		if (result.real() == 0 && result.imag() == 1)
		    text.append("±i");
		else if (result.real() == 0) {
		    if (result.imag() == 1)
			text.append("±i");
		    else
			text.append("±" + style.format(result.imag()) + "i");
		} else if (result.imag() == 1)
		    text.append(style.format(result.real()) + "±i");
		else
		    text.append(style.format(result.real()) + "±"
			    + style.format(result.imag()) + "i");

		// Non complex roots
	    } else {
		text.append("(");
		text.append(iterator.next().toString());
		while (iterator.hasNext()) {
		    text.append(", ");
		    text.append(iterator.next().toString());
		}
		text.append(")");
	    }

	    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

	    dialog.setTitle(R.string.answer);
	    dialog.setMessage(text.toString());
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
