package com.myproject.parking.trx.logic.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.utils.Constants;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class UserRegistration implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(UserRegistration.class);
			
	@Autowired
	private AppsTimeService timeService;
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(HttpServletRequest request, HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			UserData user = mapper.readValue(data, UserData.class);
			user.setCreatedBy(user.getName());
			user.setCreatedOn(timeService.getCurrentTime());
			user.setUpdatedBy(user.getName());
			user.setUpdatedOn(timeService.getCurrentTime());
			user.setStatus(Constants.PENDING);
			user.setSessionKey("12344567622323SSS");
			user.setTimeGenSessionKey(timeService.getCurrentTime());
			LOG.debug("UserData: [{}]", user);
			
			UserData userData = userDataMapper.findUserDataByEmailAndPhoneNo(user.getEmail(), user.getPhoneNo());
			if(userData != null){
				return mapper.writeValueAsString(Constants.SUCCESS_CODE);
			}
			else{
				userDataMapper.createUserData(user);
				return mapper.writeValueAsString(Constants.SUCCESS_CODE);
			}
		} catch (Exception e) {
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
