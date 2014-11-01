package com.centauri.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class Sphere implements Polygon3D {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public Complex volume() {
        return new Complex((4 / 3) * Math.PI * (radius * radius * radius));
    }

    public Complex surfaceArea() {
        return new Complex(4 * Math.PI * (radius * radius));
    }

}
