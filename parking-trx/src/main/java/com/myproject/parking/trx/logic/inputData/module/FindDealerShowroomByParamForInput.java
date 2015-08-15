package com.emobile.smis.webservice.logic.inputData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.entity.CarBranchDealer;
import com.emobile.smis.web.fincore.mapper.CarBranchDealerMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindDealerShowroomByParamForInput implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindDealerShowroomByParamForInput.class);
	
	@Autowired
	private CarBranchDealerMapper carBranchDealerMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			DealerShowroomParamVO dealerShowroomParamVO = mapper.readValue(data, DealerShowroomParamVO.class);
			List<CarBranchDealer> listCarBranchDealer = carBranchDealerMapper.findDealerShowroomByParamForInput(dealerShowroomParamVO);
			return mapper.writeValueAsString(listCarBranchDealer);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}