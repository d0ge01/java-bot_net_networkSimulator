package it.d0ge01.botnet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public static int inputInt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = in.readLine();
		return (Integer.valueOf(str).intValue());
	}
	
	public static double inputDouble() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = in.readLine();
		return (Double.valueOf(str).doubleValue());
	}
	
	public static float inputFloat() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = in.readLine();
		return (Float.valueOf(str).floatValue());
	}
	
	public static char inputChar() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = in.readLine();
		return ((char) str.charAt(0));
	}
	
	
	public static String inputString() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = in.readLine();
		return (str);
	}
}
