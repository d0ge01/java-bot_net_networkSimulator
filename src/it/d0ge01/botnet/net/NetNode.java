package it.d0ge01.botnet.net;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.d0ge01.botnet.Main;
import it.d0ge01.botnet.Malware;
import it.d0ge01.botnet.util.Util;

public class NetNode {

	protected String hostname;
	private String ip;
	private long pingTimeMsec;
	private Runnable t;
	private String netAddr;
	
	
	// 0.0 - 1.0 , where 1 is like always infected, 0 never :/
	private static double infectionRate = 0.5;
	// Statement about infection
	private static boolean infected = false;
	// alive?
	private boolean alive;
	private Malware infection;
	
	public NetNode(String host, String address ) {
		this.hostname = host;
		this.ip = address;
		alive = true;
		Pattern p = Pattern.compile("(\\d{3}\\.\\d{3}\\.\\d{3}\\.)\\d{3}");
		Matcher m = p.matcher(address);
		while(m.find()) {
			this.netAddr = m.group();
		}
	}
	
	public void infection(Malware virus ) {
		this.infection = virus;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public String getNetAddr() {
		return this.netAddr;
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
	
	public String getIp() {
		return ip;
	}
	
	private void trigger(String mex, NetNode man, NetPool field) {
		this.infection.examine(mex, field, man );
	}
	
	public void send(NetPool field, NetNode x, String txt) {
		if ( Main.debug())
			System.out.println("[DEBUG] " + this.hostname + " Sending to " + x.hostname + " txt: " + txt);
		field.communication(this, x, txt, field);
	}
	
	public void recv(NetPool field, String txt, NetNode from) {
		if ( this.alive ) {
			if ( Main.debug())
				System.out.println("[DEBUG] " + this.hostname + " recv data from " + from.hostname + " with txt: "  + txt );
			// this.trigger(txt, from, field);
		}
			
	}
	
	public void infectedRuntime(Runnable t) {
		this.t= t;
	}
	
	public void activate() {
		this.t.run();
	}
	
}
