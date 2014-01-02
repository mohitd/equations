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
import com.centauri.equations.activity.physics.CoulombsLawActivity;
import com.centauri.equations.activity.physics.EscapeVelocityActivity;
import com.centauri.equations.activity.physics.GravitationActivity;

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
        formulaMap.put(39, GravitationActivity.ACTION_GRAVITATION);
        formulaMap.put(42, CoulombsLawActivity.ACTION_COULOMBS_LAW);
        formulaMap.put(43, EscapeVelocityActivity.ACTION_ESCAPE_VELOCITY);

        fragmentMap.put(1, new QuadraticFormulaActivity.QuadraticFormulaFragment());
        fragmentMap.put(2, new DistanceFormulaActivity.DistanceFormulaFragment());
        fragmentMap.put(3, new RadicalActivity.RadicalFragment());
        fragmentMap.put(4, new SlopeActivity.SlopeFragment());
        fragmentMap.put(5, new AreaActivity.AreaFragment());
        fragmentMap.put(6, new PythagoreanActivity.PythagoreanFragment());
        fragmentMap.put(7, new HeronsFormulaActivity.HeronsFormulaFragment());
        fragmentMap.put(23, new FunctionalGroupsActivity.FunctionalGroupFragment());
        fragmentMap.put(39, new GravitationActivity.GravitationFragment());
        fragmentMap.put(42, new CoulombsLawActivity.CoulombsLawFragment());
        fragmentMap.put(43, new EscapeVelocityActivity.EscapeVelocityFragment());

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
        imageMap.put(35, R.drawable.img_phy_force);
        imageMap.put(36, R.drawable.img_phy_torque);
        imageMap.put(37, R.drawable.img_phy_centripetal_force);
        imageMap.put(38, R.drawable.img_phy_centripetal_acceleration);
        imageMap.put(39, R.drawable.img_phy_universal_gravitation);
        imageMap.put(42, R.drawable.img_phy_coulombs_law);
        imageMap.put(43, R.drawable.img_phy_escape_velocity);
        imageMap.put(44, R.drawable.img_phy_momentum);
        imageMap.put(45, R.drawable.img_phy_work);
        imageMap.put(46, R.drawable.img_phy_ohms_law);
        imageMap.put(49, R.drawable.img_phy_bernoullis_law);
        imageMap.put(50, R.drawable.img_phy_planck_constant);
        imageMap.put(51, R.drawable.img_phy_speed_of_light);
        imageMap.put(52, R.drawable.img_phy_permittivity);
        imageMap.put(53, R.drawable.img_phy_gravitation_constant);
        imageMap.put(54, R.drawable.img_phy_gravitational_accel);
        imageMap.put(55, R.drawable.img_chem_acid_base);
        imageMap.put(56, R.drawable.img_phy_angular_speed);
        imageMap.put(61, R.drawable.img_phy_gravitational_potential_energy);
        imageMap.put(62, R.drawable.img_phy_hookes_law);
        imageMap.put(63, R.drawable.img_phy_impulse);
        imageMap.put(66, R.drawable.img_phy_keplers_third_law);
        imageMap.put(67, R.drawable.img_phy_kinetic_energy);
        imageMap.put(69, R.drawable.img_phy_power);
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
        imageMap.put(85, R.drawable.img_phy_angular_momentum);
        imageMap.put(86, R.drawable.img_phy_beat_frequency);
        imageMap.put(87, R.drawable.img_phy_boltzmanns_constant);
        imageMap.put(88, R.drawable.img_phy_buoyant_force);
        imageMap.put(89, R.drawable.img_phy_carnot_efficiency);
        imageMap.put(90, R.drawable.img_phy_center_of_gravity);
        imageMap.put(91, R.drawable.img_phy_fluid_continuity);
        imageMap.put(92, R.drawable.img_phy_coulombs_constant);
        imageMap.put(93, R.drawable.img_phy_electrical_current);
        imageMap.put(94, R.drawable.img_phy_decibel_level);
        imageMap.put(95, R.drawable.img_phy_doppler_effect);
        imageMap.put(96, R.drawable.img_phy_electric_flux);
        imageMap.put(97, R.drawable.img_phy_electric_potential);
        imageMap.put(98, R.drawable.img_phy_electrical_field);
        imageMap.put(99, R.drawable.img_phy_electrical_potential_energy);
        imageMap.put(100, R.drawable.img_phy_electrical_power);
        imageMap.put(101, R.drawable.img_phy_entropy);
        imageMap.put(102, R.drawable.img_phy_first_thermodynamic_law);
        imageMap.put(103, R.drawable.img_phy_fluid_pressure);
        imageMap.put(104, R.drawable.img_phy_gauss_law);
        imageMap.put(105, R.drawable.img_phy_heat_engine_efficiency);
        imageMap.put(106, R.drawable.img_phy_heat_engine_work);
        imageMap.put(107, R.drawable.img_phy_heat_transfer);
        imageMap.put(108, R.drawable.img_phy_heat);
        imageMap.put(109, R.drawable.img_phy_intensity);
        imageMap.put(110, R.drawable.img_phy_internal_energy);
        imageMap.put(111, R.drawable.img_phy_latent_heat);
        imageMap.put(112, R.drawable.img_phy_pascals_principle);
        imageMap.put(113, R.drawable.img_phy_pendulum_period);
        imageMap.put(114, R.drawable.img_phy_spring_period);
        imageMap.put(115, R.drawable.img_phy_period);
        imageMap.put(116, R.drawable.img_phy_rotational_kinetic_energy);
        imageMap.put(117, R.drawable.img_phy_string_wave_speed);
        imageMap.put(118, R.drawable.img_phy_stefan_boltzmann_constant);
        imageMap.put(119, R.drawable.img_phy_stefans_law);
        imageMap.put(120, R.drawable.img_phy_linear_thermal_expansion);
        imageMap.put(121, R.drawable.img_phy_volumetric_thermal_expansion);
        imageMap.put(122, R.drawable.img_phy_wave_speed);
        imageMap.put(123, R.drawable.img_phy_work_on_gas);
        imageMap.put(124, R.drawable.img_phy_acceleration);
        imageMap.put(125, R.drawable.img_phy_angular_acceleration);
        imageMap.put(126, R.drawable.img_phy_friction);
        imageMap.put(127, R.drawable.img_phy_kinematic_equations);
        imageMap.put(128, R.drawable.img_phy_rotational_kinematic_equations);
        imageMap.put(129, R.drawable.img_phy_velocity);
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
