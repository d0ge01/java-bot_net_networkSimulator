package it.d0ge01.botnet;

import java.io.IOException;

import it.d0ge01.botnet.net.*;
import it.d0ge01.botnet.util.*;

public class Main {
	final static boolean DEBUG = true;
	static NetPool field, field2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		field = new NetPool(100,"192.168.1.");
		field2= new NetPool(100,"192.168.2.");
		char sc;
		
		Router router1 = new Router("router", "");

		field.startNetPool(53);
		field2.startNetPool(96);
		
		router1.setRouter(field, field2);
		field.overrideHost(99, router1);
		field2.overrideHost(99, router1);
		System.out.println("Console (c) or Apps(p) ?");
		sc = Util.inputChar();
		if ( sc == 'c' )
			console();
		
		if ( sc == 'p') {
			Malware[] virus = new Malware[10];
			NetNode infected[] = new NetNode[10];
			for ( int i = 0 ; i < 10 ; i++ ) {
				virus[i] = new Malware("botnet test", 0.4, field, field.host(i));
				infected[i] = field.host(i);
			}
			// allow virus control infected target
			for ( int i = 0 ; i < 10 ; i++ )
				infected[i].infectedRuntime(virus[i]);
		}
		
	}
	
	public static boolean debug() {
		return DEBUG;
	}
	
	private static void console() throws IOException {
		String buff = null;
		int v1 = 0;
		int v2 = 0;
		while ( true ) {
			System.out.println("botnet>");
			System.out.println("from?");
			v1 = Util.inputInt();
			System.out.println("to?");
			v2 = Util.inputInt();
			System.out.println("Txt?");
			buff = Util.inputString();
			
			field.host(v1).send(field, field.host(v2), buff);
			System.out.println("Done...");
			
		}
	}

}
