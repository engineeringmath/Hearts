package logic;

import java.util.ArrayList;

import logic.exception.CardNotFoundException;

public class Player {

	private int playerNumber;
	private String name;
	private Team team;
	private ArrayList<Card> cards;
	
	public Player(int playerNumber, String name){
		this.playerNumber = playerNumber;
		this.name = name;
	}

	// @hadi: I think you write it wrong. I changed for(Card c : cards) to for(card c: card)
	/**
	 * Gives a number of cards to the player
	 * @param card an array of the cards to give
	 */
	public void giveCards(Card[] card){
		for(Card c : card)
			this.cards.add(c);
	}
	
	/**
	 * Takes a card from the players hand
	 * @param card the card to take
	 * @throws CardNotFoundException is thrown if such a card does not exist in the players hand
	 */
	public void takeCard(Card card) throws CardNotFoundException{
		boolean exist = cards.remove(card);
		if(!exist){
			throw new CardNotFoundException(card);
		}
	}
	
	/**
	 * @return the cards in the players hand
	 */
	public Card[] getCards() {
		return cards.toArray(new Card[cards.size()]);
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
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
