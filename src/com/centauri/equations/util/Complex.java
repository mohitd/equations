package com.centauri.equations.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * This class represents all numbers (as all numbers can be represented as
 * complex numbers).
 * 
 * @author mohitd2000
 * @since 0.2
 */
public class Complex {

    // The real "part"
    private double real;

    // The imaginary "part:
    private double imag;

    /**
     * The default constructor that creates 0 + 0<i>i</i>
     */
    public Complex() {
	real = 0;
	imag = 0;
    }

    /**
     * The copy constructor
     * 
     * @param z
     *            The complex number to be copied
     */
    public Complex(Complex z) {
	this.real = z.real();
	this.imag = z.imag();
    }

    /**
     * The constructor to create a real number (no imaginary part)
     * 
     * @param real
     *            The real number
     */
    public Complex(double real) {
	this.real = real;
	imag = 0;
    }

    /**
     * The constructor to create a complex number
     * 
     * @param real
     *            The real part
     * @param imag
     *            The imaginary, coefficient of <i>i</i> part.
     */
    public Complex(double real, double imag) {
	this.real = real;
	this.imag = imag;
    }

    /**
     * Adds a Complex number to {@code this}
     * 
     * @param z
     *            The Complex number to be added to {@code this}
     * @return The addition of {@code this} and {@code z}
     */
    public Complex add(Complex z) {
	return new Complex(this.real + z.real(), this.imag + z.imag());
    }

    /**
     * Subtracts a Complex number from {@code this}
     * 
     * @param z
     *            The Complex number to be subtracted from {@code this}
     * @return The subtraction of {@code this} and {@code z}
     */
    public Complex sub(Complex z) {
	return new Complex(this.real - z.real(), this.imag + z.imag());
    }

    /**
     * Multiplies a Complex number to {@code this}
     * 
     * @param z
     *            The Complex number to be multiplied to {@code this}
     * @return The multiplication of {@code this} and {@code z}
     */
    public Complex mul(Complex z) {
	return new Complex(this.real * z.real() - this.imag * z.imag(),
		this.imag * z.real() + this.real * z.imag());
    }

    /**
     * Divides a Complex number from {@code this}
     * 
     * @param z
     *            The Complex number to be divided from {@code this}
     * @return The division of {@code this} and {@code z}
     */
    public Complex div(Complex z) {
	double den = 0;
	if (z.real() != 0 || z.imag() != 0) {
	    den = z.real() * z.real() + z.imag() * z.imag();
	}

	return new Complex((this.real * z.real() - this.imag * z.imag()) / den,
		(this.imag * z.real() + this.real * z.imag()) / den);
    }

    /**
     * Creates a new Complex number that is the conjugate of {@code this}
     * 
     * @return The conjugate of {@code this}
     */
    public Complex conj() {
	return new Complex(this.real, -(this.imag));
    }

    /**
     * @return The real part
     */
    public double real() {
	return real;
    }

    /**
     * @return The imaginary part
     */
    public double imag() {
	return imag;
    }

    /**
     * @return {@code this} in the form "a + b<i>i</i>"
     */
    @Override
    public String toString() {
	StringBuilder buffer = new StringBuilder();
	NumberFormat format = NumberFormat.getInstance();
	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	if (format instanceof DecimalFormat) {
	    symbols = ((DecimalFormat) format).getDecimalFormatSymbols();
	}
	DecimalFormat style = new DecimalFormat("0.##########", symbols);

	if (imag == 0) {
	    buffer.append(style.format(real));
	} else if (imag != 0) {
	    if (imag < 0) {
		buffer.append("(").append(style.format(real)).append("-")
			.append(style.format(-imag)).append("i)");
	    } else if (imag > 0) {
		buffer.append("(").append(style.format(real)).append("+")
			.append(style.format(+imag)).append("i)");
	    }
	}

	return buffer.toString();
    }

    public double abs() {
	return Math.sqrt(real * real + imag * imag);
    }

}
