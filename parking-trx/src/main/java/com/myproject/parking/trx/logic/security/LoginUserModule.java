package com.myproject.parking.trx.logic.security;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.Profile;
import com.myproject.parking.lib.utils.Constants;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class LoginUserModule implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(LoginUserModule.class);
	
//	@Autowired
//	private UserRoleMapper userRoleMapper;
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			Profile profile = mapper.readValue(data, Profile.class);
			LOG.debug("Profile: [{}]", profile);
//			userRoleMapper.deleteRoleModule(userRoleId);
			return mapper.writeValueAsString(Constants.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
	}
	
}
