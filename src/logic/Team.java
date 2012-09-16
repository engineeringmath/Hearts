package logic;
import java.util.ArrayList;
import java.util.Arrays;
	

	// Alireza: I'm not sure whether sets and packs should be put here or in table!
	// @hadi: make sure new methods work correctly. you know my programming!
	
	/* 
	   @alireza: addPacksWon is a complete bug :D. packsWon.lenght is always 7. 
	   I think using an ArrayList would be easier 
	   ArrayList<Card[]> packsWon;
	   This way you don't need to hold setsWon, you could just return packsWon.size() for setsWon.
	*/
	//@hadi: I changed the shit to 2D array list. I think you miss understood the words sets (now rounds) and packs.
	// 		 rounds is synonym of "seri". packs means how many "dast" you have won in THIS round.
//-----------------------

public class Team {

	private Player[] players;
	private int roundsWon;
	private ArrayList<ArrayList<Card>> packsWon;
	public Team(Player player1, Player player2){
		players = new Player[]{player1, player2};
		roundsWon = 0;
		packsWon = new ArrayList<ArrayList<Card>>();
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}
	
//	public void addRoundsWon() {
//		roundsWon++;
//	}
	
	public int getRoundsWon() {
		return roundsWon;
	}
	
	public ArrayList<ArrayList<Card>> getPacksWon(){
		return packsWon;
	}
	
	//	setting a new round by clearing team packs won.
	public void clearTeamPacks(){
		packsWon.clear();
	}
	
	// i added the if part.
	public void addPacksWon(Card[] pack){
		packsWon.add(new ArrayList<Card>(Arrays.asList(pack)));
		if(packsWon.size() == 7)
			roundsWon++;
	}
}
