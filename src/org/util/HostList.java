package org.util;

import java.util.ArrayList;
import java.util.List;

import org.model.*;

public class HostList {
	 private static List<Computer> computerList = new ArrayList<Computer>();
	
 
	 
/**	public HostList(){
		if(computerList == null){
			computerList = new ArrayList<Computer>(); 
		}
	}
	**/
	
	 public static void addHost(String computerName, String MACaddress, String BroadcastIP){
		Computer computer = new Computer();
		
		computer.setBroadcastIP(BroadcastIP);
		computer.setComputerName(computerName);
		computer.setMACaddress(MACaddress);
		
		computerList.add(computer);
		
	}
	 
	 public static void removeHost(Computer computer){
		 computerList.remove(computer);
		 
	 }
	 
	 public static List<Computer> getHostList(){
	 
		 return computerList;
	 }
}
