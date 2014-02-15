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
        formulaMap.put(6, PythagoreanActivity.ACTION_PYTHAGOREAN);
        formulaMap.put(7, HeronsFormulaActivity.ACTION_HERON);
        formulaMap.put(39, GravitationActivity.ACTION_GRAVITATION);
        formulaMap.put(42, CoulombsLawActivity.ACTION_COULOMBS_LAW);
        formulaMap.put(43, EscapeVelocityActivity.ACTION_ESCAPE_VELOCITY);

        fragmentMap.put(1, new QuadraticFormulaActivity.QuadraticFormulaFragment());
        fragmentMap.put(2, new DistanceFormulaActivity.DistanceFormulaFragment());
        fragmentMap.put(3, new RadicalActivity.RadicalFragment());
        fragmentMap.put(4, new SlopeActivity.SlopeFragment());
        fragmentMap.put(6, new PythagoreanActivity.PythagoreanFragment());
        fragmentMap.put(7, new HeronsFormulaActivity.HeronsFormulaFragment());
        fragmentMap.put(39, new GravitationActivity.GravitationFragment());
        fragmentMap.put(42, new CoulombsLawActivity.CoulombsLawFragment());
        fragmentMap.put(43, new EscapeVelocityActivity.EscapeVelocityFragment());

        imageMap.put(1, R.drawable.alg_quadratic_formula);
        imageMap.put(2, R.drawable.alg_distance_formula);
        imageMap.put(3, R.drawable.alg_radicand_simplify);
        imageMap.put(4, R.drawable.alg_slope);
        imageMap.put(6, R.drawable.geo_pythagorean_theorem);
        imageMap.put(7, R.drawable.geo_herons_formula);
        imageMap.put(8, R.drawable.trig_law_of_sines);
        imageMap.put(9, R.drawable.trig_law_of_cosines);
        imageMap.put(11, R.drawable.trig_product_to_sum_formulas);
        imageMap.put(12, R.drawable.trig_sum_product_formulas);
        imageMap.put(13, R.drawable.trig_power_reduction_formulas);
        imageMap.put(14, R.drawable.trig_sum_difference_formulas);
        imageMap.put(15, R.drawable.trig_even_odd_formulas);
        imageMap.put(16, R.drawable.trig_cofunction_identities);
        imageMap.put(17, R.drawable.trig_pythagorean_identities);
        imageMap.put(20, R.drawable.trig_reciprocal_identities);
        imageMap.put(24, R.drawable.alg_log_definition);
        imageMap.put(25, R.drawable.alg_log_identities);
        imageMap.put(26, R.drawable.alg_log_properties);
        imageMap.put(27, R.drawable.alg_sum_definition);
        imageMap.put(28, R.drawable.alg_sum_properties);
        imageMap.put(29, R.drawable.chem_boyles_law);
        imageMap.put(30, R.drawable.chem_charles_law);
        imageMap.put(31, R.drawable.chem_gay_lussacs_law);
        imageMap.put(32, R.drawable.chem_daltons_law);
        imageMap.put(33, R.drawable.chem_combined_gas_law);
        imageMap.put(35, R.drawable.phy_force);
        imageMap.put(36, R.drawable.phy_torque);
        imageMap.put(37, R.drawable.phy_centripetal_force);
        imageMap.put(38, R.drawable.phy_centripetal_acceleration);
        imageMap.put(39, R.drawable.phy_universal_gravitation);
        imageMap.put(42, R.drawable.phy_coulombs_law);
        imageMap.put(43, R.drawable.phy_escape_velocity);
        imageMap.put(44, R.drawable.phy_momentum);
        imageMap.put(45, R.drawable.phy_work);
        imageMap.put(46, R.drawable.phy_ohms_law);
        imageMap.put(49, R.drawable.phy_bernoullis_law);
        imageMap.put(50, R.drawable.phy_plancks_constant);
        imageMap.put(51, R.drawable.phy_speed_of_light);
        imageMap.put(52, R.drawable.phy_permittivity_of_free_space);
        imageMap.put(53, R.drawable.phy_gravitational_constant);
        imageMap.put(54, R.drawable.phy_gravitational_acceleration);
        imageMap.put(55, R.drawable.chem_acid_base_equations);
        imageMap.put(56, R.drawable.phy_angular_speed);
        imageMap.put(61, R.drawable.phy_gravitational_potential_energy);
        imageMap.put(62, R.drawable.phy_hookes_law);
        imageMap.put(63, R.drawable.phy_impulse);
        imageMap.put(66, R.drawable.phy_keplers_third_law);
        imageMap.put(67, R.drawable.phy_kinetic_energy);
        imageMap.put(69, R.drawable.phy_power);
        imageMap.put(76, R.drawable.alg_vec_definition);
        imageMap.put(77, R.drawable.alg_dot_product_definition);
        imageMap.put(78, R.drawable.alg_vec_properties);
        imageMap.put(79, R.drawable.alg_scalar_multiplication);
        imageMap.put(80, R.drawable.alg_demoivre);
        imageMap.put(81, R.drawable.alg_dot_product_properties);
        imageMap.put(82, R.drawable.alg_eulers_formula);
        imageMap.put(83, R.drawable.trig_trigonometric_form);
        imageMap.put(84, R.drawable.alg_vec_projection);
        imageMap.put(85, R.drawable.phy_angular_momentum);
        imageMap.put(86, R.drawable.phy_beat_frequency);
        imageMap.put(87, R.drawable.phy_boltzmann_constant);
        imageMap.put(88, R.drawable.phy_buoyant_force);
        imageMap.put(89, R.drawable.phy_carnot_efficiency);
        imageMap.put(90, R.drawable.phy_center_of_gravity);
        imageMap.put(91, R.drawable.phy_continuity_equation);
        imageMap.put(92, R.drawable.phy_coulombs_constant);
        imageMap.put(93, R.drawable.phy_current);
        imageMap.put(94, R.drawable.phy_decibel);
        imageMap.put(95, R.drawable.phy_doppler_effect);
        imageMap.put(96, R.drawable.phy_electric_flux);
        imageMap.put(97, R.drawable.phy_electric_potential);
        imageMap.put(98, R.drawable.phy_electric_field);
        imageMap.put(99, R.drawable.phy_electrical_potential_energy);
        imageMap.put(100, R.drawable.phy_electrical_power);
        imageMap.put(101, R.drawable.phy_entropy);
        imageMap.put(102, R.drawable.phy_first_law_of_thermodynamics);
        imageMap.put(103, R.drawable.phy_fluid_pressure);
        imageMap.put(104, R.drawable.phy_gausss_law);
        imageMap.put(105, R.drawable.phy_heat_engine_efficiency);
        imageMap.put(106, R.drawable.phy_heat_engine_work);
        imageMap.put(107, R.drawable.phy_heat_transfer);
        imageMap.put(108, R.drawable.phy_heat);
        imageMap.put(109, R.drawable.phy_intensity);
        imageMap.put(110, R.drawable.phy_internal_energy);
        imageMap.put(111, R.drawable.phy_latent_heat);
        imageMap.put(112, R.drawable.phy_pascals_principle);
        imageMap.put(113, R.drawable.phy_period_of_a_pendulum);
        imageMap.put(114, R.drawable.phy_period_of_a_spring);
        imageMap.put(116, R.drawable.phy_rotational_kinetic_energy);
        imageMap.put(117, R.drawable.phy_speed_of_a_wave_on_a_string);
        imageMap.put(118, R.drawable.phy_stefan_boltzmann_constant);
        imageMap.put(119, R.drawable.phy_stefans_law);
        imageMap.put(120, R.drawable.phy_linear_thermal_expansion);
        imageMap.put(121, R.drawable.phy_volumetric_thermal_expansion);
        imageMap.put(122, R.drawable.phy_wave_speed);
        imageMap.put(123, R.drawable.phy_work_on_a_gas);
        imageMap.put(124, R.drawable.phy_acceleration);
        imageMap.put(125, R.drawable.phy_angular_acceleration);
        imageMap.put(126, R.drawable.phy_friction);
        imageMap.put(127, R.drawable.phy_kinematic_equations);
        imageMap.put(128, R.drawable.phy_rotational_kinematic_equations);
        imageMap.put(129, R.drawable.phy_velocity);
        imageMap.put(130, R.drawable.geo_area_sector);
        imageMap.put(131, R.drawable.geo_area_ellipse);
        imageMap.put(132, R.drawable.trig_double_angle_formulas);
        imageMap.put(133, R.drawable.calc_derivative_definition);
        imageMap.put(134, R.drawable.calc_common_derivatives);
        imageMap.put(135, R.drawable.calc_trig_derivatives);
        imageMap.put(136, R.drawable.calc_exponential_derivatives);
        imageMap.put(137, R.drawable.calc_common_integrals);
        imageMap.put(138, R.drawable.calc_trig_integrals);
        imageMap.put(139, R.drawable.calc_exponential_integrals);
        imageMap.put(140, R.drawable.calc_inverse_trig_integrals);
        imageMap.put(141, R.drawable.stats_mean);
        imageMap.put(142, R.drawable.stats_std_dev);
        imageMap.put(143, R.drawable.stats_linear_transformations);
        imageMap.put(144, R.drawable.stats_z_scores);
        imageMap.put(145, R.drawable.stats_correlation);
        imageMap.put(146, R.drawable.stats_lsrl);
        imageMap.put(147, R.drawable.stats_probability);
        imageMap.put(148, R.drawable.stats_rv_means_variances);
        imageMap.put(149, R.drawable.stats_rules_for_means_variances);
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
