package logic.exception;

import logic.Card;

public class CardNotFoundException extends LogicException {
	private Card card;
	
	public CardNotFoundException(){
		this.card = null;
	}
	
	public CardNotFoundException(Card card){
		this.card = card;
	}
	
	public Card getCard(){
		return this.card;
	}
}
