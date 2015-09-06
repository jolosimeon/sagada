package model;

import java.util.ArrayList;

public class User {
	
	private String email;
    private String first_name;
    private String last_name;
    private String cell_no;
    private String address;
    private String password;
    
    
    
    public User(String email, String first_name, String last_name,
			String cell_no, String address, String password) {

		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.cell_no = cell_no;
		this.address = address;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getCell_no() {
		return cell_no;
	}
	
	public void setCell_no(String cell_no) {
		this.cell_no = cell_no;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
        return first_name + " " + last_name;
    }
	

}
