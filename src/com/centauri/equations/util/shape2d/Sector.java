package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class Sector {

    private double degrees, radius;

    public Sector(double degrees, double radius) {
	this.degrees = degrees;
	this.radius = radius;
    }

    public Complex area() {
	return new Complex((radius * radius) * (degrees * Math.PI / 180.0)
		* (1.0 / 2.0));
    }

    public Complex perimeter() {
	return new Complex(radius * (degrees + 2));
    }

}
