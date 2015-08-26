package com.myproject.parking.lib.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String phoneNo;
	private String email;
	private String mallName;
	private int idSlot;
	private String bookingId;
	private String bookingCode;
	private Date bookingDate;
	private int bookingStatus;
		

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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getBookingCode() {
		return bookingCode;
	}


	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}


	public Date getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getMallName() {
		return mallName;
	}


	public void setMallName(String mallName) {
		this.mallName = mallName;
	}


	public int getIdSlot() {
		return idSlot;
	}


	public void setIdSlot(int idSlot) {
		this.idSlot = idSlot;
	}


	public int getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	

	

}
