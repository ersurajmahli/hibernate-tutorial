package com.forgyan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_register")
public class Register {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="register_id")
	private int registerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="pass")
	private String password;
	
	@OneToOne(mappedBy="register", cascade=CascadeType.ALL)
	private PrimaryDetails primaryDetails;
	
	@OneToMany(mappedBy="registerAdd", 
			   cascade={
					CascadeType.DETACH, 
					CascadeType.MERGE, 
					CascadeType.PERSIST, 
					CascadeType.REFRESH
				},
			   fetch=FetchType.LAZY)
	private List<AddressDetails> addressDetails;
	
	@OneToMany(fetch=FetchType.LAZY,
				cascade=CascadeType.ALL)
	@JoinColumn(name="registeId")
	private List<Degree> degree;

	public Register() {
		
	}

	public Register(String firstName, String lastName, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int id) {
		this.registerId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PrimaryDetails getPrimaryDetails() {
		return primaryDetails;
	}

	public void setPrimaryDetails(PrimaryDetails primaryDetails) {
		this.primaryDetails = primaryDetails;
	}


	public List<AddressDetails> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(List<AddressDetails> addressDetails) {
		this.addressDetails = addressDetails;
	}
	
	public List<Degree> getDegree() {
		return degree;
	}

	public void setDegree(List<Degree> degree) {
		this.degree = degree;
	}

	public void add(AddressDetails ad) {
		if (addressDetails==null) {
			addressDetails = new ArrayList<>();
		}
		addressDetails.add(ad);
		ad.setRegisterAdd(this);
	}

	public void addDegree(Degree degree) {
		if(this.degree==null) {
			this.degree = new ArrayList<>();
		}
		this.degree.add(degree);
	}

	@Override
	public String toString() {
		return "Register [registerId=" + registerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
