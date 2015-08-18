package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.Constants;

@Service
public class ForgetPasswordService {
	private static final Logger LOG = LoggerFactory.getLogger(ForgetPasswordService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	public void forgetPassword(String email) throws ParkingEngineException {
		LOG.info("forgetPassword with param : " + " EMAIL: " + email );	
		UserData user = userDataMapper.findUserDataByEmail(email);
		if(user == null){
			LOG.error("Can't find User");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_FOUND);
		}
		if(Constants.ACTIVE == user.getStatus()){
			LOG.error("User already activated");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_ALREADY_ACTIVATED);
		}
		if(Constants.BLOCKED == user.getStatus()){
			LOG.error("User already blocked");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_BLOCKED);
		}
		// update password user
		// update updated on	
		// kirim ke email
		String password = null;
		userDataMapper.updatePasswordUser(email, password, timeService.getCurrentTime());
		// kirim ke email user
		
		LOG.info("forgetPassword done with param : " + " EMAIL: " + email);
	}
}
