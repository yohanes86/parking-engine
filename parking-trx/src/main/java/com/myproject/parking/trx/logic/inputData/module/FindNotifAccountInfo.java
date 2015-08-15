package com.emobile.smis.webservice.logic.inputData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.AccountInfoVO;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.mapper.AccountInfoMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindNotifAccountInfo implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindNotifAccountInfo.class);
	
	@Autowired
	private AccountInfoMapper accountInfoMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ParamQueryVO params = mapper.readValue(data, ParamQueryVO.class);	
			List<AccountInfoVO> listNotifAccInfo = accountInfoMapper.findNotifAccInfo(params);
			return mapper.writeValueAsString(listNotifAccInfo);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}