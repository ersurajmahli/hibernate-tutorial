package com.forgyan.entity.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.forgyan.entity.Register;

@Entity
@Table(name="t_primary_details")
public class PrimaryDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="primary_details_id")
	private int primaryDetailsId;
	
	@Column(name="primary_contact")
	private String primaryContact;

	@Column(name="secondary_contact")
	private String secondaryContact;

	@Column(name="roll_number")
	private String rollNumber;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="register_id")
	private Register register;

	
	public PrimaryDetails() {
		
	}

	public PrimaryDetails(String primaryContact, String secondaryContact, String rollNumber) {
		super();
		this.primaryContact = primaryContact;
		this.secondaryContact = secondaryContact;
		this.rollNumber = rollNumber;
	}

	public int getPrimaryDetailsId() {
		return primaryDetailsId;
	}

	public void setPrimaryDetailsId(int primaryDetailsId) {
		this.primaryDetailsId = primaryDetailsId;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	

	
}
