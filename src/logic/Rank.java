package logic;

public enum Rank {
	Two(0),
	Three(1),
	Four(2),
	Five(3),
	Six(4),
	Seven(5),
	Eight(6),
	Nine(7),
	Ten(8),
	Jack(9),
	Queen(10),
	King(11),
	Ace(12);
	
	private Rank(int number){
		this.number = number;
	}
	
	private int number;
	public int getNumber(){
		return this.number;
	}

	public int compare(Rank rank){	
		return (this.number > rank.number ? 1 : (this.number == rank.number ? 0 : -1));  
	}
	
	public static Rank getRank(int number){
		return Rank.values()[number];
	}
}
