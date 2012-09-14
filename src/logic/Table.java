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
	 * sets the current suit
	 * @param currentSuit
	 */
	public void setCurrentSuit(Suit currentSuit) {
		this.currentSuit = currentSuit;
	}

	/**
	 * Adds a card to the table
	 * @param player
	 * @param card
	 */
	public void addCard(Player player, Card card){
		// TODO
		cards.put(player, card);
	}
	
	/**
	 * @return number of players who played a card on the table
	 */
	public int getCardCount(){
		// TODO
		return cards.size();
	}
	
	/**
	 * @return an array of the cards on the table
	 */
	public Card[] getTableCards(){
		// TODO 
		return cards.values().toArray(new Card[4]);
	}
	
	/**
	 * removes all cards from the table
	 * @return an array of the cards on the table before removing
	 */
	public Card[] clearTable(){
		// TODO
		Card[] cards = getTableCards();
		this.cards.clear();
		return cards;
	}
	
	/**
	 * @return the a map of the cards on the table corresponding to each player
	 */
	public Map<Player, Card> getCardMap() {
		return cards;
	}
	
}
