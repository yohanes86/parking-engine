package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DealerShowroom implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String joinId;
	private String dealerShowroomId;
	private String dealerShowroomName;
	private String branchCode;
	private String branchName;
//	private String salesPotention;
	private String address;
	private int status;
	private int type;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	private String groupDealerShowroom;
	private int position;
	private int jumlahUnit;
	private int otr;
	private int kapasitasTempat;
	private int luasDealer;
	
	private String city;
	private String statusDisplay;
	private String penentuDisplay;
	private String jumlahUnitDisplay;
	private String otrDisplay;
	private String kapasitasTempatDisplay;
	private String luasDealerDisplay;
	
	private String product;
	private int productType;

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
	public String getJoinId() {
		return joinId;
	}
	public void setJoinId(String joinId) {
		this.joinId = joinId;
	}
	public String getDealerShowroomId() {
		return dealerShowroomId;
	}
	public void setDealerShowroomId(String dealerShowroomId) {
		this.dealerShowroomId = dealerShowroomId;
	}
	public String getDealerShowroomName() {
		return dealerShowroomName;
	}
	public void setDealerShowroomName(String dealerShowroomName) {
		this.dealerShowroomName = dealerShowroomName;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
//	public String getSalesPotention() {
//		return salesPotention;
//	}
//	public void setSalesPotention(String salesPotention) {
//		this.salesPotention = salesPotention;
//	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getGroupDealerShowroom() {
		return groupDealerShowroom;
	}
	public void setGroupDealerShowroom(String groupDealerShowroom) {
		this.groupDealerShowroom = groupDealerShowroom;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getJumlahUnit() {
		return jumlahUnit;
	}
	public void setJumlahUnit(int jumlahUnit) {
		this.jumlahUnit = jumlahUnit;
	}
	public int getOtr() {
		return otr;
	}
	public void setOtr(int otr) {
		this.otr = otr;
	}
	public int getKapasitasTempat() {
		return kapasitasTempat;
	}
	public void setKapasitasTempat(int kapasitasTempat) {
		this.kapasitasTempat = kapasitasTempat;
	}
	public int getLuasDealer() {
		return luasDealer;
	}
	public void setLuasDealer(int luasDealer) {
		this.luasDealer = luasDealer;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	public String getPenentuDisplay() {
		return penentuDisplay;
	}
	public void setPenentuDisplay(String penentuDisplay) {
		this.penentuDisplay = penentuDisplay;
	}
	public String getJumlahUnitDisplay() {
		return jumlahUnitDisplay;
	}
	public void setJumlahUnitDisplay(String jumlahUnitDisplay) {
		this.jumlahUnitDisplay = jumlahUnitDisplay;
	}
	public String getOtrDisplay() {
		return otrDisplay;
	}
	public void setOtrDisplay(String otrDisplay) {
		this.otrDisplay = otrDisplay;
	}
	public String getKapasitasTempatDisplay() {
		return kapasitasTempatDisplay;
	}
	public void setKapasitasTempatDisplay(String kapasitasTempatDisplay) {
		this.kapasitasTempatDisplay = kapasitasTempatDisplay;
	}
	public String getLuasDealerDisplay() {
		return luasDealerDisplay;
	}
	public void setLuasDealerDisplay(String luasDealerDisplay) {
		this.luasDealerDisplay = luasDealerDisplay;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
}
