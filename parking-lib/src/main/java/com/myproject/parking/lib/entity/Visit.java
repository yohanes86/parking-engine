package com.emobile.smis.web.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.emobile.smis.web.data.param.ParamPagingVO;

public class Visit extends ParamPagingVO {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date datetimeVisit;	
	private int dealerShowroomId;	
	private int dealerShowroomHistory;	
	private Date historyDate;
	private int visitType;
	private int duration;
	private int createdBy;
	private Date createdOn;
	private int updatedBy;
	private Date updatedOn;
	
	//additional
	private String joinId;
	private String dealerShowroomIdSigma;
	private String dealerShowroomName;
	private String dealerShowroomAddress;	
	private String branchName;
	private String dealerShowroomHistoryDesc;	
	private String statusDealer;
	
	//for search visit
	private Date dateFrom;
	private Date dateTo;
	private String branchCode;

	//show name
	private String createdByDisplay;
	
	private List<Integer> listBranch;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Date getDatetimeVisit() {
		return datetimeVisit;
	}
	public void setDatetimeVisit(Date datetimeVisit) {
		this.datetimeVisit = datetimeVisit;
	}
	public int getDealerShowroomId() {
		return dealerShowroomId;
	}
	public void setDealerShowroomId(int dealerShowroomId) {
		this.dealerShowroomId = dealerShowroomId;
	}
	public String getDealerShowroomName() {
		return dealerShowroomName;
	}
	public void setDealerShowroomName(String dealerShowroomName) {
		this.dealerShowroomName = dealerShowroomName;
	}
	public String getDealerShowroomAddress() {
		return dealerShowroomAddress;
	}
	public void setDealerShowroomAddress(String dealerShowroomAddress) {
		this.dealerShowroomAddress = dealerShowroomAddress;
	}
	public int getDealerShowroomHistory() {
		return dealerShowroomHistory;
	}
	public void setDealerShowroomHistory(int dealerShowroomHistory) {
		this.dealerShowroomHistory = dealerShowroomHistory;
	}		
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getJoinId() {
		return joinId;
	}
	public void setJoinId(String joinId) {
		this.joinId = joinId;
	}
	@Override
	protected String getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAliasTable() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDealerShowroomIdSigma() {
		return dealerShowroomIdSigma;
	}
	public void setDealerShowroomIdSigma(String dealerShowroomIdSigma) {
		this.dealerShowroomIdSigma = dealerShowroomIdSigma;
	}
	public Date getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}
	public String getDealerShowroomHistoryDesc() {
		return dealerShowroomHistoryDesc;
	}
	public void setDealerShowroomHistoryDesc(String dealerShowroomHistoryDesc) {
		this.dealerShowroomHistoryDesc = dealerShowroomHistoryDesc;
	}
	public String getStatusDealer() {
		return statusDealer;
	}
	public void setStatusDealer(String statusDealer) {
		this.statusDealer = statusDealer;
	}
	public int getVisitType() {
		return visitType;
	}
	public void setVisitType(int visitType) {
		this.visitType = visitType;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCreatedByDisplay() {
		return createdByDisplay;
	}
	public void setCreatedByDisplay(String createdByDisplay) {
		this.createdByDisplay = createdByDisplay;
	}
	public List<Integer> getListBranch() {
		return listBranch;
	}
	public void setListBranch(List<Integer> listBranch) {
		this.listBranch = listBranch;
	}
		
}
