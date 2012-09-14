package network.message;

public abstract class NetworkMessage {

	private MessageType messageType;
	
	public NetworkMessage(MessageType type){
		this.messageType = type;
	}
	
	public abstract String getText();
	
	public MessageType getMessageType(){
		return messageType;
	}
}
