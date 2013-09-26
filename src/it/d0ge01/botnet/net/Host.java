package it.d0ge01.botnet.net;

import it.d0ge01.botnet.*;
import it.d0ge01.botnet.util.*;

public class Host extends NetNode{
	// 0.0 - 1.0 , where 1 is like always infected, 0 never :/
	private static double infectionRate = 0.5;
	// Statement about infection
	private static boolean infected = false;
	
	public Host(String host, String address) {
		super(host, address);
		// TODO Auto-generated constructor stub
	}
	
	public static double infectionRate() {
		return infectionRate;
	}
	
	public static boolean infected() {
		return infected;
	}
	
	public static void tryInfection() {
		if ( Util.randomizeBoolean(infectionRate))
			infected = true;
	}
	
	public static void infectedRuntime() {
		Malware.main(null);
	}
	
}
