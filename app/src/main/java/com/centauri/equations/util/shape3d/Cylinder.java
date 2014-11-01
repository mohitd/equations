package com.centauri.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class Cylinder implements Polygon3D {

    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public Complex volume() {
        return new Complex(Math.PI * (radius * radius) * height);
    }

    public Complex surfaceArea() {
        return new Complex(2 * (Math.PI * (radius * radius))
                + (2 * Math.PI * radius) * height);
    }

}
