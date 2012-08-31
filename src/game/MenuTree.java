public class MenuTree {
	public static void main(String[] args) {
		MenuNode login = new MenuNode(null, "Login");
		MenuNode newGame= new MenuNode(login, "New Game");
		MenuNode setting= new MenuNode(login, "Setting");
		MenuNode credits= new MenuNode(login, "Credits");
		MenuNode statistics= new MenuNode(login, "Statistics");
		MenuNode howToPlay= new MenuNode(login, "How to play");
		MenuNode lan= new MenuNode(newGame, "Lan");
		MenuNode computer= new MenuNode(newGame, "Computer");
		MenuNode internet= new MenuNode(newGame, "Internet");
		System.out.println(internet.getPosition());
	}
}

class MenuNode {
	private MenuNode parent;
	private String label;
	public String position="";

	public MenuNode(MenuNode parent, String label) {
		this.parent = parent;
		this.label = label;
		MenuNode tempNode = this;
		while (tempNode != null) {
			position=tempNode.label + "<"+position;
			tempNode = tempNode.parent;
		}
	}

	public String getPosition() {
		return position;
	}
}
