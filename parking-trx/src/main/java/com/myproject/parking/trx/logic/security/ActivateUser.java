// #CreateCreditCard Sample
// Using the 'vault' API, you can store a 
// Credit Card securely on PayPal. You can
// use a saved Credit Card to process
// a payment in the future.
// The following code demonstrates how 
// can save a Credit Card on PayPal using 
// the Vault API.
// API used: POST /v1/vault/credit-card
package com.myproject.parking.trx.logic.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.parking.lib.service.ActivateUserService;
import com.myproject.parking.lib.service.CheckUserService;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class ActivateUser implements BaseQueryLogic {

	private static final Logger LOG = LoggerFactory.getLogger(ActivateUser.class);
	
	@Autowired
	private ActivateUserService activateUserService;

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		try {						
			if (request.getParameter("actKey") != null) {
				if (request.getParameter("email") != null) {
					if (request.getParameter("noHp") != null) {
						activateUserService.activateUser(request.getParameter("actKey"),request.getParameter("email"),request.getParameter("noHp"));
					}					
				}				
			}		
//			result = MessageUtils.handleSuccess("Email : " +  request.getParameter("email") 
//					+ " No Hp : " + request.getParameter("noHp")
//					+ " has been activated." , mapper);
			result = "Email : " +  request.getParameter("email") 
					+ " No Hp : " + request.getParameter("noHp")
					+ " has been activated.";
		} catch (ParkingEngineException e) {
			LOG.error("ParkingEngineException when processing " + pathInfo, e);
			result = MessageUtils.handleExceptionOther(e, "", mapper);
		} catch (Exception e) {
			LOG.error("Unexpected exception when processing " + pathInfo, e);
			result = MessageUtils.handleExceptionOther(e, "Unexpected exception when processing "+ e.getMessage(), mapper);
		}
		return result;
	}

}
