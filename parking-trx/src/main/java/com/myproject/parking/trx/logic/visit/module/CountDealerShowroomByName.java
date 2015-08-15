package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.UserDataVO;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.web.mapper.UserDataMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountDealerShowroomByName implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountDealerShowroomByName.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			String name = mapper.readValue(data, String.class);	
			int countDealerShowroom = dealerShowroomMapper.countDealerShowroomByName(name);
			return mapper.writeValueAsString(countDealerShowroom);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
