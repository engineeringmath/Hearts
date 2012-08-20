package network;

import game.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.Callable;

import logic.Move;
import network.message.MessageType;

/**
 * 
 * @author alireza
 * Set the return value to it's proper value:D
 */

public class Client implements Callable<String>{
	private Game game;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private InetAddress ip;
	
	/**
	 * get's the message from the server and decieds what to do next
	 * 
	 */
	public void getMessage(MessageType message){
		
	}
	
	/**
	 * sends the fucking move to server :D
	 */
	public void sendMove(){
		
	}
	
	
	/**
	 * get's the move of another player from the server and plays the move ( via the game instance )
	 */
	public void getServerMove(Move move){
		
	}
	
	public void closeConnection(){
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			System.err.println("Happened in client's close Connection");;
		}
	}

	@Override
	public String call() throws Exception {
		return null;
	}
}
