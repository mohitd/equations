package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class Triangle {

    private double a, b, c;

    public Triangle(double a, double b) {
	this.a = a;
	this.b = b;
	this.c = hypotenuse().real();
    }

    public Triangle(double a, double b, double c) {
	if (a == 0) {
	    this.b = b;
	    this.c = c;
	    this.a = Math.sqrt((c * c) - (b * b));
	} else if (b == 0) {
	    this.a = a;
	    this.c = c;
	    this.b = Math.sqrt((c * c) - (a * a));
	} else if (c == 0) {
	    this.a = a;
	    this.b = b;
	    this.c = hypotenuse().real();
	} else if (a != 0 && b != 0) {
	    this.a = a;
	    this.b = b;
	    this.c = c;
	} else if ((a == 0) && (b == 0)) {
	    throw new IllegalArgumentException("Not a triangle!");
	}
    }

    public Complex area() {
	return new Complex(herons());
    }

    public Complex area(double height, double base) {
	return new Complex((1.0 / 2.0) * height * base);
    }

    public Complex perimeter() {
	return new Complex(a + b + c);
    }

    public Complex hypotenuse() {
	return new Complex(Math.sqrt((a * a) + (b * b)));
    }

    public Complex[] getSides() {
	Complex[] sides = { new Complex(a), new Complex(b), new Complex(c) };
	return sides;
    }

    private double herons() {
	return Math
		.sqrt(((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c)) / 16);
    }

}
