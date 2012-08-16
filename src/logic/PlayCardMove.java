package logic;

public class PlayCardMove implements Move {
	private int rank;
	private int suit;
	private int playerNumber;
	
	public PlayCardMove(){
		this.rank = 0;
		this.suit = 0;
	}
	
	public PlayCardMove(int playerNumber, int rank, int suit){
		this.playerNumber = playerNumber;
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the suit
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}

	/**
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @param playerNumber the playerNumber to set
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	
}
