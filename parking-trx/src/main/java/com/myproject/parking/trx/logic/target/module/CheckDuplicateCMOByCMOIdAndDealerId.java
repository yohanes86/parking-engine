package com.emobile.smis.webservice.logic.target.module;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.TargetCMOParamVO;
import com.emobile.smis.web.entity.TargetCMOHeader;
import com.emobile.smis.web.mapper.TargetCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CheckDuplicateCMOByCMOIdAndDealerId implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CheckDuplicateCMOByCMOIdAndDealerId.class);
	
	@Autowired
	private TargetCMOMapper targetCMOMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		
		try {
			TargetCMOParamVO paramVO = mapper.readValue(data, TargetCMOParamVO.class);
			TargetCMOHeader target = targetCMOMapper.checkDuplicateTargetCMOByCMOIdAndDealerId(paramVO);
			return mapper.writeValueAsString(target);
			
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}	
	}

}
