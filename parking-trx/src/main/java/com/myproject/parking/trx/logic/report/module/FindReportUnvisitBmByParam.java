package com.emobile.smis.webservice.logic.report.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.data.report.ReportUnvisitBmVO;
import com.emobile.smis.web.data.report.ReportUnvisitRmVO;
import com.emobile.smis.web.data.report.ReportVisitRmVO;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.mapper.ReportMapper;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindReportUnvisitBmByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindReportUnvisitBmByParam.class);
	
	@Autowired
	private ReportMapper reportMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ReportParamVO paramVO = mapper.readValue(data, ReportParamVO.class);	
			List<ReportUnvisitBmVO> listReportUnvisitBm = reportMapper.findReportUnvisitBm(paramVO);
			return mapper.writeValueAsString(listReportUnvisitBm);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
