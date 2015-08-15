package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VisitBmReportAdviceSales implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	 private int id;	//[id] Int IDENTITY NOT NULL,
	 private int visitId;	//[visit_id] Int NOT NULL,
	 
	 //Report
	 private int serviceLevelBcaf;	//[service_level_bcaf] Int NULL,
	 private int refundBcaf;	//[refund_bcaf] Int NULL,
	 private String promosi;	//[promosi] Int NULL,
	 private String rewardToDealer;	//[reward_to_dealer] Varchar(200) NULL,
	 private int porsiToBcaf;	//[porsi_to_bcaf] Int NULL,
	 private String barrierToBcaf;	//[barrier_to_bcaf] Varchar(50) NULL,
	 
	 
	 
	 //Advice
	 private String serviceBcaf;	//[service_bcaf] Varchar(100) NULL,
	 private String refundBcafAdvice;	//[refund_bcaf_advice] Varchar(100) NULL,
	 private String rewardToDealerAdvice;	//[reward_to_dealer_advice] Varchar(100) NULL,
	 private String strategi;	//[strategi] Varchar(200) NULL,
	 private String other;	//[other] Varchar(255) NULL,
	 
	 //Sales
	 private String cash;	//[cash] float(53) NULL,
	 private String credit;	//[credit] float(53) NULL,

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
	public int getServiceLevelBcaf() {
		return serviceLevelBcaf;
	}
	public void setServiceLevelBcaf(int serviceLevelBcaf) {
		this.serviceLevelBcaf = serviceLevelBcaf;
	}
	public int getRefundBcaf() {
		return refundBcaf;
	}
	public void setRefundBcaf(int refundBcaf) {
		this.refundBcaf = refundBcaf;
	}

	public String getPromosi() {
		return promosi;
	}
	public void setPromosi(String promosi) {
		this.promosi = promosi;
	}
	public String getRewardToDealer() {
		return rewardToDealer;
	}
	public void setRewardToDealer(String rewardToDealer) {
		this.rewardToDealer = rewardToDealer;
	}
	public int getPorsiToBcaf() {
		return porsiToBcaf;
	}
	public void setPorsiToBcaf(int porsiToBcaf) {
		this.porsiToBcaf = porsiToBcaf;
	}
	public String getBarrierToBcaf() {
		return barrierToBcaf;
	}
	public void setBarrierToBcaf(String barrierToBcaf) {
		this.barrierToBcaf = barrierToBcaf;
	}
	public String getServiceBcaf() {
		return serviceBcaf;
	}
	public void setServiceBcaf(String serviceBcaf) {
		this.serviceBcaf = serviceBcaf;
	}
	public String getRefundBcafAdvice() {
		return refundBcafAdvice;
	}
	public void setRefundBcafAdvice(String refundBcafAdvice) {
		this.refundBcafAdvice = refundBcafAdvice;
	}
	public String getRewardToDealerAdvice() {
		return rewardToDealerAdvice;
	}
	public void setRewardToDealerAdvice(String rewardToDealerAdvice) {
		this.rewardToDealerAdvice = rewardToDealerAdvice;
	}
	public String getStrategi() {
		return strategi;
	}
	public void setStrategi(String strategi) {
		this.strategi = strategi;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	 
	 
}
