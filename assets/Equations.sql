-- Create the table
CREATE TABLE IF NOT EXISTS formula (_id INTEGER PRIMARY KEY AUTOINCREMENT, suggest_text_1 TEXT NOT NULL, category TEXT NOT NULL, favorite INTEGER);

-- Start inserting comments
INSERT INTO formula (suggest_text_1, category) VALUES ('Quadratic Formula', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Distance Formula', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Radicand Simplify', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Slope', 'Algebra');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Area', 'Geometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Pythagorean Theorem', 'Geometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Heron''s Formula', 'Geometry');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Law of Sines', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Law of Cosines', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Law of Tangents', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Product to Sum Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Sum to Product Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Power Reduction Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Sum and Difference Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Even and Odd Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Cofunction Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Pythagorean Identities', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Quotient Formulas', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Right Triangle Definition', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Reciprocal Identities', 'Trigonometry');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Ideal Gas Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Ideal Gas Constant', 'Physics');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Functional Groups', 'Chemistry');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Logarithm Definition', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Logarithm Identities', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Logarithm Properties', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Summation Definition', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Summation Properties', 'Algebra');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('Boyle''s Law', 'Chemistry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Charles'' Law', 'Chemistry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Gay Lussac''s Law', 'Chemistry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Dalton''s Law', 'Chemistry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Combined Gas Law', 'Chemistry');
	
INSERT INTO formula (suggest_text_1, category) VALUES ('One Dimensional Motion', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Force', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Torque', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Centripetal Force', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Centripetal Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Newton''s Law of Universal Gravitation', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Maximum Height of a Projectile', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Maximum Range of a Projectile', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Coulomb''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Escape Velocity', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Momentum', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Work', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Ohm''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Particle Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Resistance', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Bernoulli''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Planck''s Constant', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Speed of Light', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Permittivity of Free Space', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Gravitational Constant', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Gravitational Acceleration', 'Physics');

INSERT INTO formula (suggest_text_1, category) VALUES ('Acid/Base Equations', 'Chemistry');
	
-- Version 2
INSERT INTO formula (suggest_text_1, category) VALUES ('Angular Speed', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Average Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Average Angular Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Average Velocity', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Displacement', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Gravitational Potential Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Hooke''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Impulse', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Instantaneous Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Instantaneous Velocity', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Kepler''s Third Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Kinetic Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Newton''s Third Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Power', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Static Friction', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Tangential Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Tangential Speed', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Components', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Velocity Equations', 'Physics');
	
-- Version 3
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Addition and Subtraction', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Definition', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Dot Product', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Properties', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Scalar Multiplication', 'Algebra');

-- Version 4
INSERT INTO formula (suggest_text_1, category) VALUES ('De Moivre''s Theorem', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Dot Properties', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Euler''s Formula', 'Algebra');
INSERT INTO formula (suggest_text_1, category) VALUES ('Trigonometric Form', 'Trigonometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Vector Projection', 'Algebra');

-- Version 5
INSERT INTO formula (suggest_text_1, category) VALUES ('Angular Momentum', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Beat Frequency', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Boltzmann Constant', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Buoyant Force', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Carnot Efficiency', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Center of Gravity', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Continuity Equation', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Coulomb''s Constant', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Current', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Decibel', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Doppler Effect', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Electric Flux', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Electric Potential', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Electrical Field', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Electrical Potential Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Electrical Power', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Entropy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('First Law of Thermodynamics', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Fluid Pressure', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Gauss''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Heat Engine Efficiency', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Heat Engine Work', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Heat Transfer', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Heat', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Intensity', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Internal Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Latent Heat', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Pascal''s Principle', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Period of a Pendulum', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Period of a Spring', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Period', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Rotational Kinetic Energy', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Speed of a Wave on a String', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Stefan-Boltzmann Constant', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Stefan''s Law', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Linear Thermal Expansion', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Volumetric Thermal Expansion', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Wave Speed', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Work on a Gas', 'Physics');

-- Version 8
DELETE FROM formula WHERE suggest_text_1='Displacement';
DELETE FROM formula WHERE suggest_text_1='Instantaneous Velocity';
DELETE FROM formula WHERE suggest_text_1='Instantaneous Acceleration';
DELETE FROM formula WHERE suggest_text_1='Maximum Height of a Projectile';
DELETE FROM formula WHERE suggest_text_1='Maximum Range of a Projectile';
DELETE FROM formula WHERE suggest_text_1='Newton''s Third Law';
DELETE FROM formula WHERE suggest_text_1='One Dimensional Motion';
DELETE FROM formula WHERE suggest_text_1='Particle Energy';
DELETE FROM formula WHERE suggest_text_1='Static Friction';
DELETE FROM formula WHERE suggest_text_1='Resistance';
DELETE FROM formula WHERE suggest_text_1='Tangential Acceleration';
DELETE FROM formula WHERE suggest_text_1='Tangential Speed';
DELETE FROM formula WHERE suggest_text_1='Vector Components';
DELETE FROM formula WHERE suggest_text_1='Velocity Equations';
DELETE FROM formula WHERE suggest_text_1='Average Acceleration';
DELETE FROM formula WHERE suggest_text_1='Average Angular Acceleration';
DELETE FROM formula WHERE suggest_text_1='Average Velocity';

INSERT INTO formula (suggest_text_1, category) VALUES ('Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Angular Acceleration', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Friction', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Kinematic Equations', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Rotational Kinematic Equations', 'Physics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Velocity', 'Physics');

-- Version 9
DELETE FROM formula WHERE suggest_text_1='Vector Addition and Subtraction';
DELETE FROM formula WHERE suggest_text_1='Functional Groups';
DELETE FROM formula WHERE suggest_text_1='Law of Tangents';
DELETE FROM formula WHERE suggest_text_1='Quotient Formulas';
DELETE FROM formula WHERE suggest_text_1='Right Triangle Definition';
DELETE FROM formula WHERE suggest_text_1='Period';
DELETE FROM formula WHERE suggest_text_1='Area';

UPDATE formula SET suggest_text_1='Dot Product Definition' WHERE _id=77;
UPDATE formula SET suggest_text_1='Dot Product Properties' WHERE _id=81;

INSERT INTO formula (suggest_text_1, category) VALUES ('Area of a Sector', 'Geometry');
INSERT INTO formula (suggest_text_1, category) VALUES ('Area of an Ellipse', 'Geometry');

INSERT INTO formula (suggest_text_1, category) VALUES ('Double Angle Formula', 'Trigonometry');

-- Version 10
INSERT INTO formula (suggest_text_1, category) VALUES ('Derivative Definition', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Common Derivatives', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Trigonometric Derivatives', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Exponential Derivatives', 'Calculus');

INSERT INTO formula (suggest_text_1, category) VALUES ('Common Integrals', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Trigonometric Integrals', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Exponential Integrals', 'Calculus');
INSERT INTO formula (suggest_text_1, category) VALUES ('Inverse Trigonometric Integrals', 'Calculus');

INSERT INTO formula (suggest_text_1, category) VALUES ('Mean', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Standard Deviation', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Linear Transformations', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Z-Score', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Correlation', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Least-Squares Regression', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Probability', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Random Variable Means and Variance', 'Statistics');
INSERT INTO formula (suggest_text_1, category) VALUES ('Rules for Means and Variance', 'Statistics');


