package logic;

public class Team {
	public Team(Player player1, Player player2){
		players = new Player[]{player1, player2};
	}
	
	private Player[] players;

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

}
