package network;

import game.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import network.message.MessageType;


/**
 * 
 * @author alireza
 * Set the return value of method call to sth right :D
 */
public class Server{
	/** private attributes */
	private Socket socket ;
	private DatagramSocket broadcastSocket;
	private ServerSocket server;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private int numberOfConnections;
	private ArrayList<Socket> connections;
	private InetAddress group;
	private Game game;
	
	/** methods */
	public Server(Game game) throws IOException{
		this.game = game;
		this.server = new ServerSocket(Statics.serverSocketPort);
		
		try {this.broadcastSocket = new DatagramSocket(Statics.datagramSocketPort);} 
		catch (SocketException e) { System.err.println("Initiating DatagramSocket /Server.java"); }
		
		new Thread(){
			
			public void run() {
				while(!Server.this.game.isComplete()){
					HashMap<String, String> content = new HashMap<String, String>();
					content.put("name", Server.this.game.getPlayerName());
					content.put("address", Server.this.server.getInetAddress().toString());
					content.put("playersCount", Integer.toString(Server.this.game.getPlayersCout()));
					
					try {Server.this.group = InetAddress.getByName("231.0.0.1");} 
					catch (UnknownHostException e1){System.err.println("GROUP / Server.java");}
					
					byte [] broadcastMsg = StringSerializer.serialize(content);
					
					try {broadcastSocket.send(new DatagramPacket(broadcastMsg, broadcastMsg.length, Server.this.group, Statics.multicastSocketPort));}
					catch (IOException e1) {System.err.println("Sending broadcastMsg /Server.java");}
					
					try {Thread.sleep(500);}
					catch (InterruptedException e) {System.err.println("SLEEP/Server.java");}
				}
				};
			}.start();
			this.startServer();
	}
	
	/**
	 * sends a private message to one client
	 * @param message: message :D
	 */
	private void sendMessage(MessageType message){
		
	}
	
	/**
	 * Sends the messages , instantiates the proper object, to all clients
	 * @param message : message :D 
	 */
	private void sendMessageToAllClients(MessageType message){
		
	}

	public void startServer(){
		new Thread(){

			public void run() {
				try {connections.add(server.accept());} 
				catch (IOException e) {System.err.println("Server.accept StartServer/Server.java");}
			}
			
		};
	}
	
	/**
	 * @param move : the move client has to make
	 * styled specifically for move messages
	 */
	private void sendMoveToClient(Move move){
		
	}
	
	/**
	 * Gets the move of a client and and tells other players
	 */
	private void getClientMove(Move move){
		
	}
	/**
	 * waits for 90s for the disconnected client to be connected back, otherwise terminates the game 
	 * sends the AbortMessage message to all other clients and they terminate their code.
	 * sendMessage(DisconnectMessage) to all players
	 * reconnection stuff , ( check for user with the same IP of the one being dc )
	 * return , or send AbortMessage to clients to end the game in order the connection was lost
	 */
	private void checkConnection(){
		
	}
	
	public void sendCompressedGameState(){
		
	}
	
	/**
	 * when a message ( Abort , Disconnect or whatever ) ends the game , this method is called to close everything :)
	 */
	private void closeConnections(){
		
	}
	
	public ObjectOutputStream getOutput() {
		return output;
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public int getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}
}
