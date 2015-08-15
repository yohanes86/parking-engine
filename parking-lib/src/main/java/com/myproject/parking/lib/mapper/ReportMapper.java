package com.emobile.smis.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.data.report.ReportDataCompetitorInDealerVO;
import com.emobile.smis.web.data.report.ReportSalesPotentionVO;
import com.emobile.smis.web.data.report.ReportUnassignBmVO;
import com.emobile.smis.web.data.report.ReportUnassignCmoVO;
import com.emobile.smis.web.data.report.ReportUnvisitBmVO;
import com.emobile.smis.web.data.report.ReportUnvisitCmoVO;
import com.emobile.smis.web.data.report.ReportUnvisitRmVO;
import com.emobile.smis.web.data.report.ReportVisitBmVO;
import com.emobile.smis.web.data.report.ReportVisitCmoVO;
import com.emobile.smis.web.data.report.ReportVisitRmVO;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.entity.Region;

public interface ReportMapper {

	public List<Region> findRegionSmis();
	
	public List<Region> findRegionSmisByUserId(int userId);
	
	public List<Branch> findBranchByRegionIdAndUserId(@Param("regionId") int regionId, @Param("userId") int userId);
	
	public List<ReportVisitRmVO> findReportVisitRmByParam(ReportParamVO paramVO);
	
	public int countReportVisitRmByParam(ReportParamVO paramVO);
	
	public List<ReportVisitBmVO> findReportVisitBmByParam(ReportParamVO paramVO);
	
	public int countReportVisitBmByParam(ReportParamVO paramVO);
	
	public List<ReportVisitCmoVO> findReportVisitCmoByParam(ReportParamVO paramVO);
	
	public int countReportVisitCmoByParam(ReportParamVO paramVO);

	public List<ReportUnvisitRmVO> findReportUnvisitRm(ReportParamVO paramVO);
	
	public int countReportUnvisitRm(ReportParamVO paramVO);
	
	public List<ReportUnvisitBmVO> findReportUnvisitBm(ReportParamVO paramVO);
	
	public int countReportUnvisitBm(ReportParamVO paramVO);
	
	public List<ReportUnvisitCmoVO> findReportUnvisitCmo(ReportParamVO paramVO);
	
	public int countReportUnvisitCmo(ReportParamVO paramVO);
	
	public List<ReportUnassignCmoVO> findReportUnassign(ReportParamVO paramVO);
	
	public int countReportUnassign(ReportParamVO paramVO);
	
	public List<ReportSalesPotentionVO> findReportSalesPotentionByParam(ReportParamVO paramVO);
	
	public int countReportSalesPontentionByParam(ReportParamVO paramVO);
	
	public int countReportDataCompetitorByParam(ReportParamVO paramVO);
	
	public List<ReportDataCompetitorInDealerVO> findReportDataCompetitorByParam(ReportParamVO paramVO);
}
