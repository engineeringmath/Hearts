package logic;

import logic.exception.CardNotFoundException;


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
	private Deck deck;
	
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
		deck = new Deck();
	}
	
	/**
	 * Checks whether a given move is valid for the current state of the game
	 * @param move the move to check its validity
	 * @return true if the move was valid, false otherwise
	 */
	public boolean checkMove(Move move){
		if(move instanceof PlayCardMove){
			PlayCardMove pMove = (PlayCardMove)move;
			
			if(hakem == null || hokm == null)
				return false;
			if(pMove.getPlayerNumber() != turn)
				return false;
			
			Player player = players[pMove.getPlayerNumber()];
			if(table.getCurrentSuit() != null && 
				pMove.getSuit() != table.getCurrentSuit()){
				for(Card card : player.getCards())				// checks if player is able to cut or pass(!)
					if(card.getSuit() == pMove.getSuit())
						return false;
			}
			
			return true;
			
//			I was confused whether to check the correctness of setHakem here or in GameLogic. i changed the selectHokm (tu range budane shomare)	

		}else if(move instanceof SelectHokmMove){
			if(hokm != null)
				return false;
			return true;
		}else if(move instanceof SetHakemMove){
			if(hakem != null)
				return false;
			return true;
		}else if (move instanceof DealCardsMove){
			return true; // Dunno
		}

		return false;
	}
	
	/**
	 * Plays a move
	 * @param move the move to play
	 * @return true if the move was successful played, false otherwise
	 */
	public boolean playMove(Move move){
		if(!checkMove(move))
			return false;
		
		if(move instanceof PlayCardMove){
			return playCardMove((PlayCardMove)move);
			
		}else if(move instanceof SelectHokmMove){
			SelectHokmMove sMove = (SelectHokmMove)move;
			hokm = sMove.getSuit();
			
		}else if(move instanceof SetHakemMove){
			SetHakemMove sMove = (SetHakemMove)move;
			hakem = players[sMove.getPlayerNumber()];
			
		}else if(move instanceof DealCardsMove){
			DealCardsMove dMove = (DealCardsMove)move;
			dealCards(dMove.getRandomSeed());
		}
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
	
	private void dealCards(int randomSeed){
		Card[] cards = deck.shuffle(randomSeed);
		int i = 0;
		for(Card card : cards)
			players[(i++)%4].giveCard(card);
	}
	
	// highCard is confusing. OhterCard is better. how about dominance instead of compare??
	// IMPORTANT. @hadi: it doesn't support the situation that sb pass some carts on a none hokm card. (rad dadan ruye cardi ke hokm nist)
	private boolean compare(Card card, Card highCard){	
		if(card.getSuit() == hokm)	{
			if(highCard.getSuit() != hokm)
				return true;
			else if(card.getRank().compare(highCard.getRank()) > 0 )
				return true;
		}else if(card.getSuit() == table.getCurrentSuit()
				 && card.getRank().compare(highCard.getRank()) > 0 ){
			return true;
		}
		return false;
	}
	
	private boolean playCardMove(PlayCardMove pMove){
		Rank rank = pMove.getRank();
		Suit suit = pMove.getSuit();
		Player player = players[pMove.getPlayerNumber()];

		// Take the card from the players hand
		try {
			player.takeCard(deck.getCard(rank,suit));
		} catch (CardNotFoundException e) {
			// Card wasn't in players hand
			return false;
		}
		
		// Add the card to the table
		table.addCard(player, deck.getCard(rank,suit));
		
		if(table.getCardCount() == 4){ 
			Card[] cards = table.getTableCards();
			Card highCard = deck.getCard(Rank.Two, table.getCurrentSuit());		
			// choosing the most powerful card on the table
			for(Card card : cards)
				if(compare(card, highCard))
					highCard = card;
			
			Player scorer = table.getCardPlayer(highCard);
			scorer.getTeam().addPacksWon(cards);
			table.clearTable();

			
			// @hadi: correct this.
			// if (scorer.getTeam().getpacksWon() == 7) --> daste jadide bazi badesh packs won sefr.
			// if (scorer.getTeam().getRoundsWon() == 7) --> game over. 	
			
			if(scorer.getTeam().getRoundsWon() == 7){
				// GameOver
			}
		}
		
		return true;
	}
	
	
	public void updateTurn(){
		turn++;
		if (turn > 4) turn -= 4;
	}

	// --------- GET & SET ---------
	
	public Table getTable() {
		return table;
	}
	
	public Team[] getTeams() {
		return teams;
	}

	public int getTurn(){
		return turn;
	}
	public Player getHakem() {
		return hakem;
	}
	
	public Suit getHokm() {
		return hokm;
	}
}
