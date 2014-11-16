package com.centauri.equations.util.shape3d;

import com.centauri.equations.util.Complex;

public class Cone implements Polygon3D {

    private double radius, height, side;

    public Cone(double radius, double height, double side) {
        this.radius = radius;
        this.height = height;
        this.side = side;
    }

    public Complex volume() {
        return new Complex((1 / 3) * Math.PI * (radius * radius) * height);
    }

    public Complex surfaceArea() {
        return new Complex((Math.PI * radius * side)
                + (Math.PI * (radius * radius)));
    }

}
