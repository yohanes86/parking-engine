package com.emobile.smis.webservice.logic.masterData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.MultifinanceOthersParamVO;
import com.emobile.smis.web.entity.MultifinanceOthers;
import com.emobile.smis.web.mapper.MultifinanceOthersMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindMultifinanceOthersByParam implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindMultifinanceOthersByParam.class);
	
	@Autowired
	private MultifinanceOthersMapper multifinanceOthersMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			MultifinanceOthersParamVO multifinanceOthersParamVO = mapper.readValue(data, MultifinanceOthersParamVO.class);	
			List<MultifinanceOthers> listMultifinanceOthers = multifinanceOthersMapper.findMultifinanceOthersByParam(multifinanceOthersParamVO);
			return mapper.writeValueAsString(listMultifinanceOthers);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}