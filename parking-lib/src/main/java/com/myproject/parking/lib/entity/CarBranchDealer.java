package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CarBranchDealer implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String branchid;
	private String dealerid;
	private String dealername;
	private String maindealerid;
	private String maindealername;
	private String address;
	private String kota;
	private String branchName;
	private int productType;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getBranchid() {
		return branchid;
	}
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	public String getDealerid() {
		return dealerid;
	}
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public String getMaindealerid() {
		return maindealerid;
	}
	public void setMaindealerid(String maindealerid) {
		this.maindealerid = maindealerid;
	}
	public String getMaindealername() {
		return maindealername;
	}
	public void setMaindealername(String maindealername) {
		this.maindealername = maindealername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
}
