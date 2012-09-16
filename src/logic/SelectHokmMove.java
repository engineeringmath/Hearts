package logic;

public class SelectHokmMove extends Move{
	private Suit suit;	// rank as hokm!
	//Clubs as 0
	//Hearts as 1
	//Diamonds as 2
	//Spades as 3
	
	public SelectHokmMove(Suit suit) {
			this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit rank) {
		this.suit = rank;
	}

	@Override
	public byte[] serialize() {
		// TODO Auto-generated method stub
		return null;

	}

}
