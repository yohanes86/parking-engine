package com.emobile.smis.webservice.logic.masterData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.MultifinanceOthers;
import com.emobile.smis.web.mapper.MultifinanceOthersMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindLastMultifinanceOthers implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindLastMultifinanceOthers.class);
	
	@Autowired
	private MultifinanceOthersMapper multifinanceOthersMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		try {
			MultifinanceOthers multifinanceOthers = multifinanceOthersMapper.findLastMultifinanceOthers();
			return mapper.writeValueAsString(multifinanceOthers);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}