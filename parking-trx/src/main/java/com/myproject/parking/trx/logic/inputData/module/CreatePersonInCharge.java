package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.PersonInChargeVO;
import com.emobile.smis.web.mapper.PersonInChargeMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CreatePersonInCharge implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CreatePersonInCharge.class);
	
	@Autowired
	private PersonInChargeMapper personInChargeMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query findUserDataByUserCode ");
		try {
			PersonInChargeVO personInCharge = mapper.readValue(data, PersonInChargeVO.class);	
			personInChargeMapper.createPersonInCharge(personInCharge);
			return mapper.writeValueAsString(personInCharge);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}