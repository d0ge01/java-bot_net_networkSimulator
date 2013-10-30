package it.d0ge01.botnet;

import java.io.IOException;
import java.util.LinkedList;

import it.d0ge01.botnet.net.*;
import it.d0ge01.botnet.util.*;

public class Main {
	final static boolean DEBUG = true;
	static LinkedList<NetPool> internet;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method 
		char sc;
		internet = new LinkedList();
		Router router1 = new Router("router");
		
		internet.add(new NetPool(100,"192.168.1."));
		internet.add(new NetPool(100,"192.168.2."));
		internet.get(0).startNetPool(53);
		internet.get(1).startNetPool(96);
		
		
		
		router1.setRouter(internet.get(0), internet.get(1));
	
		System.out.println("Console (c) or Apps(p) ?");
		sc = Util.inputChar();
		if ( sc == 'c' )
			console();
		
		if ( sc == 'p') {
			Malware[] virus = new Malware[10];
			NetNode infected[] = new NetNode[10];
			for ( int i = 0 ; i < 10 ; i++ ) {
				internet.get(0).host(i).infectedRuntime(new Malware("botnet test", 0.4, internet.get(0), internet.get(0).host(i)));
			}
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
			internet.get(0).host(v1).send(internet.get(0), internet.get(0).host(v2), buff);
			System.out.println("Done...");
			
		}
	}

}
