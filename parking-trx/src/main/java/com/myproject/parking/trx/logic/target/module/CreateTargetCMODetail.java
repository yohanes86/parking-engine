package com.emobile.smis.webservice.logic.target.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.TargetCMODetail;
import com.emobile.smis.web.entity.TargetCMOHeader;
import com.emobile.smis.web.mapper.TargetCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CreateTargetCMODetail implements SmisBaseQueryLogic{
	private static final Logger LOG = LoggerFactory.getLogger(CreateTargetCMODetail.class);
	
	@Autowired
	private TargetCMOMapper targetCMOMapper;
	
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query : "+pathInfo);		
		TargetCMODetail targetCMODetail = new TargetCMODetail();
		try {
			targetCMODetail = mapper.readValue(data, TargetCMODetail.class);
			targetCMOMapper.createTargetCMODetail(targetCMODetail);
//			return SmisConstants.SUCCESS_CODE;
			return mapper.writeValueAsString(targetCMODetail);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}


}
