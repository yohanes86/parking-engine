package com.emobile.smis.webservice.logic.target.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.TargetCMODataVO;
import com.emobile.smis.web.data.param.TargetCMOParamVO;
import com.emobile.smis.web.mapper.TargetCMOMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindListTargetCMOByParamVO implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindListTargetCMOByParamVO.class);
	
	@Autowired
	private TargetCMOMapper targetCMOMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query : "+pathInfo);		
		try {
			TargetCMOParamVO targetCMOParamVO = mapper.readValue(data, TargetCMOParamVO.class);	
			List<TargetCMODataVO> listTargetCMO = targetCMOMapper.findListTargetCMOByParamVO(targetCMOParamVO);
			return mapper.writeValueAsString(listTargetCMO);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
