package network.message;

public class DisconnectMessage extends NetworkMessage{

	String clientName;
	public DisconnectMessage(MessageType type,  String clientName) {
		super(type);
		this.clientName = clientName;
	}

	public String getText() {
		return String.format("Player %s has been disconnected", this.clientName);
	}

}
