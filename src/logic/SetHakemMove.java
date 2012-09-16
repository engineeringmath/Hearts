package logic;

public class SetHakemMove extends Move{
	private int playerNumber;

	public SetHakemMove(){
		playerNumber = 0;
	}
	 
	public SetHakemMove(int playerNumber){
		if (playerNumber >= 0 && playerNumber <=3) // i assumed the number is in range of 0 to 3.
		{
			this.playerNumber = playerNumber;
		}
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public byte[] serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
