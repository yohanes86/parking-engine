package com.emobile.smis.web.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.emobile.smis.web.utils.CommonUtil;

public class TargetCMOHeader implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int cmoId;
	private int dealerShowroomId; // id(int)/db SMIS
	private String monthAndYear;
	
	private double targetPhCMO;
	private String targetPhCMOStr;
	private int targetTotalUnitCMO;
		
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	
	/* for display */
	private String branchName; 
	private String cmoName;
	
	private List<TargetCMODetail> listTargetCMODetail ;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
//		return ReflectionToStringBuilder.toString(this);
	}
	
	public int getCmoId() {
		return cmoId;
	}
	public void setCmoId(int cmoId) {
		this.cmoId = cmoId;
	}

	public int getDealerShowroomId() {
		return dealerShowroomId;
	}
	public void setDealerShowroomId(int dealerShowroomId) {
		this.dealerShowroomId = dealerShowroomId;
	}
	

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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
	
	public List<TargetCMODetail> getListTargetCMODetail() {
		return listTargetCMODetail;
	}

	public void setListTargetCMODetail(List<TargetCMODetail> listTargetCMODetail) {
		this.listTargetCMODetail = listTargetCMODetail;
	}

	public int getTargetTotalUnitCMO() {
		return targetTotalUnitCMO;
	}

	public void setTargetTotalUnitCMO(int targetTotalUnitCMO) {
		this.targetTotalUnitCMO = targetTotalUnitCMO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTargetPhCMO() {
		return targetPhCMO;
	}

	public void setTargetPhCMO(double targetPhCMO) {
		this.targetPhCMO = targetPhCMO;
	}

	public String getTargetPhCMOStr() {
		if(targetPhCMO > 0 ){
			if(id == 0){
				targetPhCMOStr = CommonUtil.displayNumberPlain(targetPhCMO);
				targetPhCMO = 0;
			}else{
				targetPhCMOStr = CommonUtil.convertToLocalGermany(targetPhCMO);
				targetPhCMO = 0;
			}
			
		}
		return targetPhCMOStr;
	}

	public void setTargetPhCMOStr(String targetPhCMOStr) {
		this.targetPhCMOStr = targetPhCMOStr;
	}

	public String getCmoName() {
		return cmoName;
	}

	public void setCmoName(String cmoName) {
		this.cmoName = cmoName;
	}

	public String getMonthAndYear() {
		return monthAndYear;
	}

	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
}
