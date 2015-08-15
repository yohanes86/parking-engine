package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountNotifDSNeedUpdated implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountNotifDSNeedUpdated.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			DealerShowroomParamVO params = mapper.readValue(data, DealerShowroomParamVO.class);	
			int countNotifNeedUpdatedDS = dealerShowroomMapper.countNotifDealerShowroomNeedUpdated(params);
			return mapper.writeValueAsString(countNotifNeedUpdatedDS);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
