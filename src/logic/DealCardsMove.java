package logic;


public class DealCardsMove extends Move {
	private int randomSeed;
	
	public DealCardsMove(int randomSeed){
		this.randomSeed = randomSeed;
	}
	
	public int getRandomSeed(){
		return randomSeed;
	}

	@Override
	public byte[] serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
