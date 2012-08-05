package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class Quadrilateral {

    private double lenght;
    private double width;

    public Quadrilateral(double lenght) {
	this.lenght = this.width = lenght;
    }

    public Quadrilateral(double width, double lenght) {
	this.lenght = lenght;
	this.width = width;
    }

    public Complex area() {
	return new Complex(lenght * width);
    }

    public Complex perimeter() {
	return new Complex(2 * lenght + 2 * width);
    }

}
