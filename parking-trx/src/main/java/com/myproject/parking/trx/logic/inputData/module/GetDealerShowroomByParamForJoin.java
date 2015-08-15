package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.fincore.mapper.CarBranchDealerMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class GetDealerShowroomByParamForJoin implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(GetDealerShowroomByParamForJoin.class);
	
	@Autowired
	private CarBranchDealerMapper carBranchDealerMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			DealerShowroomParamVO dealerShowroomParamVO = mapper.readValue(data, DealerShowroomParamVO.class);
			DealerShowroom dealerShowroom = carBranchDealerMapper.getDealerShowroomByParamForJoin(dealerShowroomParamVO);
			return mapper.writeValueAsString(dealerShowroom);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}