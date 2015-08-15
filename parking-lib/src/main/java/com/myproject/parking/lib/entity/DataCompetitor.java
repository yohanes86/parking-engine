package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DataCompetitor implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int salesPerformanceId;
	private int otherMultifinanceId;
	private long total;
	
	//additional data other multifinance
	private String multifinanceName;
	private String multifinanceCode;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	public int getSalesPerformanceId() {
		return salesPerformanceId;
	}
	public void setSalesPerformanceId(int salesPerformanceId) {
		this.salesPerformanceId = salesPerformanceId;
	}
	public int getOtherMultifinanceId() {
		return otherMultifinanceId;
	}
	public void setOtherMultifinanceId(int otherMultifinanceId) {
		this.otherMultifinanceId = otherMultifinanceId;
	}
	
	public String getMultifinanceName() {
		return multifinanceName;
	}

	public void setMultifinanceName(String multifinanceName) {
		this.multifinanceName = multifinanceName;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getMultifinanceCode() {
		return multifinanceCode;
	}

	public void setMultifinanceCode(String multifinanceCode) {
		this.multifinanceCode = multifinanceCode;
	}
	
}
