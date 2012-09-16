package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import logic.Move;

public class ProcessConnection {
	
	ArrayList<Socket> connections;
	Socket connection;
	InputStream input;
	OutputStream output;
	
	public ProcessConnection(Socket connection, ArrayList<Socket> connections){
		this.connection = connection;
		this.connections= connections;
		this.connections.remove(this.connection);
		
		try {
			input = this.connection.getInputStream();
			output= this.connection.getOutputStream();
		}
		catch (IOException e) {System.err.println("Constructor /ProeccessConnection.java");}
		handleConnection();
	}

	private void handleConnection() {
		while(!connection.isClosed()){
			try {
				compileMsg(input.read());
			}
			catch (IOException e) {System.err.println("handleConnection / ProcessConnection.java");}
		}
	}
	
	private void compileMsg(Object obj){
		
	}
	
	private void writeToAll(Move move){
		for (Socket sock: connections)
			try {
				new ObjectOutputStream(sock.getOutputStream()).writeObject(move);
			}
		catch (IOException e) {System.err.println("writeToAll / ProcessConnection.java");}
	}
}
