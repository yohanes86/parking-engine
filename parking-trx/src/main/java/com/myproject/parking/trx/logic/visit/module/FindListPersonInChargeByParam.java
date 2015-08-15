package com.emobile.smis.webservice.logic.visit.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.UserDataVO;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.mapper.PersonInChargeMapper;
import com.emobile.smis.web.mapper.UserDataMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindListPersonInChargeByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindListPersonInChargeByParam.class);
	
	@Autowired
	private PersonInChargeMapper picMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			PersonInCharge param = mapper.readValue(data, PersonInCharge.class);	
			List<PersonInCharge> pic = picMapper.findListPersonInChargeByParam(param);
			return mapper.writeValueAsString(pic);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
