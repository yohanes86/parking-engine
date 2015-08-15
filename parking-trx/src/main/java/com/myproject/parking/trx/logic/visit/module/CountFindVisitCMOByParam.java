package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.Visit;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountFindVisitCMOByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountFindVisitCMOByParam.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			Visit visit = mapper.readValue(data, Visit.class);	
			int countVisit = visitMapper.countFindVisitCMOByParam(visit);
			return mapper.writeValueAsString(countVisit);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
