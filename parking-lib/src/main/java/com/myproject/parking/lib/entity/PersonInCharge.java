package com.emobile.smis.web.entity;

import java.util.Date;

public class PersonInCharge {
	private int id;
	private int dealerShowroomId;
	private int picType;
	private String name;
	private int position;
	private String nickName;
	private int supervisor;
	private int status;
	private String ktpSiup;
	private String npwpNo;
	private String npwpName;
//	private String npwpAddress;
	private Date dateBirth;
	private String placeBirth;
	private String address;
	private String telpNo;
	private String hp;
	private int religion;
	private String hobby;
	private String others;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;

	//get product id from login
	private int productId;
	
	//for displaying
	private String dealerShowroomCode;
	private String dealerShowroomName;
	private String positionDisplay;
	private String supervisorDisplay;
	private String statusDisplay;
	private String religionDisplay;
	private String personNameAndPosition;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDealerShowroomId() {
		return dealerShowroomId;
	}
	public void setDealerShowroomId(int dealerShowroomId) {
		this.dealerShowroomId = dealerShowroomId;
	}
	public int getPicType() {
		return picType;
	}
	public void setPicType(int picType) {
		this.picType = picType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKtpSiup() {
		return ktpSiup;
	}
	public void setKtpSiup(String ktpSiup) {
		this.ktpSiup = ktpSiup;
	}
	public String getNpwpNo() {
		return npwpNo;
	}
	public void setNpwpNo(String npwpNo) {
		this.npwpNo = npwpNo;
	}
	public String getNpwpName() {
		return npwpName;
	}
	public void setNpwpName(String npwpName) {
		this.npwpName = npwpName;
	}
//	public String getNpwpAddress() {
//		return npwpAddress;
//	}
//	public void setNpwpAddress(String npwpAddress) {
//		this.npwpAddress = npwpAddress;
//	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getPlaceBirth() {
		return placeBirth;
	}
	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelpNo() {
		return telpNo;
	}
	public void setTelpNo(String telpNo) {
		this.telpNo = telpNo;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public int getReligion() {
		return religion;
	}
	public void setReligion(int religion) {
		this.religion = religion;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDealerShowroomCode() {
		return dealerShowroomCode;
	}
	public void setDealerShowroomCode(String dealerShowroomCode) {
		this.dealerShowroomCode = dealerShowroomCode;
	}
	public String getDealerShowroomName() {
		return dealerShowroomName;
	}
	public void setDealerShowroomName(String dealerShowroomName) {
		this.dealerShowroomName = dealerShowroomName;
	}
	public String getPositionDisplay() {
		return positionDisplay;
	}
	public void setPositionDisplay(String positionDisplay) {
		this.positionDisplay = positionDisplay;
	}
	public String getSupervisorDisplay() {
		return supervisorDisplay;
	}
	public void setSupervisorDisplay(String supervisorDisplay) {
		this.supervisorDisplay = supervisorDisplay;
	}
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	public String getReligionDisplay() {
		return religionDisplay;
	}
	public void setReligionDisplay(String religionDisplay) {
		this.religionDisplay = religionDisplay;
	}
	public String getPersonNameAndPosition() {
		return personNameAndPosition;
	}
	public void setPersonNameAndPosition(String personNameAndPosition) {
		this.personNameAndPosition = personNameAndPosition;
	}
}
