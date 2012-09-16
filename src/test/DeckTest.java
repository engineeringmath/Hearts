package test;

import static org.junit.Assert.*;
import logic.Card;
import logic.Deck;
import logic.Rank;
import logic.Suit;

import org.junit.Test;

public class DeckTest {

	@Test
	public void test() {
		Deck d = new Deck();
		Card c = d.getCard(Rank.Ace, Suit.Hearts);
		assertEquals(c, new Card(Rank.Ace, Suit.Hearts));
	}

}
