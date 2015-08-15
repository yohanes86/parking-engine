package com.emobile.smis.webservice.logic.visit.module;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.VisitBmDataVO;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.entity.VisitBmDataCompetitor;
import com.emobile.smis.web.entity.VisitBmMeetPic;
import com.emobile.smis.web.entity.VisitBmVehicleStock;
import com.emobile.smis.web.mapper.VisitMapper;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindDataVisitBmVisitId implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindDataVisitBmVisitId.class);
	
	@Autowired
	private VisitMapper visitMapper;
		
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			int visitId = mapper.readValue(data, Integer.class);	
			VisitBmDataVO visitBmDataVo=new VisitBmDataVO();
			visitBmDataVo.setListVisitBmDataCompetitor(visitMapper.findVisitBmDataCompetitorByVisitId(visitId));
			visitBmDataVo.setListVisitBmMeetPic(visitMapper.findVisitBmMeetPicByVisitId(visitId));
			visitBmDataVo.setListVisitBmReportAdviceSales(visitMapper.findVisitBmReportAdviceSalesByVisitId(visitId));
			VisitBmVehicleStock vehicleStockTotal = new VisitBmVehicleStock();
			vehicleStockTotal = visitMapper.findVisitBmVehicleStockTotalByVisitId(visitId);
			if(vehicleStockTotal != null)
			{
				visitBmDataVo.setVehicleStockTotal(vehicleStockTotal);
				visitBmDataVo.setListVehicleStockOtr(visitMapper.findVisitBmVehicleStockOtrByVisitId(visitBmDataVo.getVehicleStockTotal().getId()));
				visitBmDataVo.setListVehicleStockAge(visitMapper.findVisitBmVehicleStockAgeByVisitId(visitBmDataVo.getVehicleStockTotal().getId()));
				visitBmDataVo.setListVehicleStockMerk(visitMapper.findVisitBmVehicleStockMerkByVisitId(visitBmDataVo.getVehicleStockTotal().getId()));
			}
			return mapper.writeValueAsString(visitBmDataVo);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
