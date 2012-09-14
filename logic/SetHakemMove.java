package logic;

public class SetHakemMove {
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
}
