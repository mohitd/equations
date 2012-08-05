package com.centuari.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class RectangularPrism implements Polygon3D {

    private double lenght, height, width;

    public RectangularPrism(double side) {
	this.lenght = this.height = this.width = side;
    }

    public RectangularPrism(double lengtht, double height, double width) {
	this.lenght = lengtht;
	this.height = height;
	this.width = width;
    }

    public Complex volume() {
	return new Complex(lenght * height * width);
    }

    public Complex surfaceArea() {
	return new Complex((2 * lenght * width) + (2 * lenght * height)
		+ (2 * width * height));
    }

}
