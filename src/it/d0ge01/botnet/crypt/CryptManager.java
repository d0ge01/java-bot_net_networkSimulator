package it.d0ge01.botnet.crypt;

public class CryptManager {
	/*
	 * Gestore di cifratura nei messaggi della botnet :D
	 * 
	 * KEY = ID + LAST_ID
	 */

	public static String decryptMessage(int last_id, String buff) {
		String[] container = buff.split("|");
		/*
		 * 	int id = 0;
			id = 10;
			String cmd = container[1];
			String p1 = container[2];
			String p2 = container[3];
			String extraData = container[4]; 
		*/
		
		for ( String item : container ) {
			System.out.println("item = " + item);
		}
		// return "ID: " + last_id + id + "\n" + "CMD:" + cmd + "\np1 & p2 : " + p1 + " - " + p2 + "\nExtra: " + extraData;
		return "ciao";
	}
}
