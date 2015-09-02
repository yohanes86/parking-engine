package com.myproject.parking.lib.data;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class HistoryBookingVO extends LoginData implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String mallName;
	private Date bookingDate;
	private String bookingDateValue;
	private String bookingId;
	private String bookingCode;
	private String status;
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getBookingDateValue() {
		return bookingDateValue;
	}

	public void setBookingDateValue(String bookingDateValue) {
		this.bookingDateValue = bookingDateValue;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	

}
