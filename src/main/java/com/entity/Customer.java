package com.entity;

public class Customer {
	
	private String accNumber;
	private String password;
	private String fullName;
	private String address;
	private String mobileNumber;
	private String email;
	private String accType;
	private double balance;
	private String dob;
	private String idProof;
	
	public Customer() {}
	
	public Customer(String accNumber, String password, String fullName, String address, String mobileNumber,
			String email, String accType, double balance, String dob, String idProof) {
		super();
		this.accNumber = accNumber;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.accType = accType;
		this.balance = balance;
		this.dob = dob;
		this.idProof = idProof;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	
}
