package com.emobile.smis.webservice.logic.assignment.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindDealerByBranchCode implements SmisBaseQueryLogic{
	private static final Logger LOG = LoggerFactory.getLogger(FindDealerByBranchCode.class);

//	@Autowired
//	private AssignmentBMMapper assignmentBMMapper;
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
	
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			String branchCode = mapper.readValue(data, String.class);
			List<DealerShowroom> listDealerShowroom = dealerShowroomMapper.findDealerByBranchCode(branchCode);
			return mapper.writeValueAsString(listDealerShowroom);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}
