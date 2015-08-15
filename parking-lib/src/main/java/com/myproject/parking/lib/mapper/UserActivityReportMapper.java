package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.report.UserActivityReportVO;

public interface UserActivityReportMapper {
	
	public List<UserActivityReportVO> findUserActivityReport(UserActivityReportVO userActivityReportVO);
}
