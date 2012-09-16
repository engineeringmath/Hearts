package logic;

public class HokmInfo implements GameInfo {
	private int hokm;
	
	public HokmInfo(Suit hokm){
		this.hokm = hokm.getNumber();
	}
	
	public int getHokm(){
		return hokm;
	}
}
