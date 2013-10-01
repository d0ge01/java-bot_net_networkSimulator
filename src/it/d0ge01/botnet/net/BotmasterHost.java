package it.d0ge01.botnet.net;

import it.d0ge01.botnet.Main;

public class BotmasterHost extends NetNode{

	public BotmasterHost(String host, String address) {
		super("botmaster", address);
		// TODO Auto-generated constructor stub
	}
	
	public void botmasterRuntime(NetPool x, String txt, NetNode from) {
		// public void send(NetPool field, NetNode x, String txt) {
		if ( txt == "OOHAI MASTER")
			send(x,from , "welcome my friend");
		if ( txt == "ready")
			send(x,from , "attack 85");
	}
	
	public void recv(NetPool x, String txt, NetNode from) {
		if ( Main.debug())
			System.out.println("[DEBUG] " + this.hostname + " recv data from " + from.hostname + " with txt: "  + txt );
		botmasterRuntime(x, txt, from);
	}
	
	public void infectedRuntime(Runnable t) {
		// nothing LOL
	}
}
