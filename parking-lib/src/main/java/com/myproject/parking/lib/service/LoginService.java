package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.parking.lib.data.LoginData;
import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.CipherUtil;
import com.myproject.parking.lib.utils.CommonUtil;
import com.myproject.parking.lib.utils.Constants;

@Service
public class LoginService {
	private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	public LoginData login(LoginData loginData) throws ParkingEngineException {
		LOG.info("login with param : " + " loginData: " + loginData );	
		UserData user = userDataMapper.findUserDataByEmail(loginData.getEmail());
		if(user == null){
			LOG.error("Can't find User with email " + loginData.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_WRONG_EMAIL_OR_PASSWORD);
		}
		if(Constants.BLOCKED == user.getStatus()){
			LOG.error("User already blocked");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_BLOCKED);
		}
		if(Constants.PENDING == user.getStatus()){
			LOG.error("User not active");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_ACTIVE);
		}	
		String passwordDB = user.getPassword();
		String passwordInput = CipherUtil.passwordDigest(loginData.getEmail(), loginData.getPassword());
		if(!passwordDB.equals(passwordInput)){
			throw new ParkingEngineException(ParkingEngineException.ENGINE_WRONG_EMAIL_OR_PASSWORD);
		}
		// generate session key
		String sessionKey = user.getPhoneNo() + CommonUtil.generateAlphaNumeric(30);
		user.setSessionKey(sessionKey);
		user.setTimeGenSessionKey(timeService.getCurrentTime());
		user.setUpdatedOn(timeService.getCurrentTime());
		userDataMapper.updateLoginSessionKey(user.getId(), user.getSessionKey(), user.getTimeGenSessionKey(), user.getUpdatedOn());
		loginData.setSessionKey(sessionKey);
		return loginData;
//		LOG.info("login done with param : " + " loginData: " + loginData);
	}
	
}