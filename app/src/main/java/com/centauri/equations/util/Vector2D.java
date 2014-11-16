/**
 * 
 */
package com.centauri.equations.util;

/**
 * @author mohitd2000
 * 
 */
public class Vector2D {
    private double a;
    private double b;

    public static final Vector2D ZERO = new Vector2D();
    public static final Vector2D I = new Vector2D(1, 0);
    public static final Vector2D J = new Vector2D(0, 1);

    public Vector2D() {
        a = 0;
        b = 0;
    }

    public Vector2D(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Vector2D(Point2D initial, Point2D terminal) {
        this.a = terminal.getX() - initial.getX();
        this.b = terminal.getY() - initial.getY();
    }

    public double getXComponent() {
        return a;
    }

    public double getYComponent() {
        return b;
    }

    public Vector2D add(Vector2D vec2) {
        return new Vector2D(a + vec2.a, b + vec2.b);
    }

    public Vector2D subtract(Vector2D vec2) {
        return new Vector2D(a - vec2.a, b - vec2.b);
    }

    public double dot(Vector2D vec2) {
        return (a * vec2.a) + (b * vec2.b);
    }

    public double getAngle() {
        return Math.atan2(b, a);
    }

    public double length() {
        return Math.sqrt((a * a) + (b * b));
    }

    public double lengthSquared() {
        return (a * a) + (b * b);
    }

    public Vector2D normalize() {
        Vector2D resultant = new Vector2D();
        double length = length();

        if (length != 0) {
            resultant.a = a / length;
            resultant.b = b / length;
        }

        return resultant;
    }

    public double angle(Vector2D vec2) {
        return Math.atan2(vec2.b, vec2.a) - Math.atan2(b, a);
    }

    public Vector2D negate() {
        return new Vector2D(-a, -b);
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "<" + a + "," + b + ">";
    }
}
