package com.emobile.smis.web.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SalesPerformance implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private int visitId; //dealer showroom id/CMO
	private int picVisitId;
	private long cash;
	private long credit;
	private long bcaf;
	private int cpPlus;
	
	//additional data pic
	private int picType;
	private String name;
	private int supervisor;
	private int status;
	private String ktpSiup;
	private String npwpNo;
	private String npwpName;
	private String npwpAddress;
	private Date dateBirth;
	private String placeBirth;
	private String address;
	private String telpNo;
	private String hp;
	private int religion;
	private String hobby;
	private String others;
	private String nickName;
	private int position;	
	
	private List<DataCompetitor> listDataCompetitor;
	
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
	public int getPicVisitId() {
		return picVisitId;
	}
	public void setPicVisitId(int picVisitId) {
		this.picVisitId = picVisitId;
	}
	public long getCash() {
		return cash;
	}
	public void setCash(long cash) {
		this.cash = cash;
	}
	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	public long getBcaf() {
		return bcaf;
	}
	public void setBcaf(long bcaf) {
		this.bcaf = bcaf;
	}
	public int getCpPlus() {
		return cpPlus;
	}
	public void setCpPlus(int cpPlus) {
		this.cpPlus = cpPlus;
	}

	public List<DataCompetitor> getListDataCompetitor() {
		return listDataCompetitor;
	}

	public void setListDataCompetitor(List<DataCompetitor> listDataCompetitor) {
		this.listDataCompetitor = listDataCompetitor;
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

	public String getNpwpAddress() {
		return npwpAddress;
	}

	public void setNpwpAddress(String npwpAddress) {
		this.npwpAddress = npwpAddress;
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
}
