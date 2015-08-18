package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;

@Service
public class UserDataService {
	private static final Logger LOG = LoggerFactory.getLogger(UserDataService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public void processingRegistrationUser(UserData user) throws ParkingEngineException {
		LOG.debug("Checking phoneNo:[{}] and email:[{}] for Registration", user.getPhoneNo(), user.getEmail());
		UserData userData = userDataMapper.findUserDataByEmailAndPhoneNo(user.getEmail(), user.getPhoneNo());
		if (userData != null) {
			String msg = String.format("User with phoneNo:[%s] and email:[%s] has been registered", user.getPhoneNo(), user.getEmail());
			LOG.warn(msg);
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_HAS_BEEN_REGISTERED);
		}
		else{
			LOG.debug("Registration User: {}", user);
			userDataMapper.createUserData(user);
		}
	}
}
