package logic;

public class TurnInfo implements GameInfo{
	
	private int turn;
	public TurnInfo(int turn){
		this.turn = turn;
	}
	public int getTurn(){
		return turn;
	}
}
