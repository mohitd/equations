package com.centauri.equations.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;

// TODO: Add support for negative square roots. Integrate Complex numbers?
public class RadicalNumber {

    private double coeff;

    private int radicand;

    public RadicalNumber(int radicand) {
        this.coeff = 1;
        this.radicand = radicand;
    }

    public RadicalNumber(double coeff, int radicand) {
        this.coeff = coeff;
        this.radicand = radicand;
    }

    public int toInt() {
        return (int) (coeff * Math.sqrt(radicand));
    }

    public double toDouble() {
        return (coeff * Math.sqrt(radicand));
    }

    public RadicalNumber add(RadicalNumber number) {
        if (this.radicand == number.radicand) {
            return new RadicalNumber(this.coeff + number.coeff, radicand);
        }
        return null;
    }

    public RadicalNumber subtract(RadicalNumber number) {
        if (this.radicand == number.radicand) {
            return new RadicalNumber(this.coeff - number.coeff, radicand);
        }
        return null;
    }

    public RadicalNumber multiply(RadicalNumber number) {
        return new RadicalNumber(this.coeff * number.coeff, radicand
                * number.radicand).simplify();
    }

    public RadicalNumber divide(RadicalNumber number) {
        return new RadicalNumber(this.coeff / number.coeff, radicand
                / number.radicand).simplify();
    }

    public double coefficient() {
        return coeff;
    }

    public int radicand() {
        return radicand;
    }

    // TODO: Optimize radical simplification. Initialization of unnecessary
    // List<>s and Map<>s
    @SuppressLint("UseSparseArrays")
    public RadicalNumber simplify() {
        int n = radicand;
        this.radicand = 1;
        List<Integer> factors = new ArrayList<Integer>();
        List<Integer> duplicates = new ArrayList<Integer>();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        for (Integer value : factors) {
            if (counts.containsKey(value)) {
                counts.put(value, counts.get(value) + 1);
            } else {
                counts.put(value, 1);
            }
        }

        for (Integer value : counts.keySet()) {
            Integer valueCount = counts.get(value);
            for (int i = 0; i < (valueCount / 2); i++) {
                duplicates.add(value);
                factors.remove(value);
                factors.remove(value);
            }
        }

        for (Integer value : duplicates) {
            this.coeff *= value;
        }

        for (Integer value : factors) {
            this.radicand *= value;
        }

        return this;
    }

    @Override
    public String toString() {
        if (coeff == 1)
            return "&radic;" + radicand;
        else if (radicand == 1)
            return String.valueOf(coeff);
        else if (coeff == 0 || radicand == 0)
            return String.valueOf(0.0);
        else
            return coeff + "&radic;" + radicand;
    }

}
