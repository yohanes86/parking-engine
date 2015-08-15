package com.emobile.smis.webservice.logic.report.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.data.report.ReportSalesPotentionVO;
import com.emobile.smis.web.fincore.mapper.RealisationSalesMapper;
import com.emobile.smis.web.mapper.ReportMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindAllRealisationSales implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindAllRealisationSales.class);
	
	@Autowired
	private RealisationSalesMapper realisationMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {				
			List<ReportSalesPotentionVO> listReportSalesPontention = realisationMapper.findAllRealisationSales();
			return mapper.writeValueAsString(listReportSalesPontention);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}

}
