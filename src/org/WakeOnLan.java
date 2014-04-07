package org;

import java.util.List;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.model.*;
import org.util.HostList;

public class WakeOnLan {

	public static void send(String[] args){
		if (args.length != 3) {
			System.out.println("Uso: java WakeOnLan <broadcast-ip> <mac-address> <porta>");
			System.out.println("Exemplo: java WakeOnLan 192.168.0.255 00:0D:61:08:22:4A 9");
			System.out.println("Examplo: java WakeOnLan 192.168.0.255 00-0D-61-08-22-4A 9");
			System.exit(1);
		}

		String ipStr = args[0];
		String macStr = args[1];
		int port = Integer.parseInt(args[2]);

		try {
			byte[] macBytes = getMacBytes(macStr);
			byte[] bytes = new byte[6 + 16 * macBytes.length];

			//O trailer contém 6 * constante 0xff

			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) 0xff;
			}

			//Corpo do pacote contém 16 * o endereco MAC

			for (int i = 6; i < bytes.length; i += macBytes.length) {
				System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
			}

			InetAddress address = InetAddress.getByName(ipStr);
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address,port);
			
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			socket.close();

			System.out.println("Pacote Wake-on-LAN enviado com sucesso.");
		}
		catch (Exception e) {
			System.out.println("Falha no envio do pacote Wake-on-LAN: + e");
			System.exit(1);
		}

	}

	private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
		byte[] bytes = new byte[6];
		String[] hex = macStr.split("(\\:|\\-)");
		if (hex.length != 6) {
			throw new IllegalArgumentException("Endereco MAC invalido.");
		}
		try {
			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) Integer.parseInt(hex[i], 16);
			}
		}
		catch (NumberFormatException e) {
			throw new IllegalArgumentException("Digito hex invalido no endereco MAC. ");
		}
		return bytes;
	}
	
	public static void sendToHost(){
		
		String[] args = new String[3];
		List<Computer> computerList = HostList.getHostList();
		
		
		
		for(int i=0;i<computerList.size();i++){
			args[0] = computerList.get(i).getBroadcastIP();
			args[1] = computerList.get(i).getMACaddress();
			args[2] = "9"; //porta padrão de uso
			
			send(args);
		}
	}
		
		
		

	

	
}

