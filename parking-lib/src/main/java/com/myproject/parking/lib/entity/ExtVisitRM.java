package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ExtVisitRM extends Visit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idExt;
	private int visitId;
	private int bmInCharge;
	private int clusterDealerShowroom;
	private String reasonOfVisit;
	private String resultOfVisit;
	private String workPlan;
	
	private String bmInChargeName;
	private String clusterDealerDesc;
	
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public int getIdExt() {
		return idExt;
	}


	public void setIdExt(int idExt) {
		this.idExt = idExt;
	}


	public int getVisitId() {
		return visitId;
	}


	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}


	public String getReasonOfVisit() {
		return reasonOfVisit;
	}


	public void setReasonOfVisit(String reasonOfVisit) {
		this.reasonOfVisit = reasonOfVisit;
	}


	public String getResultOfVisit() {
		return resultOfVisit;
	}


	public void setResultOfVisit(String resultOfVisit) {
		this.resultOfVisit = resultOfVisit;
	}


	public String getWorkPlan() {
		return workPlan;
	}


	public void setWorkPlan(String workPlan) {
		this.workPlan = workPlan;
	}


	public int getBmInCharge() {
		return bmInCharge;
	}


	public void setBmInCharge(int bmInCharge) {
		this.bmInCharge = bmInCharge;
	}


	public int getClusterDealerShowroom() {
		return clusterDealerShowroom;
	}


	public void setClusterDealerShowroom(int clusterDealerShowroom) {
		this.clusterDealerShowroom = clusterDealerShowroom;
	}


	public String getBmInChargeName() {
		return bmInChargeName;
	}


	public void setBmInChargeName(String bmInChargeName) {
		this.bmInChargeName = bmInChargeName;
	}


	public String getClusterDealerDesc() {
		return clusterDealerDesc;
	}


	public void setClusterDealerDesc(String clusterDealerDesc) {
		this.clusterDealerDesc = clusterDealerDesc;
	}
			
}
