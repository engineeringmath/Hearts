package logic;

import java.util.ArrayList;

import logic.exception.CardNotInHandException;

public class Player {

	private int playerNumber;
	private String name;
	private Team team;
	private ArrayList<Card> cards;
	
	public Player(int playerNumber, String name){
		this.playerNumber = playerNumber;
		this.name = name;
	}

	public void giveCards(Card[] card){
		// TODO
	}
	
	public void takeCard(Card card) throws CardNotInHandException{
		boolean exist = cards.remove(card);
		if(!exist){
			throw new CardNotInHandException(card);
		}
	}
	
	/**
	 * @return the cards in the players hand
	 */
	public Card[] getCards() {
		return cards.toArray(new Card[cards.length);
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
