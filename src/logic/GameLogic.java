package logic;

public class GameLogic {
	private static GameLogic instance;
	
	public static GameLogic getInstance(){
		if(instance == null)
			instance = new GameLogic();
		return instance;
	}
	
	public static void newInstance(){
		instance = new GameLogic();
	}
	
	// -------------------------------------
	
	private Player[] players;
	private Team[] teams;
	private Player Hakem;
	private Table table;
	private Suit hokm;
	private int turn;
	
	private GameLogic(){
		
	}
	
	public boolean checkMove(Move move){
		return false;
	}
	
	public boolean playMove(Move move){
		return false;
	}
}
