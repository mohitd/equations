package com.centuari.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class TriangularPrism implements Polygon3D {

    private double lenght, height, width, base;

    public TriangularPrism(double lenght, double height, double width,
	    double base) {
	this.lenght = lenght;
	this.height = height;
	this.width = width;
	this.base = base;
    }

    public Complex volume() {
	return new Complex((1 / 3) * lenght * height * width);
    }

    public Complex surfaceArea() {
	return new Complex((3 * lenght * width) + (2 * ((base * height) / 2)));
    }

}
