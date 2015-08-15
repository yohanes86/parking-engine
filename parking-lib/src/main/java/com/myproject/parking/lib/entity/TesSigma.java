package com.emobile.smis.web.entity;


public class TesSigma implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String sigmaId;
	private String nameSigma;
	private String addressSigma;
	private String branchSigma;
	private int productId;
	private String productName;
	
	public String getSigmaId() {
		return sigmaId;
	}
	public void setSigmaId(String sigmaId) {
		this.sigmaId = sigmaId;
	}
	public String getNameSigma() {
		return nameSigma;
	}
	public void setNameSigma(String nameSigma) {
		this.nameSigma = nameSigma;
	}
	public String getAddressSigma() {
		return addressSigma;
	}
	public void setAddressSigma(String addressSigma) {
		this.addressSigma = addressSigma;
	}
	public String getBranchSigma() {
		return branchSigma;
	}
	public void setBranchSigma(String branchSigma) {
		this.branchSigma = branchSigma;
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
