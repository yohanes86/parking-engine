package com.emobile.smis.web.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ChangePassHistory {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId;
	private String oldPass1;
	private String oldPass2;
	private String oldPass3;
	private String oldPass4;
	private String oldPass5;
	private String oldPass6;
	private String oldPass7;
	private String oldPass8;
	private String oldPass9;
	private String oldPass10;
	private String oldPass11;
	private String oldPass12;
	private String oldPass13;
	private String oldPass14;
	private String oldPass15;
	private String oldPass16;
	private Date updatedOn;
	private int updatedBy;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOldPass1() {
		return oldPass1;
	}
	public void setOldPass1(String oldPass1) {
		this.oldPass1 = oldPass1;
	}
	public String getOldPass2() {
		return oldPass2;
	}
	public void setOldPass2(String oldPass2) {
		this.oldPass2 = oldPass2;
	}
	public String getOldPass3() {
		return oldPass3;
	}
	public void setOldPass3(String oldPass3) {
		this.oldPass3 = oldPass3;
	}
	public String getOldPass4() {
		return oldPass4;
	}
	public void setOldPass4(String oldPass4) {
		this.oldPass4 = oldPass4;
	}
	public String getOldPass5() {
		return oldPass5;
	}
	public void setOldPass5(String oldPass5) {
		this.oldPass5 = oldPass5;
	}
	public String getOldPass6() {
		return oldPass6;
	}
	public void setOldPass6(String oldPass6) {
		this.oldPass6 = oldPass6;
	}
	public String getOldPass7() {
		return oldPass7;
	}
	public void setOldPass7(String oldPass7) {
		this.oldPass7 = oldPass7;
	}
	public String getOldPass8() {
		return oldPass8;
	}
	public void setOldPass8(String oldPass8) {
		this.oldPass8 = oldPass8;
	}
	public String getOldPass9() {
		return oldPass9;
	}
	public void setOldPass9(String oldPass9) {
		this.oldPass9 = oldPass9;
	}
	public String getOldPass10() {
		return oldPass10;
	}
	public void setOldPass10(String oldPass10) {
		this.oldPass10 = oldPass10;
	}
	public String getOldPass11() {
		return oldPass11;
	}
	public void setOldPass11(String oldPass11) {
		this.oldPass11 = oldPass11;
	}
	public String getOldPass12() {
		return oldPass12;
	}
	public void setOldPass12(String oldPass12) {
		this.oldPass12 = oldPass12;
	}
	public String getOldPass13() {
		return oldPass13;
	}
	public void setOldPass13(String oldPass13) {
		this.oldPass13 = oldPass13;
	}
	public String getOldPass14() {
		return oldPass14;
	}
	public void setOldPass14(String oldPass14) {
		this.oldPass14 = oldPass14;
	}
	public String getOldPass15() {
		return oldPass15;
	}
	public void setOldPass15(String oldPass15) {
		this.oldPass15 = oldPass15;
	}
	public String getOldPass16() {
		return oldPass16;
	}
	public void setOldPass16(String oldPass16) {
		this.oldPass16 = oldPass16;
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
	
	public String[] getAllOldPass(){
		return new String[]{oldPass1, oldPass2, oldPass3, oldPass4, oldPass5,
				oldPass6, oldPass7, oldPass8, oldPass9, oldPass10,
				oldPass11, oldPass12, oldPass13, oldPass14, oldPass15, oldPass16};
	}
	
}
