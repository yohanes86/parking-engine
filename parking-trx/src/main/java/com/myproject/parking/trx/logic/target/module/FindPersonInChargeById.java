package com.emobile.smis.webservice.logic.target.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.mapper.PersonInChargeMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindPersonInChargeById implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindPersonInChargeById.class);
	
	@Autowired
	private PersonInChargeMapper personInChargeMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query : "+pathInfo);		
		try {
			PersonInCharge param = mapper.readValue(data, PersonInCharge.class);	
			PersonInCharge personInCharge = personInChargeMapper.findPersonInChargeById(param);
//			int personInChargeId = mapper.readValue(data, Integer.class);
//			PersonInCharge personInCharge = personInChargeMapper.findPersonInChargeById(personInChargeId);
			return mapper.writeValueAsString(personInCharge);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
