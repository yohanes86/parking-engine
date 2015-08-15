package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String userCode;
	private String userPassword;
	private boolean passwordChanged;
	private Date lastLoginDate;
	
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
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean isPasswordChanged() {
		return passwordChanged;
	}
	public void setPasswordChanged(boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}
	
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}	
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}	
}
