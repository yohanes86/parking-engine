package com.emobile.smis.webservice.logic.target.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.TargetCMOParamVO;
import com.emobile.smis.web.mapper.TargetCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountTargetCMO implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountTargetCMO.class);
	
	@Autowired
	private TargetCMOMapper targetCMOMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query : "+pathInfo);		
		try {
			TargetCMOParamVO targetCMOParamVO = mapper.readValue(data, TargetCMOParamVO.class);	
			int countTargetCMO = targetCMOMapper.countTargetCMO(targetCMOParamVO);
			return mapper.writeValueAsString(countTargetCMO);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
