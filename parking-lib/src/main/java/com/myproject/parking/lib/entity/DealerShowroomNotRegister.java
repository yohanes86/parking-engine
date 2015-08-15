package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DealerShowroomNotRegister {
	

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int visitId;
	private String dealerShowroomName;
	private String address;
	
	
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


	public int getVisitId() {
		return visitId;
	}


	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}


	public String getDealerShowroomName() {
		return dealerShowroomName;
	}


	public void setDealerShowroomName(String dealerShowroomName) {
		this.dealerShowroomName = dealerShowroomName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
