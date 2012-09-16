package network.message;

public class AbortMessage extends NetworkMessage{

	public AbortMessage(MessageType type) {
		super(type);
	}

	public String getText() {
		return "Connection Timed Out !! Abort";
	}

}
