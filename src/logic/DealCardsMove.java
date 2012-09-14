package logic;

public class DealCardsMove implements Move {
	private int randomSeed;
	
	public DealCardsMove(int randomSeed){
		this.randomSeed = randomSeed;
	}
	
	public int getRandomSeed(){
		return randomSeed;
	}
}
