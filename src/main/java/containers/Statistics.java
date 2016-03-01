package containers;

import java.util.Date;

public class Statistics {

	private Date registrationDate;
	private Date lastOnline;
	private int sendMessages;
	private int recievedMessages;
	private int id;
	
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastOnline() {
		return lastOnline;
	}
	public void setLastOnline(Date lastOnline) {
		this.lastOnline = lastOnline;
	}
	public int getSendMessages() {
		return sendMessages;
	}
	public void setSendMessages(int sendMessages) {
		this.sendMessages = sendMessages;
	}
	public int getRecievedMessages() {
		return recievedMessages;
	}
	public void setRecievedMessages(int recievedMessages) {
		this.recievedMessages = recievedMessages;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
