package org.model;

public class Computer {

	private String computerName;
	private String MACaddress;
	private String BroadcastIP;
	
	public Computer(){
	
	}
	
	public Computer(String computerName, String MACaddress, String BroadcastIP){
		this.setComputerName(computerName);
		this.setMACaddress(MACaddress);
		this.setBroadcastIP(BroadcastIP);
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getMACaddress() {
		return MACaddress;
	}
	public void setMACaddress(String MACaddress) {
		this.MACaddress = MACaddress;
	}
	public String getBroadcastIP() {
		return BroadcastIP;
	}
	public void setBroadcastIP(String broadcastIP) {
		BroadcastIP = broadcastIP;
	}
	
	
	
}
