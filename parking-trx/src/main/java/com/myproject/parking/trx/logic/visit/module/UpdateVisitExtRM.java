package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.web.utils.SmisConstants;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class UpdateVisitExtRM implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(UpdateVisitExtRM.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ExtVisitRM visitRm = mapper.readValue(data, ExtVisitRM.class);	
			visitMapper.updateVisitCommons(visitRm);
			return mapper.writeValueAsString(SmisConstants.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
