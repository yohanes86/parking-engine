package com.emobile.smis.webservice.logic.report.module;

import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.data.report.InisiasiDealerVO;
import com.emobile.smis.web.fincore.mapper.InisiasiDealerMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindInisiasiDealerByBranchCode implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindInisiasiDealerByBranchCode.class);
	
	@Autowired
	private InisiasiDealerMapper inisiasiDealerMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {			
			ReportParamVO paramVO = mapper.readValue(data, ReportParamVO.class);	
			List<InisiasiDealerVO> listInisiasiDealer = inisiasiDealerMapper.findInisiasiDealerByBranchCode(paramVO);
			return mapper.writeValueAsString(listInisiasiDealer);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
