package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class Ellipse {

    private double majorAxis;
    private double minorAxis;

    public Ellipse(double radius) {
	this.majorAxis = this.minorAxis = radius;
    }

    public Ellipse(double majorAxis, double minorAxis) {
	this.majorAxis = majorAxis;
	this.minorAxis = minorAxis;
    }

    public Complex area() {
	return new Complex(Math.PI * majorAxis * minorAxis);
    }

    public Complex perimeter() {
	return new Complex(
		Math.PI
			* ((3 * majorAxis * minorAxis) - Math
				.sqrt((3 * majorAxis + minorAxis)
					* (3 * minorAxis + majorAxis))));
    }

}
