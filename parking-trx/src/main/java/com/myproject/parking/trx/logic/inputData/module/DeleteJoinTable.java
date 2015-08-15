package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.mapper.JoinTableMapper;
import com.emobile.smis.web.utils.SmisConstants;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class DeleteJoinTable implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(DeleteJoinTable.class);
	
	@Autowired
	private JoinTableMapper joinTableMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query : "+pathInfo);		
		try {
			String joinId = mapper.readValue(data, String.class);	
			joinTableMapper.deleteJoinTable(joinId);
			return mapper.writeValueAsString(SmisConstants.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
