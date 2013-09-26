package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class NetPool extends Thread {
	public int sizeNet = 100;
	private NetNode[] field = new NetNode[sizeNet];
	
	public NetPool(int size) {
		if ( size > 0 )
			this.sizeNet = size;
	}
	
	public void startNetPool() {
		if ( Main.debug())
			System.out.println("Resetting Net");
		
		for ( int i = 0 ; i < sizeNet ; i++ ) {
			if ( Main.debug())
				System.out.print("Creating node ( hostname" + i + ", 192.168.1." + i + " ) ....   "); 
			
			field[i] = new NetNode("hostname" + i , "192.168.1." + i);
			
			if ( Main.debug())
				System.out.println("DONE");
		}
		if ( Main.debug())
			System.out.print("Creating node ( botmaster , 192.168.1.53 ) ....   "); 
		
		field[53] = new BotmasterHost("", "192.168.1.53");
		
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
	public void communication(NetNode x, NetNode y, String txt ) {
		String buff = txt;
		y.recv(this, buff, x);
	}
	
}
