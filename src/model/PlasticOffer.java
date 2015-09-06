package model;

public class PlasticOffer {
	
	private int offer_id;
	private String address;
	private String status;
	private float kg;
	private User giver;
	
	public PlasticOffer(int offer_id, String address, String status, float kg, User giver) {

		this.offer_id = offer_id;
		this.address = address;
		this.status = status;
		this.giver = giver;
		this.kg = kg;
	}
	
	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public float getKg() {
		return kg;
	}

	public void setKg(float kg) {
		this.kg = kg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getGiver() {
		return giver;
	}

	public void setGiver(User giver) {
		this.giver = giver;
	}

}
