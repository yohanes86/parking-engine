package com.emobile.smis.webservice.logic.assignment.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.AssignmentVO;
import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindAssignmentBMByParamVO implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindAssignmentBMByParamVO.class);
	
	@Autowired
	private AssignmentBMMapper assignmentBMMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			AssignmentParamVO assignmentBMParamVO = mapper.readValue(data, AssignmentParamVO.class);	
			List<AssignmentVO> listAssignmentBM = assignmentBMMapper.findAssignmentBMByParamVO(assignmentBMParamVO);
			return mapper.writeValueAsString(listAssignmentBM);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
