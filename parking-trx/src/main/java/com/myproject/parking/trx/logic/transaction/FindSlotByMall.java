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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.parking.lib.data.SlotsParkingVO;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.service.SlotsParkingService;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class FindSlotByMall implements BaseQueryLogic {

	private static final Logger LOG = LoggerFactory.getLogger(FindSlotByMall.class);
	
	@Autowired
	private SlotsParkingService slotsParkingService;

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		try {						
			SlotsParkingVO slotsParkingVO = mapper.readValue(data, SlotsParkingVO.class);
			slotsParkingVO = slotsParkingService.findSlotsByMall(slotsParkingVO);
			String x = mapper.writeValueAsString(slotsParkingVO);
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
