package logic;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Team {
	// Alireza: I'm not sure whether sets and packs should be put here or in table!
	// @hadi: make sure new methods work correctly. you new my programming!
	private Player[] players;
	private int roundsWon;
	private ArrayList<ArrayList<Card>> packsWon;
	public Team(Player player1, Player player2){
		players = new Player[]{player1, player2};
		roundsWon = 0;
		packsWon = new ArrayList<ArrayList<Card>>(7);
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	public void addSetsWon() {
		roundsWon++;
	}
	
	public int getRoundsWon() {
		return roundsWon;
	}
	
	public ArrayList<ArrayList<Card>> getPacksWon(){
		return packsWon;
	}
	
	public void addPacksWon(Card[] pack){
		packsWon.add(new ArrayList<Card>(Arrays.asList(pack)));
	}
}
