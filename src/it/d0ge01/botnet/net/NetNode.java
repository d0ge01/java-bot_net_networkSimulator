package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class NetNode {

	protected String hostname;
	private String ip;
	private long pingTimeMsec;
	
	
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
			System.out.println("Sending to " + x.hostname + " txt: " + txt);
		field.communication(this, x, txt);
	}
	
	public void recv(String txt, NetNode from) {
		if ( Main.debug())
			System.out.println("recv data from " + from.hostname + " with txt: "  + txt );
	}
}
