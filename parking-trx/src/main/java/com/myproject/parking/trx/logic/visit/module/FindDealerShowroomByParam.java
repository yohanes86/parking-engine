package com.emobile.smis.webservice.logic.visit.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.entity.Visit;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindDealerShowroomByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindDealerShowroomByParam.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			Visit visit = mapper.readValue(data, Visit.class);	
			List<DealerShowroom> listDealerShowroom = dealerShowroomMapper.findDealerShowroomByParam(visit);
			return mapper.writeValueAsString(listDealerShowroom);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
