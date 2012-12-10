package com.centauri.equations.activity.algebra;

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
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;
import com.centauri.equations.util.Complex;
import com.centauri.equations.util.Point2D;

public class DistanceFormulaActivity extends Categories {

    public static final String ACTION_DISTANCE = "com.centauri.equations.action.DISTANCE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getSupportFragmentManager().beginTransaction()
		.add(android.R.id.content, new DistanceFormulaFragment())
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
	getSupportActionBar().setTitle(R.string.distance_formula);
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class DistanceFormulaFragment extends SherlockFragment
	    implements OnClickListener {

	private EditText x1_txt, y1_txt, x2_txt, y2_txt;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.points2d, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    x1_txt = ((EditText) getView().findViewById(R.id.dist_x1));
	    y1_txt = ((EditText) getView().findViewById(R.id.dist_y1));
	    x2_txt = ((EditText) getView().findViewById(R.id.dist_x2));
	    y2_txt = ((EditText) getView().findViewById(R.id.dist_y2));

	    ((ImageView) getView().findViewById(R.id.img_point2d))
		    .setImageResource(R.drawable.img_alg_distance);
	    ((Button) getView().findViewById(R.id.dist_solve))
		    .setOnClickListener(this);
	}

	public void onClick(View v) {

	    if (x1_txt.getText().toString().equals("")
		    || y1_txt.getText().toString().equals("")
		    || x2_txt.getText().toString().equals("")
		    || y2_txt.getText().toString().equals("")) {
		Toast.makeText(getActivity(),
			getResources().getString(R.string.blank_field),
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
		Toast.makeText(getActivity(),
			getResources().getString(R.string.must_be_integer),
			Toast.LENGTH_SHORT).show();
		return;
	    }

	    Point2D point1 = new Point2D(x1, y1);
	    Point2D point2 = new Point2D(x2, y2);

	    Complex result = point1.distance(point2);

	    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
	    dialog.setTitle(R.string.answer);
	    dialog.setMessage(point1.toString() + point2.toString() + " = "
		    + result.toString());
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

    }
}
