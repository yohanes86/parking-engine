package com.emobile.smis.webservice.logic.assignment.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountNotifAssignmentVisitExpired implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountNotifAssignmentVisitExpired.class);
	
	@Autowired
	private AssignmentBMMapper assignmentBMMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			AssignmentParamVO assignmentBMParamVO = mapper.readValue(data, AssignmentParamVO.class);	
			int countNotifAssignmentVisitExpired = assignmentBMMapper.countNotifAssignmentVisitExpired(assignmentBMParamVO);
			return mapper.writeValueAsString(countNotifAssignmentVisitExpired);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
