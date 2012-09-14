package logic;


public class GameInfo {
	private String info;
	
	
	
	/**
	 * Returns all of game's details in specific format shown as below;
	 * 
	 * turn of play
	 * hokm
	 * hakam
	 * team1 score, team2 score
	 * number and cards of packs won by team1
	 * number and cards of packs won by team2
	 * cards on the table (a genius novel by agatha cristy!)
	 * current suit
	 * all player's hands in separate rows
	 */
	public GameInfo(){
		info = "Turn: " + GameLogic.getInstance().getTurn() + "\nHokm: " 
						+ GameLogic.getInstance().getHokm().getNumber() + "\nHakem: " 
						+ GameLogic.getInstance().getHakem().getPlayerNumber() + "\nTeam1's score: "
						+ GameLogic.getInstance().getTeams()[0].getRoundsWon() + " and team2's score: " 
						+ GameLogic.getInstance().getTeams()[1].getRoundsWon() + "\nTeam1 has won " 
						+ GameLogic.getInstance().getTeams()[0].getPacksWon().size() + " packs of: "
						+ GameLogic.getInstance().getTeams()[0].getPacksWon().toString() + "\nTeam2 has won "
						+ GameLogic.getInstance().getTeams()[1].getPacksWon().size() + " packs of: "
						+ GameLogic.getInstance().getTeams()[1].getPacksWon().toString() + "\nTable: "
						+ GameLogic.getInstance().getTable().getTableCards().toString() + "\nCurrent suit: "
						+ GameLogic.getInstance().getTable().getCurrentSuit().toString() + "\nPlayer1's hand:"
						+ GameLogic.getInstance().getTeams()[0].getPlayers()[0].getCards().toString() + "\nPlayer2's hand:"
						+ GameLogic.getInstance().getTeams()[1].getPlayers()[0].getCards().toString() + "\nPlayer3's hand:"
						+ GameLogic.getInstance().getTeams()[0].getPlayers()[1].getCards().toString() + "\nPlayer4's hand:"
						+ GameLogic.getInstance().getTeams()[1].getPlayers()[1].getCards().toString();
	}
	public String requestInfo(){
		return info;
	}
}
