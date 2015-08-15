package com.emobile.smis.web.entity;

import java.util.Date;

public class UserData {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userCode;
	private String userName;
	private int levelId;
	private String email;
	private double limitValue;
	private String userPassword;
	private Date changedPassOn;
	private int isChangedPass;
	private int canExpired;
	private int userStatus;
	private int allRegion;
	private int invalidCount;
	private Date lastLoginData;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	private String sessionId;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(double limitValue) {
		this.limitValue = limitValue;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getChangedPassOn() {
		return changedPassOn;
	}
	public void setChangedPassOn(Date changedPassOn) {
		this.changedPassOn = changedPassOn;
	}
	public int getIsChangedPass() {
		return isChangedPass;
	}
	public void setIsChangedPass(int isChangedPass) {
		this.isChangedPass = isChangedPass;
	}
	public int getCanExpired() {
		return canExpired;
	}
	public void setCanExpired(int canExpired) {
		this.canExpired = canExpired;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getAllRegion() {
		return allRegion;
	}
	public void setAllRegion(int allRegion) {
		this.allRegion = allRegion;
	}
	public int getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(int invalidCount) {
		this.invalidCount = invalidCount;
	}
	public Date getLastLoginData() {
		return lastLoginData;
	}
	public void setLastLoginData(Date lastLoginData) {
		this.lastLoginData = lastLoginData;
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
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
