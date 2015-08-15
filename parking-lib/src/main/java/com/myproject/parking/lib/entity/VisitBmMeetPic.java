package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VisitBmMeetPic implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	private int id;		//[id] Int IDENTITY NOT NULL,
	private int visitId;	//[visit_id] Int NOT NULL,
	private int picId;	//[pic_id] Int NULL,
	private int picType; //[pic_type] Int NULL,
	private String name; //[name] varchar(255) NULL,
	private String supervisor;// [supervisor] Int NULL,
	private String status;// [status] varchar(20) NULL,
	private String ktpSiup;// [ktp_siup] varchar(256) NULL,
	private String npwpNo;// [npwp_no] Int NULL,
	private String npwpName;// [npwp_name] varchar(256) NULL,
	private String npwpAddress;// [npwp_address] varchar(256) NULL,
	private Date dateBirth; // [place_and_date_birth] varchar(256) NULL,
	private String placeBirth; // [place_and_date_birth] varchar(256) NULL,
	private String address; // [address] varchar(256) NULL,
	private String tlpNo;// [tlp_no] varchar(256) NULL,
	private String hp;// [hp] varchar(256) NULL,
	private int religion;// [religion] Int NULL,
	private String hobby;// [hobby] varchar(256) NULL,
	private String others;// [others] Varchar(256) NULL,
	private String nickName;// [nick_name] Varchar(256) NULL,
	private int position;// [position] Int NULL,
	private String remark; //[remark] varchar(256) NULL,
	
	//for displaying 
	private String positionDisplay;
	private int flagExisted;
	
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
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	public String getNpwpAddress() {
		return npwpAddress;
	}
	public void setNpwpAddress(String npwpAddress) {
		this.npwpAddress = npwpAddress;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTlpNo() {
		return tlpNo;
	}
	public void setTlpNo(String tlpNo) {
		this.tlpNo = tlpNo;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getPositionDisplay() {
		return positionDisplay;
	}
	public void setPositionDisplay(String positionDisplay) {
		this.positionDisplay = positionDisplay;
	}
	public int getFlagExisted() {
		return flagExisted;
	}
	public void setFlagExisted(int flagExisted) {
		this.flagExisted = flagExisted;
	}

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
	
	
	
}
