package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;
import it.d0ge01.botnet.Malware;

public class NetPool extends Thread {
  private LinkedList<NetNode> field[];
	private String netAddr = "192.168.1.";

	public NetPool(String netAddr) {
    this.field = new LinkedList();
		this.netAddr = netAddr;
	}

  public void addHost(int size) {
    if ( Main.debug() )
      System.out.println("Resetting Net");
    for ( int i = 0 ; i < size ; i++ )
      field.add(new NetNode("hostname" + i, this.netAddr + i));

  }

	public NetNode host(int i) {
		return field[i];
	}

	public NetNode hostByIp(int n) {
		return ((NetNode) field.get(n));
	}

	public NetNode hostByHostname(String hostname) {
		for ( int i = 0 ; i < field.size(); i++ ) {
			if ( ((NetNode) field).hostname == hostname )
				return ((NetNode) field.get(i));
		}
		// if fail return null :D
		return null;
	}
	public void communication(NetNode x, NetNode y, String txt, NetPool netpool) {
		if ( netpool == null )
			netpool = this;
		String buff = txt;
		x.send(y, txt);
	}

	public void broadcast(NetNode from, String txt, NetPool net) {
		for ( int i = 0 ; i < sizeNet ; i++ )
			communication(from, field[i], txt, net);
	}

	public boolean IsThisNet(NetNode n) {
		if ( n.getNetAddr() == this.netAddr )
			return true;
		return false;
	}

	public void overrideHost(int i, NetNode x) {
		field.set(x, i);
	}
}
