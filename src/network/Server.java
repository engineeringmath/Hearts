package network;

import game.Game;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import logic.Move;
import network.message.MessageType;

/**
 * 
 * @author alireza
 * Set the return value of method call to sth right :D
 */
public class Server implements Callable<String>{
	private Socket socket ;
	private ServerSocket server;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private int numberOfConnections;
	private ArrayList<Socket> connections;
	private Game game;
	
	public Server(Game game){
		this.game = game;
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

	@Override
	public String call() throws Exception {
		return null;
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
