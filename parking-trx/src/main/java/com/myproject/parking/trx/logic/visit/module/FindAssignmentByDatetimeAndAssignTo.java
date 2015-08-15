package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.entity.Assignment;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindAssignmentByDatetimeAndAssignTo implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindAssignmentByDatetimeAndAssignTo.class);
		
	@Autowired
	private AssignmentBMMapper assignmentBMMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			AssignmentParamVO assignmentParamVO = mapper.readValue(data, AssignmentParamVO.class);	
			Assignment assignment = assignmentBMMapper.findAssignmentByDatetimeAndAssignTo(assignmentParamVO);
			return mapper.writeValueAsString(assignment);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	

}
