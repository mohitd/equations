package com.centauri.equations.util;

import java.text.DecimalFormat;

public class Point2D {
    double x;
    double y;

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

    public void setPoint(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public void setPoint(Point2D point) {
	this.x = point.getX();
	this.y = point.getY();
    }

    public Complex distance(Point2D point) {
	double deltaX = point.getX() - this.getX();
	double deltaY = point.getY() - this.getY();

	return new Complex(Math.sqrt((deltaX * deltaX) + (deltaY * deltaY)));
    }

    public Complex slope(Point2D point) {
	double deltaX = point.getX() - this.getX();
	double deltaY = point.getY() - this.getY();

	return new Complex(deltaY / deltaX);
    }

    /**
     * @return the x
     */
    public double getX() {
	return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(double x) {
	this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
	return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(double y) {
	this.y = y;
    }

    @Override
    public String toString() {
	DecimalFormat style = new DecimalFormat("0.###");
	return "(" + style.format(x) + ", " + style.format(y) + ")";
    }
}
