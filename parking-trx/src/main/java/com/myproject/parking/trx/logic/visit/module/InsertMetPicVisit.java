package com.emobile.smis.webservice.logic.visit.module;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.entity.Visit;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class InsertMetPicVisit implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(InsertMetPicVisit.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Integer> params = mapper.readValue(data, Map.class);
			int visitId = params.get("visitId");
			int picId = params.get("picId");
			PersonInCharge pic = visitMapper.insertMetPicVisit(visitId, picId);
			return mapper.writeValueAsString(pic);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}	
	}
	
}
