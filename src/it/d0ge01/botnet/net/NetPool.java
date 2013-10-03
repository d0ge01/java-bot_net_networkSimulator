package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;
import it.d0ge01.botnet.Malware;

public class NetPool extends Thread {
	public int sizeNet = 255;
	private NetNode[] field = new NetNode[sizeNet];
	private String netAddr = "192.168.1.";
	
	public NetPool(int size, String netAddr) {
		if ( size > 0 )
			this.sizeNet = size;
		this.netAddr = netAddr;
	}
	
	public void startNetPool(int bm) {
		if ( Main.debug())
			System.out.println("Resetting Net");
		
		for ( int i = 0 ; i < sizeNet ; i++ ) {
			if ( Main.debug())
				System.out.print("Creating node ( hostname" + i + ", " + this.netAddr + i + " ) ....   "); 
			
			field[i] = new NetNode("hostname" + i , this.netAddr + i);
			
			if ( Main.debug())
				System.out.println("DONE");
		}
		
		for ( int i = 0 ; i < sizeNet ; i++ ) {
			if ( Main.debug())
				System.out.print("infection " + i + ", " + this.netAddr + i + "  ....   "); 
			
			field[i].infection(new Malware("LOLOL", 0.4, this, field[i]));
			
			if ( Main.debug())
				System.out.println("DONE");
		}
		if ( Main.debug())
			System.out.print("Creating node ( botmaster , " + this.netAddr + bm + ") ....   "); 
		
		
		field[bm] = new BotmasterHost("", "192.168.1." + bm);
		
		if ( Main.debug())
			System.out.println("DONE");
	}
	
	public NetNode host(int i) {
		return field[i];
	}
	
	public NetNode hostByIp(int last) {
		return field[last];
	}
	
	public NetNode hostByHostname(String hostname) {
		for ( int i = 0 ; i < sizeNet; i++ ) {
			if ( field[i].hostname == hostname )
				return field[i];
		}
		// if fail return null :D
		return null;
	}
	public void communication(NetNode x, NetNode y, String txt, NetPool netpool ) {
		if ( netpool == null )
			netpool = this;
		String buff = txt;
		y.recv(netpool, buff, x);
	}
	
	public void broadcast(NetNode from, String txt, NetPool net) {
		for ( int i = 0 ; i < sizeNet ; i++ )
			communication(from, field[i], txt, net);
	}
	
	public boolean checkNet(NetNode n) {
		if ( n.getNetAddr() == this.netAddr )
			return true;
		return false;
	}
	
	public void overrideHost(int i, NetNode x) {
		field[i] = x;
	}
}
