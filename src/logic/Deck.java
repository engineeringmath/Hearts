package logic;

import logic.exception.CardNotFoundException;

/**
 * A Deck of 52 cards, all cards in the game should be accessed from this deck
 */
public class Deck {
	
	/* Bara inke harvagh ke too code lazem shod ke ye card ro begirim, nayaym hey hardafe
	 * new konim ye card ke baas she az har card 1000 ta new she, too in class 52 ta card
	 * ro yek bar new mikonim, bad hardafe khastim ye cardiro az getCard() e in migirim ono
	 * be ja new kardan
	 */
	Card[] cards = new Card[52];
	
	/**
	 * Create a set of deck and initialize every 52 cards.
	 */
	public Deck(){
		// TODO initialize
		int i = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards[i] = new Card(r, s);
				i++;
			}
		}	
	}
	
	//kollan nemidunam alan khub zadam ino ya na! :D
	/**
	 * Finds a card specified by rank and suit.
	 * @param rank is the rank of the card.
	 * @param suit is the suit of the card.
	 * @return selected card.
	 */
	public Card getCard(Rank rank, Suit suit){
		// TODO
		return cards[suit.getNumber()*13 + rank.getNumber()];
//		for (Card c: cards) {
//			if (c.getRank() == rank && c.getSuit() == suit)
//				return c;
//		}
		//throw new CardNotFoundException();   ???
	}
}
