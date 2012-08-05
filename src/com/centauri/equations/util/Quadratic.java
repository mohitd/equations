package com.centauri.equations.util;

import java.util.ArrayList;

public class Quadratic {

    private double ax, bx, c;

    public Quadratic(double a, double b, double c) {
	this.ax = a;
	this.bx = b;
	this.c = c;
    }

    public ArrayList<Complex> getRoots() {
	ArrayList<Complex> roots = new ArrayList<Complex>();

	if (ax == 0 && bx == 0)
	    return null;
	else if (ax == 0) {
	    // Only one real root
	    roots.add(new Complex(-c / bx));
	    return roots;
	}

	double discriminant = (bx * bx) - (4 * ax * c);

	if (discriminant > 0) {
	    // Two roots
	    roots.add(new Complex((-bx + Math.sqrt(discriminant)) / (2 * ax)));
	    roots.add(new Complex((-bx - Math.sqrt(discriminant)) / (2 * ax)));
	} else if (discriminant == 0) {
	    // Both roots are the same
	    roots.add(new Complex((-bx) / (2 * ax)));
	} else if (discriminant < 0) {
	    // Imaginary roots
	    Complex root1 = new Complex(((-bx) / (2 * ax)),
		    (Math.sqrt(-discriminant) / (2 * ax)));
	    Complex root2 = root1.conj();
	    roots.add(root1);
	    roots.add(root2);
	}

	return roots;
    }

    public double evaluate(double x) {
	return (ax * (x * x)) + (bx * x) + c;
    }

    @Override
    public String toString() {
	return ax + "x<sup>2</sup>" + bx + "x" + c;
    }

}
