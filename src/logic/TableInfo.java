package logic;

// @hadi: man farz kardam har card ye adade unique az 0 ta 51 dare.

public class TableInfo implements GameInfo{
	private int[] table;
	
	public TableInfo(Table table){
		Card[] temp = table.getTableCards();
		this.table = new int[temp.length];
		for(int i = 0; i < temp.length; i++)
		{
			this.table[i] = temp[i].getSuit().getNumber() * 13 + temp[i].getRank().getNumber();
		}
	}
	
	public int[] getTable(){
		return table;
	}
}
