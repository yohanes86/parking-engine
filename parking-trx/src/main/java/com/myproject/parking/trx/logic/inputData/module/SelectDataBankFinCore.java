package com.emobile.smis.webservice.logic.inputData.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.entity.Bank;
import com.emobile.smis.web.fincore.mapper.BankFincoreMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class SelectDataBankFinCore implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(SelectDataBankFinCore.class);
	
	@Autowired
	private BankFincoreMapper bankFincoreMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {				
			List<Bank> listBank = bankFincoreMapper.findAllBankFinCore();
			return mapper.writeValueAsString(listBank);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
