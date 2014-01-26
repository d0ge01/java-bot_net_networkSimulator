package it.d0ge01.botnet;

import it.d0ge01.botnet.net.NetNode;
import it.d0ge01.botnet.net.NetPool;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetPool lan1 = new NetPool();
		NetPool lan2 = new NetPool();
		NetNode x1 = new NetNode("x1", "192.168.1.4", lan1);
		NetNode x2 = new NetNode("x2", "192.168.1.5", lan1);
		NetNode x3 = new NetNode("x3", "192.168.1.6", lan1);
		NetNode x4 = new NetNode("x4", "192.168.1.7", lan1);
		NetNode x5 = new NetNode("x5", "192.168.1.8", lan1);
		NetNode x6 = new NetNode("x6", "192.168.1.9", lan1);
		NetNode y1 = new NetNode("y1", "192.168.2.1", lan2);
		NetNode y2 = new NetNode("y2", "192.168.2.2", lan2);
		NetNode y3 = new NetNode("y3", "192.168.2.3", lan2);
		
		x1.sendToNet("192.168.1.5", "ciao");
		x2.sendToNet("192.168.1.4", "ehila");
		y1.sendToNet("192.168.2.3", "SPAM");
		
		x1.stampPacket();
		x2.stampPacket();
		y3.stampPacket();
		
	}

}
