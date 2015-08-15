package com.emobile.smis.webservice.logic.report.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.UserDataVO;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.mapper.ReportMapper;
import com.emobile.smis.web.mapper.UserDataMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindBranchByRegionIdAndUserId implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindBranchByRegionIdAndUserId.class);
	
	@Autowired
	private ReportMapper reportMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ParamQueryVO params = mapper.readValue(data, ParamQueryVO.class);	
			List<Branch> listBranch= reportMapper.findBranchByRegionIdAndUserId(params.getParamInt1(), params.getParamInt2());
			return mapper.writeValueAsString(listBranch);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
