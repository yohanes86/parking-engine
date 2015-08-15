package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.DealerShowroomNotRegister;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class InsertDealerShowroomNotRegister implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(InsertDealerShowroomNotRegister.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		
		try {
			DealerShowroomNotRegister dealerShowroomNotRegis = mapper.readValue(data, DealerShowroomNotRegister.class);	
			dealerShowroomMapper.insertDealerShowroomNotRegister(dealerShowroomNotRegis);
			return mapper.writeValueAsString(dealerShowroomNotRegis);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}	
	}
	
}
