package com.forgyan.entity.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.forgyan.entity.Register;

@Entity
@Table(name="t_address_detail")
public class AddressDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_detail_id")
	private int addressId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pin_code")
	private String pinCode;
	
	@Column(name="land_line_number")
	private String landLineNumber;
	
	@Column(name="fax_number")
	private String faxNumber;
	
	@Column(name="is_default")
	private String isDefault;
	
	@ManyToOne(cascade= {
				CascadeType.DETACH, 
				CascadeType.MERGE, 
				CascadeType.PERSIST, 
				CascadeType.REFRESH})
	@JoinColumn(name="register_id")
	private Register registerAdd;

	public AddressDetails() {
		super();
	}

	public AddressDetails(String address, String district, String state, String pinCode, String landLineNumber,
			String faxNumber, String isDefault) {
		super();
		this.address = address;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.landLineNumber = landLineNumber;
		this.faxNumber = faxNumber;
		this.isDefault = isDefault;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public Register getRegisterAdd() {
		return registerAdd;
	}

	public void setRegisterAdd(Register registerAdd) {
		this.registerAdd = registerAdd;
	}

	@Override
	public String toString() {
		return "AddressDetails [addressId=" + addressId + ", address=" + address + ", district=" + district + ", state="
				+ state + ", pinCode=" + pinCode + ", landLineNumber=" + landLineNumber + ", faxNumber=" + faxNumber
				+ ", isDefault=" + isDefault + ", registerAdd=" + registerAdd + "]";
	}

	
	
	

}
