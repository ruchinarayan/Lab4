package todoservlet;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "randomMessageList")
public class TodoMessageList {

	@XmlElementWrapper(name="randomMessage")
	private List<TodoMessage> messages;
	private int messageCount = 0;
	
	public List<TodoMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<TodoMessage> messages) {
		this.messages = messages;
		this.setMessageCount(messages.size());
	}
	public int getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	
	
}
