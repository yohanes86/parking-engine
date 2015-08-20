package com.myproject.parking.lib.data;

import id.co.veritrans.mdk.v1.gateway.model.TransactionItem;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class VeriTransVO extends LoginData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tokenId;
	private String price;
	
	private CustomerDetail customerDetail;
	private TransactionDetails transactionDetails;
	private List<Product> listProducts;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
}
