package logic;

public abstract class Move {
	abstract public byte[] serialize();
	
	public static Move deserialize(byte[] bytes){
		return null; 
	}
}
