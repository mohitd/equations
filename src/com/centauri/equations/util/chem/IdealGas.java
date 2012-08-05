package com.centauri.equations.util.chem;

import com.centauri.equations.util.Complex;

public class IdealGas {
    private IdealGas() {
    }

    public static double GAS_CONSTANT = 0.08205746;

    public static Complex solveEquation(char solve, double pressure,
	    double volume, double moles, double temp) {
	Complex result = null;
	switch (solve) {
	case 'p':
	    result = new Complex((moles * GAS_CONSTANT * temp) / volume);
	    break;
	case 'v':
	    result = new Complex((moles * GAS_CONSTANT * temp) / pressure);
	    break;
	case 'n':
	    result = new Complex((pressure * volume) / (GAS_CONSTANT * temp));
	    break;
	case 't':
	    result = new Complex((pressure * volume) / (GAS_CONSTANT * moles));
	    break;
	default:
	    throw new IllegalArgumentException(solve
		    + " is not a valid character");
	}

	return result;
    }
}
