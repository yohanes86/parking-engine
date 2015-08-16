package com.myproject.parking.lib.data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String city;
	private String countryCode;
	private String line1;
	private String postalCode;
	private String state;
	
	
	
//	billingAddress.setCity("Johnstown");
//	billingAddress.setCountryCode("US");
//	billingAddress.setLine1("52 N Main ST");
//	billingAddress.setPostalCode("43210");
//	billingAddress.setState("OH");
	
	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public String getLine1() {
		return line1;
	}



	public void setLine1(String line1) {
		this.line1 = line1;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
