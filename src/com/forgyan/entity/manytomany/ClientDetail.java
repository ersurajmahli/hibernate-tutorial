package com.forgyan.entity.manytomany;

public class ClientDetail {
	
	private int studentId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;

	public ClientDetail() {
		super();
	}

	public ClientDetail(String firstName, String lastName, String emailId, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
