package network;

import game.Game;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import logic.Move;
import network.message.MessageType;


/**
 * @author alireza
 * 
 */
public class Server{
	/** private attributes */
	private Socket socket ;
	private DatagramSocket broadcastSocket;
	private ServerSocket server;
	private HashMap<Socket, OutputStream>outputs;
	private HashMap<Socket, InputStream> inputs;
	private ArrayList<Socket> connections;
	private int numberOfConnections;
	private InetAddress group;
	private Game game;
	
	/** methods */
	public Server(Game game) throws IOException {
		this.game 	 = game;
		this.outputs = new HashMap<Socket, OutputStream>();
		this.inputs  = new HashMap<Socket, InputStream>();
		this.server  = new ServerSocket(Statics.SERVER_SOCKET_PORT);
		
		try {this.broadcastSocket = new DatagramSocket(Statics.DATAGRAM_SOCKET_PORT);} 
		catch (SocketException e) { System.err.println("Initiating DatagramSocket /Server.java"); }
		
		new Thread(){
			
			public void run() {
				while(!Server.this.game.isComplete()){
					HashMap<String, String> content = new HashMap<String, String>();
					content.put("name", Server.this.game.getPlayerName());
					content.put("address", Server.this.server.getInetAddress().toString());
					content.put("playersCount", Integer.toString(Server.this.game.getPlayersCout()));
					
					try {Server.this.group = InetAddress.getByName(Statics.BROADCAST_GROUP_IP);} 
					catch (UnknownHostException e1){System.err.println("GROUP / Server.java");}
					
					byte [] broadcastMsg = StringSerializer.serialize(content);
					
					try {broadcastSocket.send(new DatagramPacket(broadcastMsg, broadcastMsg.length, Server.this.group, Statics.MULTICAST_SOCKET_PORT));}
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
		while(!game.isComplete()){
			try {
				Socket connection = server.accept();
				connections.add(connection);
			} 
			catch (IOException e) {System.err.println("Server.accept StartServer/Server.java");}
		}
		
		for(Socket connection : connections){
			new Thread(){
				Socket connection;
				public Thread setConnection(Socket connection){
					this.connection = connection;
					return this;
				}
				public void run(){
					try {
						Server.this.outputs.put(connection, connection.getOutputStream());
						Server.this.inputs.put(connection, connection.getInputStream());
						ProcessConnection pc = new ProcessConnection(connection, Server.this.connections);
					}
					catch (IOException e) {System.err.println("startServer");}
				}
			}.setConnection(connection).start();
		}
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
	
	public int getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}
}
