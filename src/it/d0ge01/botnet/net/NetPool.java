package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class NetPool extends Thread {
	private int sizeNet = 100;
	private NetNode[] field = new NetNode[sizeNet];
	
	public NetPool(int size) {
		if ( size > 0 )
			this.sizeNet = size;
	}
	
	public void startNetPool() {
		if ( Main.debug())
			System.out.println("Resetting Net");
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			if ( Main.debug())
				System.out.print("Creating node ( hostname" + i + ", 192.168.1." + i + " ) ....   "); 
			
			field[i] = new Host("hostname" + i , "192.168.1." + i);
			
			if ( Main.debug())
				System.out.println("DONE");
		}
	}
	
	public NetNode host(int i) {
		return field[i+1];
	}
	
	public void communication(NetNode x, NetNode y, String txt ) {
		String buff = txt;
		y.recv(txt, x);
	}
	
}
