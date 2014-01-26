package it.d0ge01.botnet.net;

import it.d0ge01.botnet.protocol.Packet;

import java.util.LinkedList;
import java.util.Vector;


public class NetPool {
	private LinkedList<Packet> field;
	
	public NetPool() {
		this.field = new LinkedList<Packet>();
	}
	
	
	public void putPacket(Packet p) {
		this.field.add(p);
	}
	
	public Vector getPacket(NetNode x) {
		Vector v = new Vector();
		for ( int i = 0 ; i < this.field.size() ; i++ ) {
			// NOT OPTIMIZED SEARCH, TODO MORE OPTIMIZED GET
			if ( x.address.equals(this.field.get(i).dest())) {
				v.add(this.field.remove(i));
			}
		}
		if ( v.size() > 0 )
			return v;
		else
			return null;
	}
}
