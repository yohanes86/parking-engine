package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Region implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String regionCode;
	private String regionName;
	private int createdBy;
	private Date createdOn;
	private int updatedBy;
	private Date updatedOn;
	
	
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
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	
}
