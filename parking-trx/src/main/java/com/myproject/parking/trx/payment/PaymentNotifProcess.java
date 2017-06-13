package com.myproject.parking.trx.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.parking.lib.data.ResponseVO;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.service.CheckUserService;
import com.myproject.parking.lib.service.VeriTransManagerService;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class PaymentNotifProcess implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(PaymentNotifProcess.class);
			
	@Autowired
	private CheckUserService checkUserService;
	
	@Autowired
	private VeriTransManagerService veriTransManagerService;
	
	@Autowired
	private AppsTimeService timeServer;
	
	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("PaymentNotifProcess :"+pathInfo + " data : " + data);		
		String result = "";
		ResponseVO responseVO = new ResponseVO();
//		try {				
//			MidTransVO midTransVO = new MidTransVO(); 
//			midTransVO = mapper.readValue(data, MidTransVO.class);
//			responseVO = veriTransManagerService.chargeMidtrans(mapper,midTransVO,data);
//			result = mapper.writeValueAsString(responseVO);
//		} catch (ParkingEngineException e) {
//			result = MessageUtils.handleException(e, "", mapper);
//			LOG.error("ParkingEngineException when processing " + pathInfo + " Error Message " + result);
//		} catch (RestClientException e) {			
//			result = MessageUtils.handleException(e, "RestClientException when processing "+ e.getMessage(), mapper);
//			LOG.error("RestClientException when processing " + pathInfo + " Error Message " + result);
//		} catch (Exception e) {			
//			result = MessageUtils.handleException(e, "Unexpected exception when processing "+ e.getMessage(), mapper);
//			LOG.error("Unexpected exception when processing " + pathInfo + " Error Message " + result);
//		}
		return result;
	}
	
}
