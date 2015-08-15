package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.emobile.smis.web.utils.CommonUtil;

public class TargetCMODetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int headerId;
	private int salesId;
	private double targetPhSales;
	private String targetPhSalesStr;
	private int targetTotalUnitSales;
	
	/* for display */
	private String salesName;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getTargetTotalUnitSales() {
		return targetTotalUnitSales;
	}

	public void setTargetTotalUnitSales(int targetTotalUnitSales) {
		this.targetTotalUnitSales = targetTotalUnitSales;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public double getTargetPhSales() {
		return targetPhSales;
	}

	public void setTargetPhSales(double targetPhSales) {
		this.targetPhSales = targetPhSales;
	}

	public String getTargetPhSalesStr() {
		if(targetPhSales > 0){	
			 targetPhSalesStr = CommonUtil.convertToLocalGermany(targetPhSales);
		}
		return targetPhSalesStr;
	}

	public void setTargetPhSalesStr(String targetPhSalesStr) {
		this.targetPhSalesStr = targetPhSalesStr;
	}
}
