package logic;

import java.util.ArrayList;

public class PacksWonInfo implements GameInfo {
	private ArrayList<ArrayList<Integer>> packsInfo1;
	private ArrayList<ArrayList<Integer>> packsInfo2;
	public PacksWonInfo(ArrayList<ArrayList<Card>> PacksWon1, ArrayList<ArrayList<Card>> PacksWon2){
		packsInfo1 = new ArrayList<ArrayList<Integer>>();
		packsInfo2 = new ArrayList<ArrayList<Integer>>();
		
		// what a mess! converting a 2d ArrayList of cards to a 2d arrayList of integers.
		for (ArrayList<Card> pack : PacksWon1) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (Card c : pack) {
				temp.add(c.getSuit().getNumber() * 13 + c.getRank().getNumber());
			}
			packsInfo1.add(temp);
		}
		
		for (ArrayList<Card> pack : PacksWon2) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (Card c : pack) {
				temp.add(c.getSuit().getNumber() * 13 + c.getRank().getNumber());
			}
			packsInfo2.add(temp);
		}
	}
//	IMPORTANT	
//	@hadi: khastam baraye tabe getPacksWon benevisam Arraylist<ArrayList<Integer>>[] ke ghabul nemikard. nemidunam
//	chi kar konam in tikkasho.
}
