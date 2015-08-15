package com.emobile.smis.web.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AppsSetting implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int settingId;  // id Int NOT NULL,
	private String settingName;  // setting_name Varchar(32),
	private String valueType;  // value_type Varchar(16),
	private String settingValue;  // setting_value Varchar(255)
	
	public int getSettingId() {
		return settingId;
	}
	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}
	public String getSettingName() {
		return settingName;
	}
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getSettingValue() {
		return settingValue;
	}
	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
