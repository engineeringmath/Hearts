package logic;

public class Team {
	// Alireza: I'm not sure whether sets and packs should be put here or in table!
	// @hadi: make sure new methods work correctly. you new my programming!
	private Player[] players;
	private int setsWon;
	private Card[][] packsWon;
	public Team(Player player1, Player player2){
		players = new Player[]{player1, player2};
		setsWon = 0;
		packsWon = new Card[7][4];
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	public void addSetsWon() {
		setsWon++;
	}
	
	public int getSetsWon() {
		return setsWon;
	}
	
	public void addPacksWon(Card[] pack){
		packsWon[packsWon.length] = pack;
	}
}
