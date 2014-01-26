package it.d0ge01.botnet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Utils {
	public static char inputChar() {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = "0";
		
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			str = "";
		}
		
		return ( str.charAt(0));
	}
	
	public static int inputInt() {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = "0";
		
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			str = "0";
		}
		
		return ( Integer.valueOf(str));
	}
	
	public static double inputDouble() {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String str = "0";
		
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			str = "";
		}
		
		return ( Double.valueOf(str));
	}
	
	
}
