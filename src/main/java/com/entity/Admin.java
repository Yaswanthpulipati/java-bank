package com.entity;

public class Admin {
	private String adminId;
	private String name;
	private String email;
	private String password;
	private String dob;
	private int expLevel;
	int customersAdded;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getExpLevel() {
		return expLevel;
	}
	public void setExpLevel(int expLevel) {
		this.expLevel = expLevel;
	}
	public int getCustomersAdded() {
		return customersAdded;
	}
	public void setCustomersAdded(int customersAdded) {
		this.customersAdded = customersAdded;
	}
	
	
}
