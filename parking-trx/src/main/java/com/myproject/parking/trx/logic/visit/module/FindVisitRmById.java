package com.emobile.smis.webservice.logic.visit.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindVisitRmById implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindVisitRmById.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			int visitId = mapper.readValue(data, Integer.class);	
			ExtVisitRM visitRm = visitMapper.findVisitRmById(visitId);
			return mapper.writeValueAsString(visitRm);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
