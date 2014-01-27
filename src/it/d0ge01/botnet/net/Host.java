package it.d0ge01.botnet.net;

import java.util.Vector;
import it.d0ge01.botnet.protocol.Packet;

public class Host extends NetNode implements Runnable{
	public Host(String hostname, String netAddr, NetPool net) {
		super(hostname, netAddr, net);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		m.runtime();
	}

	@Override
	public void stampPacket() {
		// TODO Auto-generated method stub
		Vector buff = this.read();
		if ( buff != null )
			for ( int i = 0 ; i < buff.size(); i++ ){
				if ( buff.get(i) != null ) {
					System.out.println("===========" + i + "=============");
					System.out.println("Source: " + ((Packet) buff.get(i)).source());
					System.out.println("Dest :  " + ((Packet) buff.get(i)).dest());
					System.out.println("Txt: " + ((Packet) buff.get(i)).txt());
				}
			}
	}
	
}
