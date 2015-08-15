package com.emobile.smis.webservice.logic.target.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.AssignmentVO;
import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.entity.UserData;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.web.mapper.TargetCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindUserCMOByBranchCode implements SmisBaseQueryLogic{
	private static final Logger LOG = LoggerFactory.getLogger(FindUserCMOByBranchCode.class);
	
	@Autowired
	private TargetCMOMapper targetCMOMapper;
	
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			String branchCode = mapper.readValue(data, String.class);	
			List<UserData> listUserCMO = targetCMOMapper.findUserCMOByBranchCode(branchCode);
			return mapper.writeValueAsString(listUserCMO);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
//	@Override
//	@Transactional(readOnly=true)
//	public String process(String data, ObjectMapper mapper, String pathInfo) {
//		LOG.debug("Start process Query :"+pathInfo);		
//		try {				
//			int branchId = mapper.readValue(data, Integer.class);
//			UserData userData = assignmentBMMapper.findAssignedUserBMByBranchId(branchId);
//			return mapper.writeValueAsString(userData);
//		} catch (Exception e) {
//			// TODO: handle exception
//			LOG.warn("Unexpected exception when processing " + pathInfo, e);
//			return null;
//		}
//	}
}
