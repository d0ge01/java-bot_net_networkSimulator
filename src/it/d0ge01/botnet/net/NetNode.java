package it.d0ge01.botnet.net;

import java.util.Vector;

import it.d0ge01.botnet.protocol.Packet;

public class NetNode {
	protected String hostname = "";
	
	private boolean alive = false;
	protected String address = "";
	private NetPool net;
	
	public NetNode(String hostname, String netAddr, NetPool net) {
		this.hostname = hostname;
		this.address = netAddr;
		this.net = net;
		
		this.alive = true;
	}
	
	private void send(String txt, String addressDest) {
		this.net.putPacket(new Packet(this.address, addressDest, txt));
	}
	
	private Vector read() {
		return (Vector) this.net.getPacket(this);
	}
	
	public void sendToNet(String dest, String txt) {
		this.send(txt, dest);
	}
	
	public void stampPacket() {
		Vector buff = this.read();
		for ( int i = 0 ; i < buff.size(); i++ ){
			System.out.println("===========" + i + "=============");
			System.out.println("Source: " + ((Packet) buff.get(i)).source());
			System.out.println("Dest :  " + ((Packet) buff.get(i)).dest());
			System.out.println("Txt: " + ((Packet) buff.get(i)).txt());
		}
	}
}
