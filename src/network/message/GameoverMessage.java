package network.message;

public class GameoverMessage extends NetworkMessage {

	public GameoverMessage(MessageType type) {
		super(type);
	}

	public String getText() {
		return "The game is over";
	}
}
