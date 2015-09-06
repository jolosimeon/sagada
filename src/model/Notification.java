package model;

public class Notification {
	
	private int notification_id;
	private String email;
	private String message;
	private String read;
	
	public Notification(int notification_id, String email, String message) {
		this.notification_id = notification_id;
		this.email = email;
		this.message = message;
	}

	public int getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

}
