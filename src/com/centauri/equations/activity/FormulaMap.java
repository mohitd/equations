package com.centauri.equations.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.centauri.equations.R;
import com.centauri.equations.activity.algebra.DistanceFormulaActivity;
import com.centauri.equations.activity.algebra.QuadraticFormulaActivity;
import com.centauri.equations.activity.algebra.RadicalActivity;
import com.centauri.equations.activity.algebra.SlopeActivity;
import com.centauri.equations.activity.chem.FunctionalGroupsActivity;
import com.centauri.equations.activity.geometry.AreaActivity;
import com.centauri.equations.activity.geometry.HeronsFormulaActivity;
import com.centauri.equations.activity.geometry.PythagoreanActivity;
import com.centauri.equations.activity.physics.CentripetalAccelActivity;
import com.centauri.equations.activity.physics.CentripetalForceActivity;
import com.centauri.equations.activity.physics.CoulombsLawActivity;
import com.centauri.equations.activity.physics.EscapeVelocityActivity;
import com.centauri.equations.activity.physics.GravitationActivity;
import com.centauri.equations.activity.physics.MaxProjectileHeightActivity;
import com.centauri.equations.activity.physics.MaxProjectileRangeActivity;

public class FormulaMap {

    private static SparseArray<String> formulaMap = new SparseArray<String>();
    private static SparseArray<Fragment> fragmentMap = new SparseArray<Fragment>();
    private static SparseIntArray imageMap = new SparseIntArray();

    static {
        formulaMap.put(1, QuadraticFormulaActivity.ACTION_QUADRATIC);
        formulaMap.put(2, DistanceFormulaActivity.ACTION_DISTANCE);
        formulaMap.put(3, RadicalActivity.ACTION_RADICAL);
        formulaMap.put(4, SlopeActivity.ACTION_SLOPE);
        formulaMap.put(5, AreaActivity.ACTION_AREA);
        formulaMap.put(6, PythagoreanActivity.ACTION_PYTHAGOREAN);
        formulaMap.put(7, HeronsFormulaActivity.ACTION_HERON);
        formulaMap.put(23, FunctionalGroupsActivity.ACTION_FUNCTION_GROUPS);
        formulaMap.put(37, CentripetalForceActivity.ACTION_CENTRIPETAL_FORCE);
        formulaMap.put(38, CentripetalAccelActivity.ACTION_CENTRIPETAL_ACCEL);
        formulaMap.put(39, GravitationActivity.ACTION_GRAVITATION);
        formulaMap.put(40,
                MaxProjectileHeightActivity.ACTION_MAX_PROJECTILE_HEIGHT);
        formulaMap.put(41,
                MaxProjectileRangeActivity.ACTION_MAX_PROJECTILE_RANGE);
        formulaMap.put(42, CoulombsLawActivity.ACTION_COULOMBS_LAW);
        formulaMap.put(43, EscapeVelocityActivity.ACTION_ESCAPE_VELOCITY);

        fragmentMap.put(1,
                new QuadraticFormulaActivity.QuadraticFormulaFragment());
        fragmentMap.put(2,
                new DistanceFormulaActivity.DistanceFormulaFragment());
        fragmentMap.put(3, new RadicalActivity.RadicalFragment());
        fragmentMap.put(4, new SlopeActivity.SlopeFragment());
        fragmentMap.put(5, new AreaActivity.AreaFragment());
        fragmentMap.put(6, new PythagoreanActivity.PythagoreanFragment());
        fragmentMap.put(7, new HeronsFormulaActivity.HeronsFormulaFragment());
        fragmentMap.put(23,
                new FunctionalGroupsActivity.FunctionalGroupFragment());
        fragmentMap.put(37,
                new CentripetalForceActivity.CentripetalForceFragment());
        fragmentMap.put(38,
                new CentripetalAccelActivity.CentripetalAccelFragment());
        fragmentMap.put(39, new GravitationActivity.GravitationFragment());
        fragmentMap.put(40,
                new MaxProjectileHeightActivity.MaxProjectileHeightFragment());
        fragmentMap.put(41,
                new MaxProjectileRangeActivity.MaxProjectileRangeFragment());
        fragmentMap.put(42, new CoulombsLawActivity.CoulombsLawFragment());
        fragmentMap
                .put(43, new EscapeVelocityActivity.EscapeVelocityFragment());

        imageMap.put(1, R.drawable.img_alg_quadratic);
        imageMap.put(2, R.drawable.img_alg_distance);
        imageMap.put(3, R.drawable.img_alg_radical);
        imageMap.put(8, R.drawable.img_trig_law_of_sines);
        imageMap.put(9, R.drawable.img_trig_law_of_cosines);
        imageMap.put(10, R.drawable.img_trig_law_of_tangents);
        imageMap.put(11, R.drawable.img_trig_product_sum);
        imageMap.put(12, R.drawable.img_trig_sum_product);
        imageMap.put(13, R.drawable.img_trig_power_reduce);
        imageMap.put(14, R.drawable.img_trig_sum_difference);
        imageMap.put(15, R.drawable.img_trig_even_odd);
        imageMap.put(16, R.drawable.img_trig_cofunction);
        imageMap.put(17, R.drawable.img_trig_pythagorean_identities);
        imageMap.put(18, R.drawable.img_trig_quotient);
        imageMap.put(19, R.drawable.img_trig_right_triangle);
        imageMap.put(20, R.drawable.img_trig_reciprocal);
        imageMap.put(21, R.drawable.img_chem_ideal_gas);
        imageMap.put(22, R.drawable.img_chem_gas_constant);
        imageMap.put(24, R.drawable.img_alg_log_def);
        imageMap.put(25, R.drawable.img_alg_log_identity);
        imageMap.put(26, R.drawable.img_alg_log_prop);
        imageMap.put(27, R.drawable.img_alg_sum_def);
        imageMap.put(28, R.drawable.img_alg_sum_prop);
        imageMap.put(29, R.drawable.img_chem_boyle);
        imageMap.put(30, R.drawable.img_chem_charles);
        imageMap.put(31, R.drawable.img_chem_gay_lussac);
        imageMap.put(32, R.drawable.img_chem_dalton);
        imageMap.put(33, R.drawable.img_chem_combined_gas);
        imageMap.put(34, R.drawable.img_phy_1d_motion);
        imageMap.put(35, R.drawable.img_phy_newtons_laws);
        imageMap.put(36, R.drawable.img_phy_torque);
        imageMap.put(37, R.drawable.img_phy_centripetal_force);
        imageMap.put(38, R.drawable.img_phy_centripetal_accel);
        imageMap.put(39, R.drawable.img_phy_gravitation);
        imageMap.put(40, R.drawable.img_phy_trajectory_height);
        imageMap.put(41, R.drawable.img_phy_trajectory_distance);
        imageMap.put(42, R.drawable.img_phy_coulombs_law);
        imageMap.put(43, R.drawable.img_phy_escape_velocity);
        imageMap.put(44, R.drawable.img_phy_momentum);
        imageMap.put(45, R.drawable.img_phy_work);
        imageMap.put(46, R.drawable.img_phy_ohm);
        imageMap.put(47, R.drawable.img_phy_energy);
        imageMap.put(48, R.drawable.img_phy_resistance);
        imageMap.put(49, R.drawable.img_phy_bernoulli);
        imageMap.put(50, R.drawable.img_phy_planck_constant);
        imageMap.put(51, R.drawable.img_phy_speed_of_light);
        imageMap.put(52, R.drawable.img_phy_permittivity);
        imageMap.put(53, R.drawable.img_phy_gravitation_constant);
        imageMap.put(54, R.drawable.img_phy_gravitational_accel);
        imageMap.put(55, R.drawable.img_chem_acid_base);
        imageMap.put(56, R.drawable.img_phy_angular_speed);
        imageMap.put(57, R.drawable.img_phy_average_acceleration);
        imageMap.put(58, R.drawable.img_phy_average_angular_acceleration);
        imageMap.put(59, R.drawable.img_phy_average_velocity);
        imageMap.put(60, R.drawable.img_phy_displacement);
        imageMap.put(61, R.drawable.img_phy_gravitational_potential_energy);
        imageMap.put(62, R.drawable.img_phy_hookes_law);
        imageMap.put(63, R.drawable.img_phy_impulse);
        imageMap.put(64, R.drawable.img_phy_instantaneous_acceleration);
        imageMap.put(65, R.drawable.img_phy_instantaneous_velocity);
        imageMap.put(66, R.drawable.img_phy_keplers_third_law);
        imageMap.put(67, R.drawable.img_phy_kinetic_energy);
        imageMap.put(68, R.drawable.img_phy_newtons_third_law);
        imageMap.put(69, R.drawable.img_phy_power);
        imageMap.put(70, R.drawable.img_phy_static_friction);
        imageMap.put(71, R.drawable.img_phy_tangential_acceleration);
        imageMap.put(72, R.drawable.img_phy_tangential_speed);
        imageMap.put(73, R.drawable.img_phy_vector_components);
        imageMap.put(74, R.drawable.img_phy_velocity_equations);
        imageMap.put(75, R.drawable.img_alg_vector_addsub);
        imageMap.put(76, R.drawable.img_alg_vector_def);
        imageMap.put(77, R.drawable.img_alg_vector_dot);
        imageMap.put(78, R.drawable.img_alg_vector_prop);
        imageMap.put(79, R.drawable.img_alg_vector_scalar);
        imageMap.put(80, R.drawable.img_alg_demoivre);
        imageMap.put(81, R.drawable.img_alg_dot_prop);
        imageMap.put(82, R.drawable.img_alg_euler_formula);
        imageMap.put(83, R.drawable.img_trig_trig_form);
        imageMap.put(84, R.drawable.img_alg_vector_proj);
    }

    private FormulaMap() {
    }

    public static Intent getIntent(long id) {
        String action = formulaMap.get((int) id);
        if (action == null) {
            return new Intent(ImageFormulaActivity.ACTION_VIEW_FORMULA);
        } else {
            return new Intent(action);
        }
    }

    public static Fragment getFragment(long id) {
        Fragment fragment = fragmentMap.get((int) id);
        if (fragment == null) {
            fragment = new ImageFormulaActivity.ImageFormulaFragment();
        }
        return fragment;
    }

    public static int getImage(long id) {
        return imageMap.get((int) id);
    }
}
