package com.centauri.equations.activity.physics;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.actionbarsherlock.app.ActionBar;
import com.centauri.equations.R;
import com.centauri.equations.activity.FormulaActivity;
import com.centauri.equations.activity.FormulaMap;

public class ParticleEnergyActivity extends FormulaActivity {

    public static final String ACTION_PARTICLE_ENERGY = "com.centauri.equations.action.PARTICLE_ENERGY";

    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, new ParticleEnergyFragment())
                .commit();
    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setNavigationMode(
                ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setTitle(R.string.particle_energy);
        getSupportActionBar().setSubtitle(
                getResources().getStringArray(R.array.categories)[4]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class ParticleEnergyFragment extends FormulaFragment {

        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((ImageView) getView().findViewById(R.id.img_formula))
                    .setImageResource(R.drawable.img_phy_energy);
        }

        /*
         * (non-Javadoc)
         * @see FormulaActivity.FormulaFragment# getFragmentView()
         */
        @Override
        protected int getFragmentView() {
            return R.layout.single_image;
        }

        /*
         * (non-Javadoc)
         * @see FormulaActivity#getID()
         */
        @Override
        protected long getID() {
            return FormulaMap
                    .getId(this, getActivity().getIntent().getAction());
        }
    }

}
