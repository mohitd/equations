/**
 * 
 */
package com.centauri.equations.activity.algebra;

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

/**
 * @author mohitd2000
 * 
 */
public class VectorActivity extends Categories {
    public static final String ACTION_VEC_ADD_SUB = "com.centauri.equations.action.VEC_ADD_SUB";
    public static final String ACTION_VEC_DEF = "com.centauri.equations.action.VEC_DEF";
    public static final String ACTION_VEC_DOT = "com.centauri.equations.action.VEC_DOT";
    public static final String ACTION_VEC_PROP = "com.centauri.equations.action.VEC_PROP";
    public static final String ACTION_VEC_SCAL = "com.centauri.equations.action.VEC_SCAL";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.centauri.equations.activity.Categories#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	FragmentTransaction transaction = getSupportFragmentManager()
		.beginTransaction();

	final String action = getIntent().getAction();
	if (action.equals(ACTION_VEC_ADD_SUB)) {
	    transaction.add(android.R.id.content, new VectorAddSubFragment());
	} else if (action.equals(ACTION_VEC_DEF)) {
	    transaction.add(android.R.id.content, new VectorDefFragment());
	} else if (action.equals(ACTION_VEC_DOT)) {
	    transaction.add(android.R.id.content, new VectorDotFragment());
	} else if (action.equals(ACTION_VEC_PROP)) {
	    transaction.add(android.R.id.content, new VectorPropFragment());
	} else if (action.equals(ACTION_VEC_SCAL)) {
	    transaction.add(android.R.id.content, new ScalarMultiplyFragment());
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
		getResources().getStringArray(R.array.categories)[0]);
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class VectorAddSubFragment extends SherlockFragment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater
	 * , android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_vector_addsub);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.vec_add_sub);
	}
    }

    public static class VectorDefFragment extends SherlockFragment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater
	 * , android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_vector_def);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.vec_def);
	}
    }

    public static class VectorDotFragment extends SherlockFragment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater
	 * , android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_vector_prop);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.vec_prop);
	}
    }

    public static class VectorPropFragment extends SherlockFragment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater
	 * , android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_vector_prop);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.vec_prop);
	}
    }

    public static class ScalarMultiplyFragment extends SherlockFragment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater
	 * , android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.single_image, container, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    ImageView image = (ImageView) getView().findViewById(
		    R.id.img_formula);
	    image.setImageResource(R.drawable.img_alg_vector_scalar);
	    ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
		    .setTitle(R.string.vec_scal);
	}
    }

}
