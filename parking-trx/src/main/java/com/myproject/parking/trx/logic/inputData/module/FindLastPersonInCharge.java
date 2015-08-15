package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.mapper.PersonInChargeMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindLastPersonInCharge implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindLastPersonInCharge.class);
	
	@Autowired
	private PersonInChargeMapper picMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		try {
			PersonInCharge pic = picMapper.findLastPersonInCharge();
			return mapper.writeValueAsString(pic);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}