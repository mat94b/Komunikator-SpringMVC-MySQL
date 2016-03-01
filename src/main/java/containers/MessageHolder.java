package containers;

import java.util.Date;

public class MessageHolder {
	private String sendingUser;
	private String messageText;
	private String messageTitle;
	private Date messageDate;
	
	public String getSendingUser() {
		return sendingUser;
	}
	public void setSendingUser(String sendingUser) {
		this.sendingUser = sendingUser;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
}
