/**
 * Author: Abrorjon Asralov
 * Class: CSC 210 Fall 2023
 * Purpose: This is a program that actually converts measurements as user wants to get
 * Measurements converted. It has two methods that converts the measurements from F to C
 * and from C to F
 */

package model;

public class TemperatureConverter {
	public static double FtoC(double f) {
		double c = ((f - 32) * 5) / 9;
		double resultingC = Math.round(c * 10.0) / 10.0;
		return resultingC;
	}

	public static double CtoF(double c) {
		double f = (c * 1.8) + 32;
		return Math.round(f * 10.0) / 10.0;
	}
}
