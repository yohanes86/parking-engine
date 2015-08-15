package com.emobile.smis.webservice.logic.report.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.mapper.ReportMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountReportUnassignBmByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountReportUnassignBmByParam.class);
	
	@Autowired
	private ReportMapper reportMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ReportParamVO paramVO = mapper.readValue(data, ReportParamVO.class);	
			int countUnassign = reportMapper.countReportUnassign(paramVO);
			return mapper.writeValueAsString(countUnassign);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}


}
