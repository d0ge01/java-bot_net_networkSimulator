package it.d0ge01.botnet;

import it.d0ge01.botnet.net.*;
import it.d0ge01.botnet.util.*;

public class Main {
	final static boolean DEBUG = true;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetPool field = new NetPool(100);
		
		field.startNetPool();
		
		NetNode h1 = field.host(40);
		NetNode h2 = field.host(55);
		
		h1.send(field, h2, "CIAO PIPPO");
	}
	
	public static boolean debug() {
		return DEBUG;
	}

}
