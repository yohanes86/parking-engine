package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.entity.DataCompetitor;
import com.emobile.smis.web.entity.VisitBmDataCompetitor;
import com.emobile.smis.web.entity.VisitBmMeetPic;
import com.emobile.smis.web.entity.VisitBmReportAdviceSales;
import com.emobile.smis.web.entity.VisitBmVehicleStock;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class InsertVisitBmVehicleStock implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(InsertVisitBmVehicleStock.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);
		
		try {
			VisitBmVehicleStock visitBmVehicleStock = mapper.readValue(data, VisitBmVehicleStock.class);	
			visitMapper.insertVisitBmVehicleStock(visitBmVehicleStock);
			return mapper.writeValueAsString(visitBmVehicleStock);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}	
	}

}
