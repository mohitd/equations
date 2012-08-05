package com.centuari.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class Pyramid implements Polygon3D {

    private double slant, width, lenght, height;

    public Pyramid(double slant, double width, double lenght, double height) {
	this.slant = slant;
	this.width = width;
	this.lenght = lenght;
	this.height = height;
    }

    public Complex volume() {
	return new Complex(lenght * width * height * (1 / 3));
    }

    public Complex surfaceArea() {
	double base = lenght * width;
	return new Complex((2 * base * slant) + (base * base));
    }

}
