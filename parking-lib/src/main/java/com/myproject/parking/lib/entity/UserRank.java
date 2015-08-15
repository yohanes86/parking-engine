package com.emobile.smis.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserRank implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String rankName;
	private String rankDesc;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private int updatedBy;
	private List<UserModules> modules;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public String getRankDesc() {
		return rankDesc;
	}
	public void setRankDesc(String rankDesc) {
		this.rankDesc = rankDesc;
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
	public List<UserModules> getModules() {
		return modules;
	}
	public void setModules(List<UserModules> modules) {
		this.modules = modules;
	}
	public void addModule(UserModules module) {
		if (module == null || module.getId() == 0) {
		    return;
		}
		if (modules == null) {
		    modules = new ArrayList<UserModules>();
		}
		if (!modules.contains(module)) {
		    modules.add(module);
		}
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
