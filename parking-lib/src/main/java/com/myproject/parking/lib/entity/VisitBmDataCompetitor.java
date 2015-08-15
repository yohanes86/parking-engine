package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VisitBmDataCompetitor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	private int id;		//[id] Int IDENTITY NOT NULL,
	private int visitId; 	//[visit_id] Int NOT NULL,
	private int otherMultifinanceId;	//[other_multifinance_id] Int NULL,
	private String total;	//[total] float(53) NULL,
	private String interestRate;	//[interest_rate] float(53) NULL,
	private String provisi;		//[provisi] float(53) NULL,
	private String refundInsurance;		//[refund_insurance] float(53) NULL,
	private String refundRate;	//[refund_rate] float(53) NULL,
	private String competitorProgram;	//[competitor_program] Varchar(100) NULL,

	
	//untuk simpen nama dan code other multifinance
	private String otherMultifinanceName;
	private String otherMultifinanceCode;
	
	public String getOtherMultifinanceName() {
		return otherMultifinanceName;
	}
	public void setOtherMultifinanceName(String otherMultifinanceName) {
		this.otherMultifinanceName = otherMultifinanceName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public int getOtherMultifinanceId() {
		return otherMultifinanceId;
	}
	public void setOtherMultifinanceId(int otherMultifinanceId) {
		this.otherMultifinanceId = otherMultifinanceId;
	}
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getProvisi() {
		return provisi;
	}
	public void setProvisi(String provisi) {
		this.provisi = provisi;
	}
	public String getRefundInsurance() {
		return refundInsurance;
	}
	public void setRefundInsurance(String refundInsurance) {
		this.refundInsurance = refundInsurance;
	}
	public String getRefundRate() {
		return refundRate;
	}
	public void setRefundRate(String refundRate) {
		this.refundRate = refundRate;
	}
	public String getCompetitorProgram() {
		return competitorProgram;
	}
	public void setCompetitorProgram(String competitorProgram) {
		this.competitorProgram = competitorProgram;
	}
	public String getOtherMultifinanceCode() {
		return otherMultifinanceCode;
	}
	public void setOtherMultifinanceCode(String otherMultifinanceCode) {
		this.otherMultifinanceCode = otherMultifinanceCode;
	}

}
