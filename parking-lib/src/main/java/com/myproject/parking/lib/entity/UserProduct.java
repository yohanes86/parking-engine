package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserProduct implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int productId;
	private String productName;
	
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
