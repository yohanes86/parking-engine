package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Assignment implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int productId;
	private int branchId;
	private int dealerOrShowroomId;
	private int personInChargeId;
	private int assignTo; // if assignment to CMO it can be person in charge dealer showroom
	private int type;
	private Date dateFrom;
	private Date dateTo;
	private int statusVisit;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	
	/* additional data but not entity */
	private String productName;
	private String branchCode;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
//		return ReflectionToStringBuilder.toString(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
//	public String getDealerOrShowroomNameSA() {
//		return dealerOrShowroomNameSA;
//	}
//	public void setDealerOrShowroomNameSA(String dealerOrShowroomNameSA) {
//		this.dealerOrShowroomNameSA = dealerOrShowroomNameSA;
//	}
	public int getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(int assignTo) {
		this.assignTo = assignTo;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public int getDealerOrShowroomId() {
		return dealerOrShowroomId;
	}

	public void setDealerOrShowroomId(int dealerOrShowroomId) {
		this.dealerOrShowroomId = dealerOrShowroomId;
	}

	public int getStatusVisit() {
		return statusVisit;
	}

	public void setStatusVisit(int statusVisit) {
		this.statusVisit = statusVisit;
	}

	public int getPersonInChargeId() {
		return personInChargeId;
	}

	public void setPersonInChargeId(int personInChargeId) {
		this.personInChargeId = personInChargeId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
}
