package com.emobile.smis.web.entity;

import java.util.Date;

public class MultifinanceOthers implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int multifinanceId;
	private String multifinanceName;
	private String multifinanceCode;
	private int status;
	private String statusName;
	private int createdBy;
	private Date createdOn;
	private Date updatedOn;
	private int updatedBy;

	public int getMultifinanceId() {
		return multifinanceId;
	}
	public void setMultifinanceId(int multifinanceId) {
		this.multifinanceId = multifinanceId;
	}
	public String getMultifinanceName() {
		return multifinanceName;
	}
	public void setMultifinanceName(String multifinanceName) {
		this.multifinanceName = multifinanceName;
	}
	public String getMultifinanceCode() {
		return multifinanceCode;
	}
	public void setMultifinanceCode(String multifinanceCode) {
		this.multifinanceCode = multifinanceCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
}