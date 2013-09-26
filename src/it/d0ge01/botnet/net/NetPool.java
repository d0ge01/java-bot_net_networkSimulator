package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class NetPool {
	NetNode[] field = new NetNode[100];
	
	public void startNetPool() {
		if ( Main.debug())
			System.out.println("Resetting Net");
		
		for ( int i = 0 ; i < 100 ; i++ )
			field[i] = new Host("hostname" + i , "192.168.1" + i);
	}
}
