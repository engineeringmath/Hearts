package logic;

public class SelectHokmMove implements Move{
	private int rank;	// rank as hokm!
	//Clubs as 1
	//Hearts as 2
	//Diamonds as 3
	//Spades as 4
	
	public SelectHokmMove() {
		this.rank = 0;
	}

	public SelectHokmMove(int rank) {
		this.rank = rank;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
