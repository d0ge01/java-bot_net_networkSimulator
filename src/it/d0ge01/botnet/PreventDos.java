package it.d0ge01.botnet;


import it.d0ge01.botnet.util.*;
import it.d0ge01.botnet.crypt.*;;

class PreventDos {
	
	private static double slotTime = 0;
	
	public static void main(String[] Args) throws InterruptedException {
		slotTime = util.getRandTime();
		System.out.println("New connection, wait " + Math.round(slotTime*1000) + " seconds ....");
		Thread.sleep(Math.round(slotTime*1000));
		System.out.println(CryptManager.decryptMessage(10, "101|HELP|Piuno|pidue|extradatajfkafjslkjfkfsjfklj"));
	}
}