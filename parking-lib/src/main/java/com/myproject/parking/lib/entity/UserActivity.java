package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserActivity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int activityId;  // activity_id Int NOT NULL AUTO_INCREMENT,
	private String activityType;  // activity_type Varchar(64),
	private String activityDesc;  // activity_desc Varchar(255),
	private String activityStatus; //activity_status Varchar(50),
	private String moduleName;	//moduleName Varchar(255),
	private int createdBy; // created_by Char(10),
	private Date createdOn;  // created_on Datetime,

	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getActivityDesc() {
		return activityDesc;
	}
	public void setActivityDesc(String activityDesc) {
		if (activityDesc == null)
			this.activityDesc = null;
		else {
			if (activityDesc.length() > 255)
				activityDesc = activityDesc.substring(0, 253) + "..";
			this.activityDesc = activityDesc;
		}
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
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
