package it.d0ge01.botnet.net;

public class NetNode {

	private String hostname;
	private String ip;
	
	private boolean alive;
	
	public NetNode(String host, String address, boolean al ) {
		hostname = host;
		ip = address;
		alive = al;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public String hostname() {
		return hostname;
	}
	
	public String ip() {
		return ip;
	}
}
