// #CreateCreditCard Sample
// Using the 'vault' API, you can store a 
// Credit Card securely on PayPal. You can
// use a saved Credit Card to process
// a payment in the future.
// The following code demonstrates how 
// can save a Credit Card on PayPal using 
// the Vault API.
// API used: POST /v1/vault/credit-card
package com.myproject.parking.trx.logic.transaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.parking.lib.data.LoginData;
import com.myproject.parking.lib.entity.Mall;
import com.myproject.parking.lib.service.MallService;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class ListMall implements BaseQueryLogic {

	private static final Logger LOG = LoggerFactory.getLogger(ListMall.class);
	
	@Autowired
	private MallService mallService;

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		try {						
			LoginData loginData = mapper.readValue(data, LoginData.class);
			List<Mall> listMall = mallService.findAllMall(loginData,mapper);
			String x = mapper.writeValueAsString(listMall);
			result = MessageUtils.handleSuccess(x, mapper);
		} catch (ParkingEngineException e) {
			result = MessageUtils.handleException(e, e.getMessage(), mapper);
			LOG.error("ParkingEngineException when processing " + pathInfo + " Error Message : " + result);
		} catch (Exception e) {
			result = MessageUtils.handleException(e, "Unexpected exception when processing "+ e.getMessage(), mapper);
			LOG.error("Unexpected exception when processing " + pathInfo + " Error Message " + result, e);
		}
		return result;
	}
	
	

}
