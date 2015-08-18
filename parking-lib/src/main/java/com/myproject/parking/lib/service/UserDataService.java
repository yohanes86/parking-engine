package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.db.dialect.MsSQLDialect;

import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.CipherUtil;
import com.myproject.parking.lib.utils.EmailSender;

@Service
public class UserDataService {
	private static final Logger LOG = LoggerFactory.getLogger(UserDataService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private EmailSender emailSender;
	
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
			
			LOG.debug("Sending Email Confirmation Registration..");
			composeEmailMsg(user);
		}
	}
	
	private void composeEmailMsg(UserData user){
		String emailTo= user.getEmail();
		String emailSubject= "PARKING ONLINE : Register Account";
		String message= "";
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Mr/Mrs ").append(user.getName()).append(",");
		sb.append("\n").append("\n");
		sb.append("Your account has been successfully registered.").append("\n");
		sb.append("Please click link below to activate your account.").append("\n");
		sb.append("http://localhost:8080/parking-trx/trx/userActivate?actKey="+ user.getActivateKey() + "&email=" + user.getEmail() + "&noHp=" + user.getPhoneNo()).append("\n");
		sb.append("Thank you for using our application.").append("\n");
		sb.append("\n");
		sb.append("Regards,");
		sb.append("\n").append("\n");
		sb.append("Administrator");
		message = sb.toString();
		emailSender.sendSimpleMail("", emailTo, emailSubject, message);
	}
}
