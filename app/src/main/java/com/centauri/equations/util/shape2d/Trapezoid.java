package com.centauri.equations.util.shape2d;

import com.centauri.equations.util.Complex;

public class Trapezoid {

    private double a, b, c, d, h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public Trapezoid(double a, double b, double c, double d, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
    }

    public Complex area() {
        return new Complex(((a + b) / 2) * h);
    }

    public Complex perimeter() {
        return new Complex(a + b + c + d);
    }

}
