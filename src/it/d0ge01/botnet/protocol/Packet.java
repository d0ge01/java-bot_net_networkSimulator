package it.d0ge01.botnet.protocol;

public class Packet {
	private String source;
	private String dest;
	private String text;
	
	
	public String dest() {
		return this.dest;
	}
	
	public String source() {
		return this.source;
	}
	
	public String txt() {
		return this.text;
	}
	public Packet(String source, String dest, String text) {
		this.source = source;
		this.dest = dest;
		this.text = text;
	}
}
