package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VisitBmVehicleStock implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	private int id;		//[id] Int IDENTITY NOT NULL,
	private int visitId;	//[visit_id] Int NOT NULL,
	private int merk;	//[car_merk] Int NULL,
	private int umurKendaraan;	//[life_of_vehicle] Int NULL,
	private int otr;	//[OTR] Int NULL,
	private int totalVehicle;	//[total_vehicle] Int NULL,
	private int value;
	private String description;
	
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
	public int getOtr() {
		return otr;
	}
	public void setOtr(int otr) {
		this.otr = otr;
	}
	public int getTotalVehicle() {
		return totalVehicle;
	}
	public void setTotalVehicle(int totalVehicle) {
		this.totalVehicle = totalVehicle;
	}
	public int getMerk() {
		return merk;
	}
	public void setMerk(int merk) {
		this.merk = merk;
	}
	public int getUmurKendaraan() {
		return umurKendaraan;
	}
	public void setUmurKendaraan(int umurKendaraan) {
		this.umurKendaraan = umurKendaraan;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
