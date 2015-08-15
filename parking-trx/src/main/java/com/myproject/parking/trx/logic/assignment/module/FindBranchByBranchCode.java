package com.emobile.smis.webservice.logic.assignment.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindBranchByBranchCode implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindBranchByBranchCode.class);
	
	@Autowired
	private AssignmentBMMapper assignmentBMMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {				
			String branchCode = mapper.readValue(data, String.class);
			Branch branch = assignmentBMMapper.findBranchByBranchCode(branchCode);
			return mapper.writeValueAsString(branch);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
