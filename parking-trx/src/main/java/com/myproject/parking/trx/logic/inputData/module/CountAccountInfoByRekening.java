package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.mapper.AccountInfoMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CountAccountInfoByRekening implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CountAccountInfoByRekening.class);
	
	@Autowired
	private AccountInfoMapper accountInfoMapper;
		
	@Override
	@Transactional(readOnly = true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ParamQueryVO params = mapper.readValue(data, ParamQueryVO.class);	
			int countNotifAccInfo = accountInfoMapper.countAccInfoWithRekening(params);
			return mapper.writeValueAsString(countNotifAccInfo);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
