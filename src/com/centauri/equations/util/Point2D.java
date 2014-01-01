package com.centauri.equations.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class Point2D {

    private double x;
    private double y;

    /**
     * The default constructor that sets the initial value of
     * 
     * @param x
     *            The default X coordinate
     * @param y
     *            The default Y coordinate
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Complex distance(Point2D point) {
        double deltaX = point.x - x;
        double deltaY = point.y - y;

        return new Complex(Math.sqrt((deltaX * deltaX) + (deltaY * deltaY)));
    }

    public Complex slope(Point2D point) {
        double deltaX = point.x - x;
        double deltaY = point.y - y;

        return new Complex(deltaY / deltaX);
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getInstance();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        if (format instanceof DecimalFormat) {
            symbols = ((DecimalFormat) format).getDecimalFormatSymbols();
        }
        DecimalFormat style = new DecimalFormat("0.##########", symbols);
        return "(" + style.format(x) + "; " + style.format(y) + ")";
    }
}
