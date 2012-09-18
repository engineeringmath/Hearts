package logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

// Note: All moves must have a static fromBytes method!!

public abstract class Move {
	final static String PREFIX = "move";
	
	private static Class[] moveList = {
		PlayCardMove.class,
		SelectHokmMove.class,
		SetHakemMove.class,
		DealCardsMove.class,
	}; 
	
	public static byte getMoveId(Class c){
		for (byte i = 0; i < moveList.length; i++)
			if(moveList[i].equals(c))
				return i;
		return -1;
	}
	
	/**
	 * Serialized the move into an array of bytes
	 * @return an array containing the serialized Move
	 */
	public byte[] serialize(){
		byte[] prefix = PREFIX.getBytes();
		byte id = Move.getMoveId(this.getClass());
		if(id == -1)
			return null;
		byte[] b = this.toBytes();
		ByteBuffer buf = ByteBuffer.allocate(prefix.length + 1 + b.length); 
		buf.put(prefix);
		buf.put(id);
		buf.put(b);
		return buf.array();
	}

	/**
	 * Deserializes a Move which was serialized by the serialize method
	 * @param bytes
	 * @return
	 */
	public static Move deserialize(byte[] bytes){
 		ByteBuffer buff = ByteBuffer.wrap(bytes);
	
 		byte[] b = new byte[PREFIX.length()];
		buff.get(b, 0, b.length);
		String pref = new String(b);
		if(!pref.equals(PREFIX))
			return null;
		
		byte moveId = buff.get();
		
		Class clz = moveList[moveId];
		Move move = null;
		try {
			Method mth = clz.getDeclaredMethod("fromBytes", byte.class);
			move = (Move)mth.invoke(null, buff.slice().array());
		} catch (NoSuchMethodException | SecurityException | 
			  	 IllegalAccessException | IllegalArgumentException | 
				 InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
		
		return move;
	}

	protected abstract byte[] toBytes();

	public int getHash(){
		return 0;
	}

	/*
	 	move id length -----------




	 */
}
