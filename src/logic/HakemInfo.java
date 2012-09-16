package logic;

public class HakemInfo implements GameInfo {
	private int hakem;
	
	public HakemInfo(Player hakem){
		this.hakem = hakem.getPlayerNumber();
	}
	
	public int getHakem(){
		return hakem;
	}
}
