package com.emobile.smis.webservice.logic.assignment.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.mapper.AssignmentCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindPersonInChargeByDealerId implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindPersonInChargeByDealerId.class);
	
	@Autowired
	private AssignmentCMOMapper assignmentCMOMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			int dealerId = mapper.readValue(data, Integer.class);	
			List<PersonInCharge> listPersonInCharge = assignmentCMOMapper.findPersonInChargeByDealerId(dealerId);
			return mapper.writeValueAsString(listPersonInCharge);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
