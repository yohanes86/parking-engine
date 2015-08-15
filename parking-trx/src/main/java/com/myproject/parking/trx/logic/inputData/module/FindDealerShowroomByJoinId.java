package com.emobile.smis.webservice.logic.inputData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.JoinTable;
import com.emobile.smis.web.mapper.JoinTableMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindDealerShowroomByJoinId implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindDealerShowroomByJoinId.class);
	
	@Autowired
	private JoinTableMapper joinTableMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			String joinId = mapper.readValue(data, String.class);	
			List<JoinTable> listJoinTable = joinTableMapper.findDealerShowroomByJoinId(joinId);
			return mapper.writeValueAsString(listJoinTable);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}