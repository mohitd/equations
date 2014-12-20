package com.centauri.equations;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;

public class FormulaMap {
    private static SparseIntArray imageMap = new SparseIntArray();

    static {
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
        imageMap.put(150, R.drawable.phy_amperes_law);
        imageMap.put(151, R.drawable.phy_biot_savart_law);
        imageMap.put(152, R.drawable.phy_capacitance);
        imageMap.put(153, R.drawable.phy_current_density);
        imageMap.put(154, R.drawable.phy_faradays_law_of_induction);
        imageMap.put(155, R.drawable.phy_gausss_law_of_magnetism);
        imageMap.put(156, R.drawable.phy_inductance);
        imageMap.put(157, R.drawable.phy_magnetic_flux);
        imageMap.put(158, R.drawable.phy_magnetic_force);
        imageMap.put(159, R.drawable.phy_magnetic_torque);
        imageMap.put(160, R.drawable.phy_permeability_of_free_space);
        imageMap.put(161, R.drawable.phy_resistance);
        imageMap.put(162, R.drawable.calc_eulers_method);
        imageMap.put(163, R.drawable.calc_integration_by_parts);
        imageMap.put(164, R.drawable.calc_lhopitals_rule);
        imageMap.put(165, R.drawable.calc_maclaurin_polynomial);
        imageMap.put(166, R.drawable.calc_taylor_polynomial);
        // Newest version
        imageMap.put(167, R.drawable.calc_absolute_conditional_convergence);
        imageMap.put(168, R.drawable.calc_alternating_series_test);
        imageMap.put(169, R.drawable.calc_arc_length);
        imageMap.put(170, R.drawable.calc_area_of_plane_regions);
        imageMap.put(171, R.drawable.calc_area_of_polar_regions);
        imageMap.put(172, R.drawable.calc_center_of_mass_1d);
        imageMap.put(173, R.drawable.calc_center_of_mass_2d);
        imageMap.put(174, R.drawable.calc_center_of_mass_3d);
        imageMap.put(175, R.drawable.calc_chain_rule);
        imageMap.put(176, R.drawable.calc_circulation_greens_theorem);
        imageMap.put(177, R.drawable.calc_clairauts_theorem);
        imageMap.put(178, R.drawable.calc_comparison_test);
        imageMap.put(179, R.drawable.calc_conservative_vector_field);
        imageMap.put(180, R.drawable.calc_curvature);
        imageMap.put(181, R.drawable.calc_cylindrical_coordinates);
        imageMap.put(182, R.drawable.calc_directional_derivative);
        imageMap.put(183, R.drawable.calc_divergence_test);
        imageMap.put(184, R.drawable.calc_divergence_theorem);
        imageMap.put(185, R.drawable.calc_double_integrals);
        imageMap.put(186, R.drawable.calc_flux_greens_theorem);
        imageMap.put(187, R.drawable.calc_fundamental_theorem_of_line_integrals);
        imageMap.put(188, R.drawable.calc_geometric_series);
        imageMap.put(189, R.drawable.calc_gradient);
        imageMap.put(190, R.drawable.calc_integral_test);
        imageMap.put(191, R.drawable.calc_lagrange_multipliers);
        imageMap.put(192, R.drawable.calc_limit_comparison_test);
        imageMap.put(193, R.drawable.calc_line_integrals);
        imageMap.put(194, R.drawable.calc_p_series);
        imageMap.put(195, R.drawable.calc_polynomial_remainder);
        imageMap.put(196, R.drawable.calc_radial_vector_fields);
        imageMap.put(197, R.drawable.calc_ratio_test);
        imageMap.put(198, R.drawable.calc_root_test);
        imageMap.put(199, R.drawable.calc_second_derivative_test);
        imageMap.put(200, R.drawable.calc_spherical_coordinates);
        imageMap.put(201, R.drawable.calc_stokes_theorem);
        imageMap.put(202, R.drawable.calc_surface_integrals_explicit_surfaces);
        imageMap.put(203, R.drawable.calc_surface_integrals_parametric_surfaces);
        imageMap.put(204, R.drawable.calc_tangent_planes);
        imageMap.put(205, R.drawable.calc_taylors_theorem);
        imageMap.put(206, R.drawable.calc_torsion);
        imageMap.put(207, R.drawable.calc_two_path_test);
    }

    private FormulaMap() {
    }

    public static Intent getIntent(long id) {
        return new Intent(ImageFormulaActivity.ACTION_VIEW_FORMULA);
    }

    public static Fragment getFragment(long id) {
        return new ImageFormulaActivity.ImageFormulaFragment();
    }

    public static int getImage(long id) {
        return imageMap.get((int) id);
    }
}
