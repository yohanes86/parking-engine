package com.emobile.smis.web.entity;

import java.util.Date;

public class JoinTable implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String joinId;
	private String dealerShowroomId;	
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	private String dealerShowroomName;
	
	public String getJoinId() {
		return joinId;
	}
	public void setJoinId(String joinId) {
		this.joinId = joinId;
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
	
}
