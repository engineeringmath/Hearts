package game;

import java.util.Map;

import logic.Move;

public class Game {
	Network network;
	GameLogic logic;
	GameState currentState;
	Graphic graphic;
	boolean gameover = false;
	boolean gameaborted=false;
	
	public Game(){
		logic = GameLogic.newInstance(["1","2","3","4"])
	}
	public void playMove(Move move){
		if(!logic.playMove(move)){
			logic.synchGameState(network.requestGameState(currentState));
			// showing moves with fucked logic
			//graphic.showMoves(Move[] move[])
		}
		else{
			//graphic.showMoves(Move move)
		}
	}

	public void gameAborted(){
		gameaborted=true;
		//graphic.showing one of players has died!!
	}
	public void gameOver((){
		gameover=true;
		//graphic.showing finished game
	}
	
	//input
	public void playCard(Move move){
		if(logic.checkMove(move)){
			logic.playMove(move)
			//graphic.showMoves(Move move)
		}
	}
	//Graphic
	public GameState getGameState(){
		return logic.getGameState();
	}
	// for android
	public void startApp(){
		
	}
	public void disconnect(){
		
	}
}
