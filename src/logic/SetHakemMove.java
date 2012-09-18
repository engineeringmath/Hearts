package logic;

import java.nio.ByteBuffer;

public class SetHakemMove extends Move{
	private int playerNumber;

	public SetHakemMove(){
		playerNumber = 0;
	}
	 
	public SetHakemMove(int playerNumber){
		this.playerNumber = playerNumber;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}


	public byte getMoveId(){
		return 4;
	}

	public byte[] toBytes(){
		return new byte[]{(byte)this.playerNumber};
 	}

	public static Move fromBytes(byte[] bytes){
		ByteBuffer buff = ByteBuffer.wrap(bytes);
		byte playerNumber = buff.get();
		SetHakemMove move = new SetHakemMove(playerNumber);
		return move;
	}
}
