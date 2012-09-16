package network;

import game.Game;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import logic.Move;
import network.message.MessageType;


/**
 * 
 * @author alireza
 * Set the return value to it's proper value:D
 */

public class Client{
	
	private MulticastSocket ms;
	private InetAddress group;
	private Game game;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private InetAddress ip;
	private boolean isConnected;
	
	public Client(Game game) throws IOException {
		this.game = game;
		ms = new MulticastSocket(Statics.MULTICAST_SOCKET_PORT);
		group = InetAddress.getByName(Statics.BROADCAST_GROUP_IP);
		
		// This might be subject to Displacement due to implementation specifications of Game's Graphics
		new Thread(){
			
			public void run() {
				while(!isConnected){
				byte [] buf = new byte [256];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				try {ms.receive(dp);}
				catch (IOException e) {e.printStackTrace();}
				Map<String, String> serverInfo = StringSerializer.deserialize(dp.getData());
				Client.this.game.localServers(serverInfo);
				}
			}; 
		};
	}
	
	public void connect(Map<String, String> serverInfo){
		String address = serverInfo.get("address");
		try {
			socket = new Socket(address, Statics.SERVER_SOCKET_PORT);
			input  = socket.getInputStream();
			output = socket.getOutputStream();
		}catch (IOException e) {System.err.println("Client.Init");}
		
		//
		while(!socket.isClosed()){
			try {
//				Object recieved = input.readObject();	
			}catch (Exception e) {System.err.println("Client.Recieve");}
			
		}
		
	}
	
	
	/**
	 * gets the message from the server and decides what to do next
	 * 
	 */
	private void getMessage(MessageType message){
		
	}
	
	/**
	 * sends the fucking move to server :D
	 */
	public void sendMove(Move move){
//		try {
//			output.write(move);
//		catch (IOException e) {System.err.println("sendMove/ Client.java");}
	}
	
	
	/**
	 * gets the move of another player from the server and plays the move ( via the game instance )
	 */
	private void getServerMove(Move move){
		game.playMove(move);
	}
	
	private void closeConnection(){
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			System.err.println("Happened in client's close Connection");;
		}
	}
	
	public boolean isConnected(){
		return this.isConnected;
	}
}
