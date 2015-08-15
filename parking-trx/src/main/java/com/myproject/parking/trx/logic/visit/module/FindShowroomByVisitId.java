package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.ShowroomPerformance;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindShowroomByVisitId implements SmisBaseQueryLogic{
	private static final Logger LOG = LoggerFactory.getLogger(FindShowroomByVisitId.class);

	@Autowired
	private VisitMapper visitMapper;
	
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			int visitId = mapper.readValue(data, Integer.class);
			ShowroomPerformance showroomPerformance = visitMapper.findShowroomByVisitId(visitId);
			return mapper.writeValueAsString(showroomPerformance);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
