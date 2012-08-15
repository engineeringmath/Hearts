package logic;

public class GameLogic {
	private static GameLogic instance;
	
	public static GameLogic getInstance(){
		return instance;
	}
	
	public static void newInstance(String[] playerNames){
		instance = new GameLogic(playerNames);
	}
	
	// -------------------------------------
	
	private Player[] players;
	private Team[] teams;
	private Player hakem;
	private Table table;
	private Suit hokm;
	private int turn;
	
	private GameLogic(String[] playerNames){
		players = new Player[4];
		for (int i = 0; i < players.length; i++)
			players[i] = new Player(i+1,playerNames[i]);
		
		teams = new Team[2];
		teams[0] = new Team(players[0], players[2]);
		teams[1] = new Team(players[1], players[3]);
		
		hakem = null;
		hokm = null;
		turn = 0;
	}
	
	public boolean checkMove(Move move){
		return false;
	}
	
	public boolean playMove(Move move){
		return false;
	}
}
