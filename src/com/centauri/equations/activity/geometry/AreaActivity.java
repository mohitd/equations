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
import com.centauri.equations.util.Polygon;
import com.centauri.equations.util.shape2d.Ellipse;
import com.centauri.equations.util.shape2d.NGon;
import com.centauri.equations.util.shape2d.Quadrilateral;
import com.centauri.equations.util.shape2d.Sector;
import com.centauri.equations.util.shape2d.Trapezoid;
import com.centauri.equations.util.shape2d.Triangle;

public class AreaActivity extends Categories {

    public static final String ACTION_AREA = "com.centauri.equations.action.AREA";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new AreaFragment()).commit();
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
	getSupportActionBar().setTitle(R.string.area_formulas);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[1]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class AreaFragment extends SherlockFragment implements
	    OnClickListener, OnItemSelectedListener {

	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;

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
		    .setImageResource(R.drawable.img_area_triangle);

	    a_txt = ((EditText) getView().findViewById(R.id.area_a));
	    b_txt = ((EditText) getView().findViewById(R.id.area_b));
	    c_txt = ((EditText) getView().findViewById(R.id.area_c));

	    adapter = ArrayAdapter.createFromResource(getActivity(),
		    R.array.polygon2D, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

	    spinner = (Spinner) getView().findViewById(R.id.area_polygon);
	    spinner.setAdapter(adapter);

	    spinner.setOnItemSelectedListener(this);
	    ((Button) getView().findViewById(R.id.area_solve))
		    .setOnClickListener(this);
	}

	public void onItemSelected(AdapterView<?> parent, View view,
		int position, long id) {

	    b_txt.setVisibility(View.VISIBLE);
	    c_txt.setVisibility(View.GONE);
	    ImageView formula = (ImageView) getView().findViewById(
		    R.id.img_area);

	    switch (Polygon.valueOf(adapter.getItem(position).toString()
		    .toUpperCase())) {
	    case TRIANGLE:
		setHintA(R.string.base);
		setHintB(R.string.height);
		formula.setImageResource(R.drawable.img_area_triangle);
		break;
	    case QUADRILATERAL:
		setHintA(R.string.base);
		setHintB(R.string.height);
		formula.setImageResource(R.drawable.img_area_quadrilateral);
		break;
	    case SECTOR:
		setHintA(R.string.degrees);
		setHintB(R.string.radius);
		formula.setImageResource(R.drawable.img_area_sector);
		break;
	    case SQUARE:
		b_txt.setVisibility(View.GONE);
		setHintA(R.string.side);
		formula.setImageResource(R.drawable.img_area_square);
		break;
	    case RECTANGLE:
		setHintA(R.string.side_a);
		setHintB(R.string.side_b);
		formula.setImageResource(R.drawable.img_area_quadrilateral);
		break;
	    case PENTAGON:
		setHintA(R.string.side);
		setHintB(R.string.apothem);
		break;
	    case CIRCLE:
		b_txt.setVisibility(View.GONE);
		setHintA(R.string.radius);
		formula.setImageResource(R.drawable.img_area_circle);
		break;
	    case ELLIPSE:
		setHintA(R.string.major_axis);
		setHintB(R.string.minor_axis);
		formula.setImageResource(R.drawable.img_area_ellipse);
		break;
	    case TRAPEZOID:
		c_txt.setVisibility(View.VISIBLE);
		setHintA(R.string.base_1);
		setHintB(R.string.base_2);
		setHintC(R.string.height);
		formula.setImageResource(R.drawable.img_area_trapezoid);
		break;
	    }
	}

	public void onNothingSelected(AdapterView<?> parent) {
	}

	public void onClick(View v) {
	    String polygon = (String) spinner.getSelectedItem();
	    Polygon shape = Polygon.valueOf(polygon.toUpperCase());

	    if (a_txt.getText().toString().equals("")) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.blank_field),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    double a = 0;
	    try {
		a = Double.parseDouble(a_txt.getText().toString());
	    } catch (NumberFormatException e) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.number_too_large),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    double b = 0;
	    if (b_txt.getVisibility() == View.VISIBLE) {
		if (b_txt.getText().toString().equals("")) {
		    Toast.makeText(getActivity(),
			    getResources().getString(R.string.blank_field),
			    Toast.LENGTH_SHORT).show();
		    return;
		}
		try {
		    b = Double.parseDouble(b_txt.getText().toString());
		} catch (NumberFormatException e) {
		    Toast.makeText(
			    getActivity(),
			    getResources().getString(R.string.number_too_large),
			    Toast.LENGTH_SHORT).show();
		    return;
		}
	    }

	    double c = 0;
	    if (c_txt.getVisibility() == View.VISIBLE) {
		if (c_txt.getText().toString().equals("")) {
		    Toast.makeText(getActivity(),
			    getResources().getString(R.string.blank_field),
			    Toast.LENGTH_SHORT).show();
		    return;
		}
		try {
		    c = Double.parseDouble(c_txt.getText().toString());
		} catch (NumberFormatException e) {
		    Toast.makeText(
			    getActivity(),
			    getResources().getString(R.string.number_too_large),
			    Toast.LENGTH_SHORT).show();
		    return;
		}
	    }

	    Complex result = null;

	    switch (shape) {
	    case TRIANGLE:
		result = new Triangle(0, 0).area(a, b);
		break;
	    case RECTANGLE:
	    case QUADRILATERAL:
		result = new Quadrilateral(a, b).area();
		break;
	    case PENTAGON:
		result = new NGon(a, 5).area();
		break;
	    case SQUARE:
		result = new Quadrilateral(a).area();
		break;
	    case CIRCLE:
		result = new Ellipse(a).area();
		break;
	    case ELLIPSE:
		result = new Ellipse(a, b).area();
		break;
	    case SECTOR:
		result = new Sector(a, b).area();
		break;
	    case TRAPEZOID:
		result = new Trapezoid(a, b, c).area();
		break;
	    default:
		throw new EnumConstantNotPresentException(Polygon.class,
			shape.toString());
	    }

	    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
	    dialog.setTitle(R.string.answer);
	    dialog.setIcon(android.R.drawable.ic_dialog_info);
	    dialog.setMessage(result.toString());
	    dialog.setOnCancelListener(new OnCancelListener() {
		public void onCancel(DialogInterface dialog) {
		    clear();
		}
	    });
	    dialog.create().show();
	}

	private void setHintA(int hint) {
	    a_txt.setHint(hint);
	}

	private void setHintB(int hint) {
	    b_txt.setHint(hint);
	}

	private void setHintC(int hint) {
	    c_txt.setHint(hint);
	}

	private void clear() {
	    a_txt.setText("");
	    b_txt.setText("");
	    c_txt.setText("");
	}
    }
}
