package com.myproject.parking.lib.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Profile {
	private String email;
	private String ccNumber;
	private String phoneNo;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
