package it.d0ge01.botnet.util;

public class Util {
	public static double getRandTime() {
		double x = -1 * log10(Math.random())*Math.sqrt(900.0);
		return(x);
	}
	
	public static double log10(double d) {
	    return ((double) Math.log(d)/Math.log(10.0));
	}
	
	public static boolean randomizeBoolean(double ir) {
		if ( ((int) (Math.random() * 10.0 )) % 2 == 0 )
			if ( Math.random() < ir)
				return true;
		else
			return false;
		
		return false;
	}
}
