package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserAccess implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int userRoleId;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	
}
