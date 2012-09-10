package logic;


public class GameLogic {
	private static GameLogic instance;
	
	/**
	 * @return the singleton instance of the GameLogic class
	 */
	public static GameLogic getInstance(){
		return instance;
	}
	
	/**
	 * Creates a new singleton instance
	 * @param playerNames the names of the players
	 */
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
	
	/**
	 * Checks whether a given move is valid for the current state of the game
	 * @param move the move to check its validity
	 * @return true if the move was valid, false otherwise
	 */
	public boolean checkMove(Move move){
		// TODO
		return false;
	}
	
	/**
	 * Plays a move
	 * @param move the move to play
	 * @return true if the move was successful played, false otherwise
	 */
	public boolean playMove(Move move){
		// TODO
		return false;
	}
	
	/**
	 * Returns some requested information on the current state of the game
	 * @param infoRequest defines the information to be returned
	 * @return an instance of GameInfo containing the requested information
	 */
	public GameInfo requestInfo(InfoRequest infoRequest){
		// TODO
		return null;
	}
	
	public Table getTable() {
		return table;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
}
