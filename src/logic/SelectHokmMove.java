package logic;

public class SelectHokmMove implements Move{
	private Suit suit;	// rank as hokm!
	//Clubs as 1
	//Hearts as 2
	//Diamonds as 3
	//Spades as 4
	
	public SelectHokmMove(Suit rank) {
		this.suit = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit rank) {
		this.suit = rank;
	}

}
