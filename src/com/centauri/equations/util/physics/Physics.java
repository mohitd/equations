package com.centauri.equations.util.physics;

import com.centauri.equations.util.Complex;

public final class Physics {

    private Physics() {
    }

    public static final double PLANCK_CONSTANT = 6.6260693e23;
    public static final double PERMITIVITY = 8.85418782e-12;
    public static final double SPEED_OF_LIGHT = 299792458;
    public static final double GRAVITATIONAL_CONSTANT = 6.674210e-11;
    public static final double GRAVITATIONAL_ACCELERATION = 9.80665;

    private static final double e_0 = PERMITIVITY;
    private static final double G = GRAVITATIONAL_CONSTANT;
    private static final double g = GRAVITATIONAL_ACCELERATION;

    public static Complex velocity(double v, double u, double a, double s) {
        double result = 0;
        if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((u * u) + (2 * a * s));
        } else if (u == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((v * v) - (2 * a * s));
        } else if (a == Double.NEGATIVE_INFINITY) {
            result = (((v * v) - (u * u)) / (2 * s));
        } else if (s == Double.NEGATIVE_INFINITY) {
            result = (((v * v) - (u * u)) / (2 * a));
        }

        return new Complex(result);
    }

    public static Complex force(double f, double m, double a) {
        double result = 0;
        if (f == Double.NEGATIVE_INFINITY) {
            result = m * a;
        } else if (m == Double.NEGATIVE_INFINITY) {
            result = a / f;
        } else if (a == Double.NEGATIVE_INFINITY) {
            result = m / f;
        }

        return new Complex(result);
    }

    public static Complex torque(double t, double r, double f, double a) {
        double result = 0;
        if (t == Double.NEGATIVE_INFINITY) {
            result = r * f * Math.sin(a);
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = (t / (f * Math.sin(a)));
        } else if (f == Double.NEGATIVE_INFINITY) {
            result = (t / (r * Math.sin(a)));
        } else if (a == Double.NEGATIVE_INFINITY) {
            result = Math.asin(t / (r * f));
        }

        return new Complex(result);
    }

    public static Complex centripetalForce(double f, double m, double v,
            double r) {
        double result = 0;
        if (f == Double.NEGATIVE_INFINITY) {
            result = ((m * v * v) / r);
        } else if (m == Double.NEGATIVE_INFINITY) {
            result = ((f * r) / (v * v));
        } else if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((f * r) / m);
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = ((m * v * v) / f);
        }

        return new Complex(result);
    }

    public static Complex centripetalAccel(double a, double v, double r) {
        double result = 0;
        if (a == Double.NEGATIVE_INFINITY) {
            result = (v * v) / r;
        } else if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt(a * r);
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = (v * v) / a;
        }

        return new Complex(result);
    }

    public static Complex universalGravitation(double f, double m1, double m2,
            double r) {
        double result = 0;
        if (f == Double.NEGATIVE_INFINITY) {
            result = (G * m1 * m2) / (r * r);
        } else if (m1 == Double.NEGATIVE_INFINITY) {
            result = (r * r * f) / (G * m2);
        } else if (m2 == Double.NEGATIVE_INFINITY) {
            result = (r * r * f) / (G * m1);
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((G * m1 * m2) / f);
        }

        return new Complex(result);
    }

    public static Complex maxProjectileHeight(double h, double v, double t) {
        double result = 0;
        if (h == Double.NEGATIVE_INFINITY) {
            result = (v * v * Math.sin(t) * Math.sin(t)) / (2 * g);
        } else if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((2 * g * h) / (Math.sin(t) * Math.sin(t)));
        } else if (t == Double.NEGATIVE_INFINITY) {
            result = Math.asin((Math.sqrt(2 * g * h)) / v);
        }

        return new Complex(result);
    }

    public static Complex maxProjectileRange(double l, double v, double t) {
        double result = 0;
        if (l == Double.NEGATIVE_INFINITY) {
            result = (v * v * Math.sin(2 * t)) / g;
        } else if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((l * g) / Math.sin(2 * t));
        } else if (t == Double.NEGATIVE_INFINITY) {
            result = (Math.asin((l * g) / (v * v))) / 2;
        }

        return new Complex(result);
    }

    public static Complex coulombsLaw(double f, double q1, double q2, double r) {
        double result = 0;
        if (f == Double.NEGATIVE_INFINITY) {
            result = (q1 * q2) / (4 * Math.PI * e_0 * r * r);
        } else if (q1 == Double.NEGATIVE_INFINITY) {
            result = (f * 4 * Math.PI * e_0 * r * r) / q2;
        } else if (q2 == Double.NEGATIVE_INFINITY) {
            result = (f * 4 * Math.PI * e_0 * r * r) / q1;
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt((q1 * q2) / (f * 4 * Math.PI * e_0));
        }

        return new Complex(result);
    }

    public static Complex escapeVelocity(double v, double m, double r) {
        double result = 0;
        if (v == Double.NEGATIVE_INFINITY) {
            result = Math.sqrt(2 * G * m / r);
        } else if (m == Double.NEGATIVE_INFINITY) {
            result = (v * v * r) / (2 * G);
        } else if (r == Double.NEGATIVE_INFINITY) {
            result = (2 * G * m) / (v * v);
        }

        return new Complex(result);
    }

    public static Complex momentum(double p, double m, double v) {
        double result = 0;
        if (p == Double.NEGATIVE_INFINITY) {
            result = m * v;
        } else if (m == Double.NEGATIVE_INFINITY) {
            result = p / v;
        } else if (v == Double.NEGATIVE_INFINITY) {
            result = p / m;
        }

        return new Complex(result);
    }

    public static Complex work(double w, double f, double d) {
        double result = 0;
        if (w == Double.NEGATIVE_INFINITY) {
            result = f * d;
        } else if (f == Double.NEGATIVE_INFINITY) {
            result = w / d;
        } else if (d == Double.NEGATIVE_INFINITY) {
            result = w / f;
        }

        return new Complex(result);
    }

    public static Complex ohmsLaw(double I, double V, double R) {
        double result = 0;
        if (I == Double.NEGATIVE_INFINITY) {
            result = V / R;
        } else if (V == Double.NEGATIVE_INFINITY) {
            result = I * R;
        } else if (R == Double.NEGATIVE_INFINITY) {
            result = V / I;
        }

        return new Complex(result);
    }
}
