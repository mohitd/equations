package com.centauri.equations.activity.trig;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;

public class TrigActivity extends Categories {

    public static final String ACTION_SINES = "com.centauri.equations.action.LAW_OF_SINES";
    public static final String ACTION_COSINES = "com.centauri.equations.action.LAW_OF_COSINES";
    public static final String ACTION_TANGENTS = "com.centauri.equations.action.LAW_OF_TANGENTS";
    public static final String ACTION_PRODUCT_SUM = "com.centauri.equations.action.PRODUCT_TO_SUM";
    public static final String ACTION_SUM_PRODUCT = "com.centauri.equations.action.SUM_TO_PRODUCT";
    public static final String ACTION_POWER_REDUCTION = "com.centauri.equations.action.POWER_REDUCTION";
    public static final String ACTION_SUM_DIFFERENCE = "com.centauri.equations.action.SUM_DIFFERENCE";
    public static final String ACTION_EVEN_ODD = "com.centauri.equations.action.EVEN_ODD";
    public static final String ACTION_COFUNCTION = "com.centauri.equations.action.COFUNCTION";
    public static final String ACTION_PYTHAGOREAN_IDENTITY = "com.centauri.equations.action.PYTHAGOREAN_IDENTITY";
    public static final String ACTION_QUOTIENT = "com.centauri.equations.action.QUOTIENT";
    public static final String ACTION_RIGHT_TRIANGLE = "com.centauri.equations.action.RIGHT_TRIANGLE";
    public static final String ACTION_RECIPROCAL = "com.centauri.equations.action.RECIPROCAL";

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	FragmentTransaction transaction = getSupportFragmentManager()
		.beginTransaction();

	final String action = getIntent().getAction();

	if (action.equals(ACTION_SINES)) {
	    transaction.add(android.R.id.content, new LawOfSinesFragment());
	} else if (action.equals(ACTION_COSINES)) {
	    transaction.add(android.R.id.content, new LawOfCosinesFragment());
	} else if (action.equals(ACTION_TANGENTS)) {
	    transaction.add(android.R.id.content, new LawOfTangentsFragment());
	} else if (action.equals(ACTION_PRODUCT_SUM)) {
	    transaction.add(android.R.id.content, new ProductToSumFragment());
	} else if (action.equals(ACTION_SUM_PRODUCT)) {
	    transaction.add(android.R.id.content, new SumToProductFragment());
	} else if (action.equals(ACTION_POWER_REDUCTION)) {
	    transaction.add(android.R.id.content, new PowerReductionFragment());
	} else if (action.equals(ACTION_SUM_DIFFERENCE)) {
	    transaction.add(android.R.id.content, new SumDifferenceFragment());
	} else if (action.equals(ACTION_EVEN_ODD)) {
	    transaction.add(android.R.id.content, new EvenOddFragment());
	} else if (action.equals(ACTION_COFUNCTION)) {
	    transaction.add(android.R.id.content, new CofunctionFragment());
	} else if (action.equals(ACTION_PYTHAGOREAN_IDENTITY)) {
	    transaction.add(android.R.id.content,
		    new PythagoreanIdentitiesFragment());
	} else if (action.equals(ACTION_QUOTIENT)) {
	    transaction.add(android.R.id.content, new QuotientFragment());
	} else if (action.equals(ACTION_RIGHT_TRIANGLE)) {
	    transaction.add(android.R.id.content, new RightTriangleFragment());
	} else if (action.equals(ACTION_RECIPROCAL)) {
	    transaction.add(android.R.id.content, new ReciprocalFragment());
	}

	transaction.commit();

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
	getSupportActionBar().setSubtitle(
		getResources().getStringArray(R.array.categories)[2]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class LawOfSinesFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_law_of_sines);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.law_of_sines);
	}
    }

    public static class LawOfCosinesFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_law_of_cosines);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.law_of_cosines);
	}
    }

    public static class LawOfTangentsFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_law_of_tangents);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.law_of_tangents);
	}
    }

    public static class ProductToSumFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_product_sum);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.product_sum_formulas);
	}
    }

    public static class SumToProductFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_sum_product);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.sum_product_formulas);
	}
    }

    public static class PowerReductionFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_power_reduce);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.power_reduction_formulas);
	}
    }

    public static class SumDifferenceFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_sum_difference);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.sum_difference_formulas);
	}
    }

    public static class EvenOddFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_even_odd);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.even_odd_formulas);
	}
    }

    public static class CofunctionFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_cofunction);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.cofunction_formulas);
	}
    }

    public static class PythagoreanIdentitiesFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_pythagorean_identities);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.pythagorean_identities);
	}
    }

    public static class QuotientFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_quotient);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.quotient_formulas);
	}
    }

    public static class RightTriangleFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_right_triangle);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.right_triangle_definitions);
	}
    }

    public static class ReciprocalFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_trig_reciprocal);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.reciprocal_identities);
	}
    }
}
