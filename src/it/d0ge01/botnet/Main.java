package it.d0ge01.botnet;

import java.io.IOException;

import it.d0ge01.botnet.net.*;
import it.d0ge01.botnet.util.*;
import it.d0ge01.botnet.*;

public class Main {
	final static boolean DEBUG = true;
	static NetPool field;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		field = new NetPool(100);
		char sc;
		
		field.startNetPool();
		System.out.println("Console (c) or Apps(p) ?");
		sc = Util.inputChar();
		if ( sc == 'c' )
			console();
		
		if ( sc == 'p') {
			Malware virus = new Malware("botnet test", 0.4, field, field.host(0), field.host(4));
			NetNode infected = field.host(0);
			// allow virus control infected target
			infected.infectedRuntime(virus);
		}
		
	}
	
	public static boolean debug() {
		return DEBUG;
	}
	
	private static void console() throws IOException {
		String buff = null;
		// String sc = null;
		int v1 = 0;
		int v2 = 0;
		while ( true ) {
			System.out.println("botnet>");
			System.out.println("Starting communication with?");
			v1 = Util.inputInt();
			System.out.println("From?");
			v2 = Util.inputInt();
			System.out.println("Txt?");
			buff = Util.inputString();
			
			field.host(v1).send(field, field.host(v2), buff);
			System.out.println("Done...");
			
		}
	}

}
