package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.entity.AppsSetting;

public interface AppsSettingMapper {
	public List<AppsSetting> findAppsSettingAll();
	
	public int updateAppsSetting(AppsSetting setting);
}
