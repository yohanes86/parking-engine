package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Bank implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String bankName;	
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
