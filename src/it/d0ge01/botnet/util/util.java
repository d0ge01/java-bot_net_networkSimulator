package it.d0ge01.botnet.util;

public class Util {
	public static double getRandTime() {
		double x = -1 * log10(Math.random())*Math.sqrt(900.0);
		return(x);
	}
	
	public static double log10(double d) {
	    return ((double) Math.log(d)/Math.log(10.0));
	}
	
	
}
