package com.emobile.smis.webservice.logic.assignment.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.Assignment;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.web.utils.SmisConstants;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class UpdateAssignment implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(UpdateAssignment.class);
	
	@Autowired
	private AssignmentBMMapper assignmentBMMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			Assignment assignment = mapper.readValue(data, Assignment.class);	
			assignmentBMMapper.updateAssignment(assignment);
			return mapper.writeValueAsString(SmisConstants.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
