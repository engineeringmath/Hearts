package logic;

import java.util.Map;

public class Table {
	private Suit currentSuit;
	private Map<Player, Card> cards;
	
	
	/**
	 * @return the current suit on the table, return null if no card exists on the table
	 */
	public Suit getCurrentSuit(){
		return currentSuit;
	}
	
	/**
	 * Adds a card to the table
	 * @param player
	 * @param card
	 */
	public void addCard(Player player, Card card){
		// TODO
	}
	
	/**
	 * @return number of players who played a card on the table
	 */
	public int getCardCount(){
		// TODO
		return 0;
	}
	
	/**
	 * @return an array of the cards on the table
	 */
	public Card[] getTableCards(){
		// TODO Alireza
		return null;
	}
	
	/**
	 * removes all cards from the table
	 * @return an array of the cards on the table before removing
	 */
	public Card[] clearTable(){
		Card[] cards = getTableCards();
		
		// TODO remove
		
		return cards;
	}
	
	/**
	 * @return the a map of the cards on the table corresponding to each player
	 */
	public Map<Player, Card> getCardMap() {
		return cards;
	}
	
}
