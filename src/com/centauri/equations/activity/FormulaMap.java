package com.centauri.equations.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.centauri.equations.activity.algebra.DistanceFormulaActivity;
import com.centauri.equations.activity.algebra.LogarithmActivity;
import com.centauri.equations.activity.algebra.QuadraticFormulaActivity;
import com.centauri.equations.activity.algebra.RadicalActivity;
import com.centauri.equations.activity.algebra.SlopeActivity;
import com.centauri.equations.activity.algebra.SummationActivity;
import com.centauri.equations.activity.chem.AcidBaseActivity;
import com.centauri.equations.activity.chem.FunctionalGroupsActivity;
import com.centauri.equations.activity.chem.GasLawsActivity;
import com.centauri.equations.activity.chem.IdealGasActivity;
import com.centauri.equations.activity.geometry.AreaActivity;
import com.centauri.equations.activity.geometry.HeronsFormulaActivity;
import com.centauri.equations.activity.geometry.PythagoreanActivity;
import com.centauri.equations.activity.physics.AngularSpeedActivity;
import com.centauri.equations.activity.physics.AverageAccelActivity;
import com.centauri.equations.activity.physics.AverageAngularAccelActivity;
import com.centauri.equations.activity.physics.AverageVelocityActivity;
import com.centauri.equations.activity.physics.BernoullisLawActivity;
import com.centauri.equations.activity.physics.CentripetalAccelActivity;
import com.centauri.equations.activity.physics.CentripetalForceActivity;
import com.centauri.equations.activity.physics.CoulombsLawActivity;
import com.centauri.equations.activity.physics.DisplacementActivity;
import com.centauri.equations.activity.physics.EscapeVelocityActivity;
import com.centauri.equations.activity.physics.ForceActivity;
import com.centauri.equations.activity.physics.GravitationActivity;
import com.centauri.equations.activity.physics.GravitationEnergyActivity;
import com.centauri.equations.activity.physics.HookesLawActivity;
import com.centauri.equations.activity.physics.ImpulseActivity;
import com.centauri.equations.activity.physics.InstantAccelActivity;
import com.centauri.equations.activity.physics.InstantVelocityActivity;
import com.centauri.equations.activity.physics.KeplersThirdLawActivity;
import com.centauri.equations.activity.physics.KineticEnergyActivity;
import com.centauri.equations.activity.physics.MaxProjectileHeightActivity;
import com.centauri.equations.activity.physics.MaxProjectileRangeActivity;
import com.centauri.equations.activity.physics.MomentumActivity;
import com.centauri.equations.activity.physics.NewtonsThirdLawActivity;
import com.centauri.equations.activity.physics.OhmsLawActivity;
import com.centauri.equations.activity.physics.OneDimensionMotionActivity;
import com.centauri.equations.activity.physics.ParticleEnergyActivity;
import com.centauri.equations.activity.physics.PhysicsConstantsActivity;
import com.centauri.equations.activity.physics.PowerActivity;
import com.centauri.equations.activity.physics.ResistanceActivity;
import com.centauri.equations.activity.physics.StaticFrictionActivity;
import com.centauri.equations.activity.physics.TangentAccelActivity;
import com.centauri.equations.activity.physics.TangentSpeedActivity;
import com.centauri.equations.activity.physics.TorqueActivity;
import com.centauri.equations.activity.physics.VectorComponentsActivity;
import com.centauri.equations.activity.physics.VelocityEquActivity;
import com.centauri.equations.activity.physics.WorkActivity;
import com.centauri.equations.activity.trig.TrigActivity;

public class FormulaMap {

    static SparseArray<String> formulaMap = new SparseArray<String>();
    static SparseArray<Fragment> fragmentMap = new SparseArray<Fragment>();

    static {
	formulaMap.put(1, QuadraticFormulaActivity.ACTION_QUADRATIC);
	formulaMap.put(2, DistanceFormulaActivity.ACTION_DISTANCE);
	formulaMap.put(3, RadicalActivity.ACTION_RADICAL);
	formulaMap.put(4, SlopeActivity.ACTION_SLOPE);
	formulaMap.put(5, AreaActivity.ACTION_AREA);
	formulaMap.put(6, PythagoreanActivity.ACTION_PYTHAGOREAN);
	formulaMap.put(7, HeronsFormulaActivity.ACTION_HERON);
	formulaMap.put(8, TrigActivity.ACTION_SINES);
	formulaMap.put(9, TrigActivity.ACTION_COSINES);
	formulaMap.put(10, TrigActivity.ACTION_TANGENTS);
	formulaMap.put(11, TrigActivity.ACTION_PRODUCT_SUM);
	formulaMap.put(12, TrigActivity.ACTION_SUM_PRODUCT);
	formulaMap.put(13, TrigActivity.ACTION_POWER_REDUCTION);
	formulaMap.put(14, TrigActivity.ACTION_SUM_DIFFERENCE);
	formulaMap.put(15, TrigActivity.ACTION_EVEN_ODD);
	formulaMap.put(16, TrigActivity.ACTION_COFUNCTION);
	formulaMap.put(17, TrigActivity.ACTION_PYTHAGOREAN_IDENTITY);
	formulaMap.put(18, TrigActivity.ACTION_QUOTIENT);
	formulaMap.put(19, TrigActivity.ACTION_RIGHT_TRIANGLE);
	formulaMap.put(20, TrigActivity.ACTION_RECIPROCAL);
	formulaMap.put(21, IdealGasActivity.ACTION_GAS_LAW);
	formulaMap.put(22, GasLawsActivity.ACTION_GAS_CONSTANT);
	formulaMap.put(23, FunctionalGroupsActivity.ACTION_FUNCTION_GROUPS);
	formulaMap.put(24, LogarithmActivity.ACTION_LOG_DEF);
	formulaMap.put(25, LogarithmActivity.ACTION_LOG_IDENTITY);
	formulaMap.put(26, LogarithmActivity.ACTION_LOG_PROP);
	formulaMap.put(27, SummationActivity.ACTION_SUM_DEF);
	formulaMap.put(28, SummationActivity.ACTION_SUM_PROP);
	formulaMap.put(29, GasLawsActivity.ACTION_BOYLE_LAW);
	formulaMap.put(30, GasLawsActivity.ACTION_CHARLES_LAW);
	formulaMap.put(31, GasLawsActivity.ACTION_GAY_LUSSAC_LAW);
	formulaMap.put(32, GasLawsActivity.ACTION_DALTON_LAW);
	formulaMap.put(33, GasLawsActivity.ACTION_COMBINED_LAW);
	formulaMap.put(34, OneDimensionMotionActivity.ACTION_1D_MOTION);
	formulaMap.put(35, ForceActivity.ACTION_FORCE);
	formulaMap.put(36, TorqueActivity.ACTION_TORQUE);
	formulaMap.put(37, CentripetalForceActivity.ACTION_CENTRIPETAL_FORCE);
	formulaMap.put(38, CentripetalAccelActivity.ACTION_CENTRIPETAL_ACCEL);
	formulaMap.put(39, GravitationActivity.ACTION_GRAVITATION);
	formulaMap.put(40,
		MaxProjectileHeightActivity.ACTION_MAX_PROJECTILE_HEIGHT);
	formulaMap.put(41,
		MaxProjectileRangeActivity.ACTION_MAX_PROJECTILE_RANGE);
	formulaMap.put(42, CoulombsLawActivity.ACTION_COULOMBS_LAW);
	formulaMap.put(43, EscapeVelocityActivity.ACTION_ESCAPE_VELOCITY);
	formulaMap.put(44, MomentumActivity.ACTION_MOMENTUM);
	formulaMap.put(45, WorkActivity.ACTION_WORK);
	formulaMap.put(46, OhmsLawActivity.ACTION_OHMS_LAW);
	formulaMap.put(47, ParticleEnergyActivity.ACTION_PARTICLE_ENERGY);
	formulaMap.put(48, ResistanceActivity.ACTION_RESISTANCE);
	formulaMap.put(49, BernoullisLawActivity.ACTION_BERNOULLIS_LAW);
	formulaMap.put(50, PhysicsConstantsActivity.ACTION_PLANCK_CONSTANT);
	formulaMap.put(51, PhysicsConstantsActivity.ACTION_SPEED_OF_LIGHT);
	formulaMap.put(52, PhysicsConstantsActivity.ACTION_PERMITTIVITY);
	formulaMap
		.put(53, PhysicsConstantsActivity.ACTION_GRAVITATION_CONSTANT);
	formulaMap.put(54, PhysicsConstantsActivity.ACTION_GRAVITATION_ACCEL);
	formulaMap.put(55, AcidBaseActivity.ACTION_ACID_BASE_EQUATIONS);
	formulaMap.put(56, AngularSpeedActivity.ACTION_ANGULAR_SPEED);
	formulaMap.put(57, AverageAccelActivity.ACTION_AVERAGE_ACCEL);
	formulaMap.put(58,
		AverageAngularAccelActivity.ACTION_AVERAGE_ANGULAR_ACCEL);
	formulaMap.put(59, AverageVelocityActivity.ACTION_AVERAGE_VELOCITY);
	formulaMap.put(60, DisplacementActivity.ACTION_DISPLACEMENT);
	formulaMap.put(61, GravitationEnergyActivity.ACTION_GRAV_ENERGY);
	formulaMap.put(62, HookesLawActivity.ACTION_HOOKES_LAW);
	formulaMap.put(63, ImpulseActivity.ACTION_IMPULSE);
	formulaMap.put(64, InstantAccelActivity.ACTION_INSTANT_ACCEL);
	formulaMap.put(65, InstantVelocityActivity.ACTION_INSTANT_VELOCITY);
	formulaMap.put(66, KeplersThirdLawActivity.ACTION_KEPLERS_3_LAW);
	formulaMap.put(67, KineticEnergyActivity.ACTION_KINETIC_ENERGY);
	formulaMap.put(68, NewtonsThirdLawActivity.ACTION_NEWTONS_3_LAW);
	formulaMap.put(69, PowerActivity.ACTION_POWER);
	formulaMap.put(70, StaticFrictionActivity.ACTION_STATIC_FRICTION);
	formulaMap.put(71, TangentAccelActivity.ACTION_TANGENT_ACCEL);
	formulaMap.put(72, TangentSpeedActivity.ACTION_TANGENT_SPEED);
	formulaMap.put(73, VectorComponentsActivity.ACTION_VECTOR_COMP);
	formulaMap.put(74, VelocityEquActivity.ACTION_VELOCITY_EQU);

	fragmentMap.put(1,
		new QuadraticFormulaActivity.QuadraticFormulaFragment());
	fragmentMap.put(2,
		new DistanceFormulaActivity.DistanceFormulaFragment());
	fragmentMap.put(3, new RadicalActivity.RadicalFragment());
	fragmentMap.put(4, new SlopeActivity.SlopeFragment());
	fragmentMap.put(5, new AreaActivity.AreaFragment());
	fragmentMap.put(6, new PythagoreanActivity.PythagoreanFragment());
	fragmentMap.put(7, new HeronsFormulaActivity.HeronsFormulaFragment());
	fragmentMap.put(8, new TrigActivity.LawOfSinesFragment());
	fragmentMap.put(9, new TrigActivity.LawOfCosinesFragment());
	fragmentMap.put(10, new TrigActivity.LawOfTangentsFragment());
	fragmentMap.put(11, new TrigActivity.ProductToSumFragment());
	fragmentMap.put(12, new TrigActivity.SumToProductFragment());
	fragmentMap.put(13, new TrigActivity.PowerReductionFragment());
	fragmentMap.put(14, new TrigActivity.SumDifferenceFragment());
	fragmentMap.put(15, new TrigActivity.EvenOddFragment());
	fragmentMap.put(16, new TrigActivity.CofunctionFragment());
	fragmentMap.put(17, new TrigActivity.PythagoreanIdentitiesFragment());
	fragmentMap.put(18, new TrigActivity.QuotientFragment());
	fragmentMap.put(19, new TrigActivity.RightTriangleFragment());
	fragmentMap.put(20, new TrigActivity.ReciprocalFragment());
	fragmentMap.put(21, new IdealGasActivity.IdealGasFragment());
	fragmentMap.put(22, new GasLawsActivity.GasConstantFragment());
	fragmentMap.put(23,
		new FunctionalGroupsActivity.FunctionalGroupFragment());
	fragmentMap.put(24, new LogarithmActivity.LogarithmDefFragment());
	fragmentMap.put(25, new LogarithmActivity.LogarithmIdentityFragment());
	fragmentMap.put(26, new LogarithmActivity.LogarithmPropFragment());
	fragmentMap.put(27, new SummationActivity.SummationDefFragment());
	fragmentMap.put(28, new SummationActivity.SummationPropFragment());
	fragmentMap.put(29, new GasLawsActivity.BoylesLawFragment());
	fragmentMap.put(30, new GasLawsActivity.CharlesLawFragment());
	fragmentMap.put(31, new GasLawsActivity.GayLussacLawFragment());
	fragmentMap.put(32, new GasLawsActivity.DaltonsFragment());
	fragmentMap.put(33, new GasLawsActivity.CombinedGasLawFragment());
	fragmentMap.put(34,
		new OneDimensionMotionActivity.OneDimensionMotionFragment());
	fragmentMap.put(35, new ForceActivity.ForceFragment());
	fragmentMap.put(36, new TorqueActivity.TorqueFragment());
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
	fragmentMap.put(44, new MomentumActivity.MomentumFragment());
	fragmentMap.put(45, new WorkActivity.WorkFragment());
	fragmentMap.put(46, new OhmsLawActivity.OhmsLawFragment());
	fragmentMap
		.put(47, new ParticleEnergyActivity.ParticleEnergyFragment());
	fragmentMap.put(48, new ResistanceActivity.ResistanceFragment());
	fragmentMap.put(49, new BernoullisLawActivity.BernoullisLawFragment());
	fragmentMap.put(50,
		new PhysicsConstantsActivity.PlancksConstantFragment());
	fragmentMap
		.put(51, new PhysicsConstantsActivity.SpeedOfLightFragment());
	fragmentMap
		.put(52, new PhysicsConstantsActivity.PermittivityFragment());
	fragmentMap.put(53,
		new PhysicsConstantsActivity.GravitationConstantFragment());
	fragmentMap.put(54,
		new PhysicsConstantsActivity.GravitationAccelFragment());
	fragmentMap.put(55, new AcidBaseActivity.AcidBaseFragment());
	fragmentMap.put(56, new AngularSpeedActivity.AngularSpeedFragment());
	fragmentMap.put(57, new AverageAccelActivity.AverageAccelFragment());
	fragmentMap.put(58,
		new AverageAngularAccelActivity.AverageAngularAccelFragment());
	fragmentMap.put(59,
		new AverageVelocityActivity.AverageVelocityFragment());
	fragmentMap.put(60, new DisplacementActivity.DisplacementFragment());
	fragmentMap.put(61,
		new GravitationEnergyActivity.GravitationEnergyFragment());
	fragmentMap.put(62, new HookesLawActivity.HookesLawFragment());
	fragmentMap.put(63, new ImpulseActivity.ImpulseFragment());
	fragmentMap.put(64, new InstantAccelActivity.InstantAccelFragment());
	fragmentMap.put(65,
		new InstantVelocityActivity.InstantVelocityFragment());
	fragmentMap.put(66, new KeplersThirdLawActivity.Keplers3LawFragment());
	fragmentMap.put(67, new KineticEnergyActivity.KineticEnergyFragment());
	fragmentMap.put(68, new NewtonsThirdLawActivity.Newtons3LawFragment());
	fragmentMap.put(69, new PowerActivity.PowerFragment());
	fragmentMap
		.put(70, new StaticFrictionActivity.StaticFrictionFragment());
	fragmentMap.put(71, new TangentAccelActivity.TangentAccelFragment());
	fragmentMap.put(72, new TangentSpeedActivity.TangentSpeedFragment());
	fragmentMap.put(73, new VectorComponentsActivity.VectorCompFragment());
	fragmentMap.put(74, new VelocityEquActivity.VelocityEquFragment());
    }

    private FormulaMap() {
    }

    public static Intent getIntent(long id) {
	if (id < 0 || id > 74)
	    throw new IllegalArgumentException("Invalid id: " + id);
	String action = formulaMap.get((int) id);
	return new Intent(action);
    }

    public static Fragment getFragment(long id) {
	if (id < 0 || id > 74)
	    throw new IllegalArgumentException("Invalid id: " + id);
	Fragment fragment = fragmentMap.get((int) id);
	return fragment;
    }
}
