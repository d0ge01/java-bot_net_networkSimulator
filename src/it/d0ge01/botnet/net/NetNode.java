package it.d0ge01.botnet.net;

public class NetNode {

	protected String hostname;
	private String ip;
	private long pingTimeMsec;
	
	
	private boolean alive;
	
	public NetNode(String host, String address ) {
		this.hostname = host;
		this.ip = address;
		alive = true;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public long getPingTimeMsec() {
		return pingTimeMsec;
	}
	
	public void setPingTimeMsec(long ping) {
		this.pingTimeMsec = ping;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public String hostname() {
		return hostname;
	}
	
	public String ip() {
		return ip;
	}
}
