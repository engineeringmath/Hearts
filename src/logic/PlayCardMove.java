package logic;

import java.nio.ByteBuffer;

public class PlayCardMove extends Move {
	private Rank rank;
	private Suit suit;
	private int playerNumber;
	
	public PlayCardMove(int playerNumber, Rank rank, Suit suit){
		this.playerNumber = playerNumber;
		this.rank = rank;
		this.suit = suit;
	}

	protected byte[] toBytes() {
		return new byte[]{
			(byte)playerNumber, 
			(byte)rank.getNumber(),
			(byte)suit.getNumber()
		};
	}
	
	public static Move fromBytes(byte[] bytes){
		ByteBuffer buff = ByteBuffer.wrap(bytes);
		int playerNumber = buff.get();
		Rank rank = Rank.fromNumber(buff.get());
		Suit suit = Suit.fromNumber(buff.get());
		return new PlayCardMove(playerNumber, rank, suit);
	}
	
	
	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit) {
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
