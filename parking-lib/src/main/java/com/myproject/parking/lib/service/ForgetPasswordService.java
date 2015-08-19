package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.CipherUtil;
import com.myproject.parking.lib.utils.CommonUtil;
import com.myproject.parking.lib.utils.Constants;
import com.myproject.parking.lib.utils.EmailSender;

@Service
public class ForgetPasswordService {
	private static final Logger LOG = LoggerFactory.getLogger(ForgetPasswordService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	@Autowired
	private EmailSender emailSender;
	
	public void forgetPassword(String email) throws ParkingEngineException {
		LOG.info("forgetPassword with param : " + " EMAIL: " + email );	
		UserData user = userDataMapper.findUserDataByEmail(email);
		if(user == null){
			LOG.error("Can't find User");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_FOUND);
		}
		if(Constants.BLOCKED == user.getStatus()){
			LOG.error("User already blocked");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_BLOCKED);
		}
		if(Constants.PENDING == user.getStatus()){
			LOG.error("User not active");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_ACTIVE);
		}		
		// update password user
		// update updated on	
		// kirim ke email		
		String password = CommonUtil.generateAlphaNumeric(Constants.LENGTH_GENERATE_FORGET_PASSWORD);
		String passwordHash = CipherUtil.passwordDigest(user.getEmail(), password);
		userDataMapper.updatePasswordUser(email, passwordHash, timeService.getCurrentTime());
		// kirim ke email user
		composeEmailMsg(user, password);
		LOG.info("forgetPassword done with param : " + " EMAIL: " + email);
	}
	
	private void composeEmailMsg(UserData user, String password){
		String emailTo= user.getEmail();
		String emailSubject= "PARKING ONLINE : Forget Password";
		String message= "";
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Mr/Mrs ").append(user.getName()).append(",");
		sb.append("\n").append("\n");
		sb.append("Your Password: " + password).append("\n");
		sb.append("Please change password after login.").append("\n");
		sb.append("Thank you for using our application.").append("\n");
		sb.append("\n");
		sb.append("Regards,");
		sb.append("\n").append("\n");
		sb.append("Administrator");
		message = sb.toString();
		emailSender.sendSimpleMail("", emailTo, emailSubject, message);
	}
}
