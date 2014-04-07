package org;

import org.util.HostList;


public class Main {

	public static final int PORT = 9;
	/**
	 * @author fabio.rohem
	 * @param args
	 */
	public static void main(String[] args) {
		
		HostList.addHost("AugustoPC", "60-67-20-F5-74-34", "172.31.24.255");
		
		WakeOnLan.sendToHost();
	}
}
