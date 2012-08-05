package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class NGon {

    private double s, n;

    public NGon(double side, double numberOfSides) {
	this.s = side;
	this.n = numberOfSides;
    }

    public Complex area() {
	return new Complex((s * s * n)
		/ (4 * Math.tan(Math.toRadians(180.0 / n))));
    }

    public Complex perimeter() {
	return new Complex(s * n);
    }

}
