package logic;

import java.util.Map;

public class Table {
	private Suit currentSuit;
	private Map<Player, Card> cards;
	
	public Suit getCurrentSuit(){
		return currentSuit;
	}
}
