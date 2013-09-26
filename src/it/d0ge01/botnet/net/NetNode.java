package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;
import it.d0ge01.botnet.util.Util;

public class NetNode {

	protected String hostname;
	private String ip;
	private long pingTimeMsec;
	private Runnable t;
	
	// 0.0 - 1.0 , where 1 is like always infected, 0 never :/
	private static double infectionRate = 0.5;
	// Statement about infection
	private static boolean infected = false;
	// alive?
	private boolean alive;

	
	public NetNode(String host, String address ) {
		this.hostname = host;
		this.ip = address;
		alive = true;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public long getPingTimeMsec() {
		return pingTimeMsec;
	}
	
	public void setPingTimeMsec(long ping) {
		this.pingTimeMsec = ping;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public String hostname() {
		return hostname;
	}
	
	public String ip() {
		return ip;
	}
	
	public void send(NetPool field, NetNode x, String txt) {
		if ( Main.debug())
			System.out.println("[DEBUG] " + this.hostname + " Sending to " + x.hostname + " txt: " + txt);
		field.communication(this, x, txt);
	}
	
	public void recv(NetPool field, String txt, NetNode from) {
		if ( Main.debug())
			System.out.println("[DEBUG] " + this.hostname + " recv data from " + from.hostname + " with txt: "  + txt );
			
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
	
	public void infectedRuntime(Runnable t) {
		this.t= t;
	}
	
	public void activate() {
		this.t.run();
	}
	
}
