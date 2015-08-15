package com.emobile.smis.web.data.job;

import org.springframework.beans.factory.annotation.Autowired;

import com.emobile.smis.web.data.service.AppsTimeService;

public class SyncTimeJob {
	
	@Autowired
	private AppsTimeService timeService;
	
	public void syncTime() {
		timeService.updateCurrentTime();
	}
}
