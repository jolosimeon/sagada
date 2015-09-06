package model;

public class PlasticRequest {
	
	private int request_id;
	private String address;
	private String status;
	private String email;
	private float kg;
	
	public PlasticRequest(int request_id, String address, String status,
			String email, float kg) {
		super();
		this.request_id = request_id;
		this.address = address;
		this.status = status;
		this.email = email;
		this.kg = kg;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getKg() {
		return kg;
	}

	public void setKg(float kg) {
		this.kg = kg;
	}

}
