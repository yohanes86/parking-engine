package com.emobile.smis.webservice.logic.inputData.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.JoinTable;
import com.emobile.smis.web.mapper.JoinTableMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class CreateJoinTable implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(CreateJoinTable.class);
	
	@Autowired
	private JoinTableMapper joinTableMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query findUserDataByUserCode ");
		try {
			JoinTable joinTable = mapper.readValue(data, JoinTable.class);	
			joinTableMapper.createJoinTable(joinTable);
			return mapper.writeValueAsString(joinTable);
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
}