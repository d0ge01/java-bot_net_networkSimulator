package it.d0ge01.botnet.net;

public class Router {
	
	private NetPool netA;
	private NetPool netB;
	
	public Router(NetPool x, NetPool y) {
		/*
		 *  For now, work useless this... i'm working to do a low level net simulation 
		 */
		this.netA = x;
		this.netB = y;
	}
	
	public void sendBC(NetNode from, String txt) {
		if ( this.netA.checkNet(from) )
			this.netB.broadcast(this.netA, txt);
		else
			this.netA.broadcast(this.netB, txt);
	}
}
