package com.centauri.equations.util;

public class Matrix {

    private final int m;
    private final int n;
    private final double[][] data;

    public Matrix(int m, int n) {
	this.m = m;
	this.n = n;
	data = new double[m][n];
    }

    public Matrix(double[][] data) {
	m = data.length;
	n = data[0].length;
	this.data = new double[m][n];
	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		this.data[i][j] = data[i][j];
    }

    public static Matrix identity(int n) {
	Matrix identity = new Matrix(n, n);
	for (int i = 0; i < n; i++)
	    identity.data[i][i] = 1;
	return identity;
    }

    public Matrix transpose() {
	Matrix a = new Matrix(n, m);
	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		a.data[j][i] = this.data[i][j];
	return a;
    }

    public Matrix plus(Matrix b) {
	Matrix a = this;
	if (b.m != a.m || b.n != a.n)
	    throw new RuntimeException("Illegal matrix dimensions.");

	Matrix c = new Matrix(m, n);
	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		c.data[i][j] = a.data[i][j] + b.data[i][j];
	return c;
    }

    public Matrix minus(Matrix b) {
	Matrix a = this;
	if (b.m != a.m || b.n != a.n)
	    throw new RuntimeException("Illegal matrix dimensions.");

	Matrix c = new Matrix(m, n);
	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		c.data[i][j] = a.data[i][j] - b.data[i][j];
	return c;
    }

    public Matrix times(Matrix b) {
	Matrix a = this;
	if (a.n != b.m)
	    throw new RuntimeException("Illegal matrix dimensions.");

	Matrix c = new Matrix(a.m, b.n);
	for (int i = 0; i < c.m; i++)
	    for (int j = 0; j < c.n; j++)
		for (int k = 0; k < a.n; k++)
		    c.data[i][j] += (a.data[i][k] * b.data[k][j]);
	return c;
    }

    public boolean equals(Matrix b) {
	Matrix a = this;
	if (b.m != a.m || b.n != a.n)
	    throw new RuntimeException("Illegal matrix dimensions.");

	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		if (a.data[i][j] != b.data[i][j])
		    return false;
	return true;
    }

    public double det() {
	return det(data);
    }

    private double det(double[][] arr) {
	double result = 0;
	if (arr.length == 1) {
	    result = arr[0][0];
	    return result;
	}
	if (arr.length == 2) {
	    result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
	    return result;
	}
	for (int i = 0; i < arr[0].length; i++) {
	    double temp[][] = new double[arr.length - 1][arr[0].length - 1];

	    for (int j = 1; j < arr.length; j++) {
		for (int k = 0; k < arr[0].length; k++) {

		    if (k < i) {
			temp[j - 1][k] = arr[j][k];
		    } else if (k > i) {
			temp[j - 1][k - 1] = arr[j][k];
		    }
		}
	    }
	    result += arr[0][i] * Math.pow(-1, (int) i) * det(temp);
	}
	return result;
    }

    @Override
    public String toString() {
	StringBuilder string = new StringBuilder();
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++)
		string.append(data[i][j]);
	    string.append('\n');
	}
	return string.toString();
    }

}
