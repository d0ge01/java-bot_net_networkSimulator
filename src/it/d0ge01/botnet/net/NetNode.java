package it.d0ge01.botnet.net;

import it.d0ge01.botnet.malware.Malware;
import it.d0ge01.botnet.protocol.Packet;

import java.util.Vector;

public abstract class NetNode {
	protected String hostname = "";
	
	protected boolean alive = false;
	protected String address = "";
	protected NetPool net;
	
	protected Malware m;
	
	public NetNode(String hostname, String netAddr, NetPool net) {
		this.hostname = hostname;
		this.address = netAddr;
		this.net = net;
		
		this.alive = true;
	}
	
	public void infect(Malware m) {
		this.m = m;
	}
	
	public void run() {
		this.m.runtime();
	}
	
	public void send(String txt, String addressDest) {
		this.net.putPacket(new Packet(this.address, addressDest, txt));
	}
	
	public Vector read() {
		return (Vector) this.net.getPacket(this);
	}
	
	public void sendToNet(String dest, String txt) {
		this.send(txt, dest);
	}
	
	public abstract void stampPacket();
}
