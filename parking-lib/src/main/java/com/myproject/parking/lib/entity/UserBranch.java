package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserBranch implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int branchId;
	
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

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
}
