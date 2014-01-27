package it.d0ge01.botnet;

import java.util.Vector;

import it.d0ge01.botnet.malware.MalwareProvider;
import it.d0ge01.botnet.net.Host;
import it.d0ge01.botnet.net.NetNode;
import it.d0ge01.botnet.net.NetPool;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetPool lan1 = new NetPool();
		NetPool lan2 = new NetPool();
		Vector<Host> vHost = new Vector<Host>();
		
		for ( int i = 0; i < 10 ; i++ )
			vHost.add(new Host("x1", "192.168.1." + i+4, lan1));
		
		for ( int i = 0 ; i < 10 ; i++ )
			vHost.get(i).infect(MalwareProvider.get(vHost.get(i)));
		
		for ( int i = 0 ; i < 10 ; i++ )
			vHost.get(i).run();
	}

}
