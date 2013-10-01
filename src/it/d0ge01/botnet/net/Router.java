package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class Router extends NetNode {
	private NetPool netA;
	private NetPool netB;
	
	public Router(String host, String address) {
		super(host, address);
		// TODO Auto-generated constructor stub
	}


	public void setRouter(NetPool x, NetPool y) {
		/*
		 *  For now, work useless this... i'm working to do a low level net simulation 
		 */
		this.netA = x;
		this.netB = y;
	} 
	
	public void sendBC(NetNode from, String txt) {
		if ( this.netA.checkNet(from) )
			this.netB.broadcast(this.netA.hostByHostname(from.hostname), txt, netA);
		else
			this.netA.broadcast(this.netB.hostByHostname(from.hostname), txt, netB);
	}
	
	public void recv(NetPool field, String txt, NetNode from, NetPool fix) {
		if ( Main.debug())
			System.out.println("[DEBUG] " + this.hostname + " recv BC data from " + from.hostname + " with txt: "  + txt );
		this.sendBC(from, txt);
			
	}
}
