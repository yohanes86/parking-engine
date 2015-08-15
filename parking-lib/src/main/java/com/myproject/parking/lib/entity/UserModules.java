package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserModules implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int moduleLevel;
	private String moduleName;
	private String modulePath;
	private String moduleDesc;
	private String moduleGroup;
	private int showOrder;
	private boolean moduleLeaf;
	private int moduleParentId;
	private int moduleRootId;
	private boolean alwaysIncluded;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getModuleLevel() {
		return moduleLevel;
	}
	public void setModuleLevel(int moduleLevel) {
		this.moduleLevel = moduleLevel;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getModulePath() {
		return modulePath;
	}
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}
	
	public String getModuleDesc() {
		return moduleDesc;
	}
	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}
	
	public String getModuleGroup() {
		return moduleGroup;
	}
	public void setModuleGroup(String moduleGroup) {
		this.moduleGroup = moduleGroup;
	}
	
	public int getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}
	
	public boolean getModuleLeaf() {
		return moduleLeaf;
	}
	public void setModuleLeaf(boolean moduleLeaf) {
		this.moduleLeaf = moduleLeaf;
	}
	
	public int getModuleParentId() {
		return moduleParentId;
	}
	public void setModuleParentId(int moduleParentId) {
		this.moduleParentId = moduleParentId;
	}
	
	public int getModuleRootId() {
		return moduleRootId;
	}
	public void setModuleRootId(int moduleRootId) {
		this.moduleRootId = moduleRootId;
	}
	
	public boolean getAlwaysIncluded() {
		return alwaysIncluded;
	}
	public void setAlwaysIncluded(boolean alwaysIncluded) {
		this.alwaysIncluded = alwaysIncluded;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
