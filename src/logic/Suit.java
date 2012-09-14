package logic;

public enum Suit {
	Clubs(0),
	Hearts(1),
	Diamonds(2),
	Spades(3);
	
	Suit(int numd){
		this.num = numd;
	}
	
	private int num;
	public int getNumber(){
		return num;
	}
	
	public static Suit getSuit(int number){
		return Suit.values()[number];
	}
}


