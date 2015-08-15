package com.emobile.smis.webservice.logic.inputData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.TesSigma;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindAllDealaerShowroom implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindAllDealaerShowroom.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			List<TesSigma> listDealerShowroom = dealerShowroomMapper.findAllDealaerShowroom();
			return mapper.writeValueAsString(listDealerShowroom);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}