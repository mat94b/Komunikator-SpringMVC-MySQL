package containers;

public class SendMessage {
	private String adressContact;
	private String messageText;
	private String titleOfTheMessage;
	
	public String getTitleOfTheMessage() {
		return titleOfTheMessage;
	}
	public void setTitleOfTheMessage(String titleOfTheMessage) {
		this.titleOfTheMessage = titleOfTheMessage;
	}
	public String getAdressContact() {
		return adressContact;
	}
	public void setAdressContact(String adressContact) {
		this.adressContact = adressContact;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
}
