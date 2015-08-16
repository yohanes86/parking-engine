package com.myproject.parking.lib.data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;

	private Address billingAddress;
	private String cvv2;
	private String expireMonth;
	private String expireYear;
	private String firstName;
	private String lastName;
	private String number;
	private String type;

	// creditCard.setBillingAddress(billingAddress);
	// creditCard.setCvv2(111);
	// creditCard.setExpireMonth(11);
	// creditCard.setExpireYear(2018);
	// creditCard.setFirstName("Joe");
	// creditCard.setLastName("Shopper");
	// creditCard.setNumber("4032038628710679");
	// creditCard.setType("visa");

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
