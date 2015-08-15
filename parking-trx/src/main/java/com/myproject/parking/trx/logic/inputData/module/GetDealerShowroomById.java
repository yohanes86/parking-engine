package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.mapper.DealerShowroomMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class GetDealerShowroomById implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(GetDealerShowroomById.class);
	
	@Autowired
	private DealerShowroomMapper dealerShowroomMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		try {
			ParamQueryVO params = mapper.readValue(data, ParamQueryVO.class);
			//param int 1 = dealerId, param int 2 = status
			DealerShowroom dealerShowroom = dealerShowroomMapper.getDealerShowroomById(params.getParamInt1(), params.getParamInt2());
			return mapper.writeValueAsString(dealerShowroom);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}