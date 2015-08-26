package com.myproject.parking.lib.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.parking.lib.data.LoginData;
import com.myproject.parking.lib.data.SlotsParkingVO;
import com.myproject.parking.lib.entity.Booking;
import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.Constants;

@Service
public class ReleaseSlotParkingService {
	private static final Logger LOG = LoggerFactory.getLogger(ReleaseSlotParkingService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	public void releaseSlotParking(LoginData loginData) throws ParkingEngineException {
		LOG.debug("process releaseSlotParking.. ");	
		UserData user = userDataMapper.findUserDataByEmail(loginData.getEmail());
		if(user == null){
			LOG.error("Can't find User with email : " + loginData.getEmail());
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
		if(StringUtils.isEmpty(user.getSessionKey())){
			LOG.error("User Must Login Before make transaction, Parameter email : " + loginData.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_LOGIN);
		}
		if(!user.getSessionKey().equals(loginData.getSessionKey())){
			LOG.error("Wrong Session Key, Parameter email : " + loginData.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_SESSION_KEY_DIFFERENT);
		}		
		checkSessionKeyService.checkSessionKey(user.getTimeGenSessionKey(), slotsParkingVO.getEmail());
		SlotsParkingVO slotsAvailable = null;
		slotsAvailable = slotsParkingMapper.findSlotsParkingAvailable(slotsParkingVO.getMallName());
		if(slotsAvailable == null){
			throw new ParkingEngineException(ParkingEngineException.ENGINE_SLOT_NOT_AVAILABLE);
		}
			slotsAvailable.setEmail(slotsParkingVO.getEmail());
			slotsAvailable.setSessionKey(slotsParkingVO.getSessionKey());
			Booking booking = new Booking();
			booking.setName(user.getName());
			booking.setEmail(user.getEmail());
			booking.setMallName(slotsAvailable.getMallName());
			booking.setIdSlot(slotsAvailable.getIdSlot());
			booking.setPhoneNo(user.getPhoneNo());	
			booking.setBookingCode(bookingService.generateBookingCode(user.getPhoneNo()));
			booking.setBookingId(bookingService.generateBookingId(user.getPhoneNo()));
			booking.setBookingDate(timeService.getCurrentTime());
			bookingService.saveBooking(booking,slotsAvailable.getIdSlot());
			slotsAvailable.setBookingId(booking.getBookingId());
		LOG.debug("process find Slots By Mall DONE with param slotsAvailable : " + slotsAvailable);
		return slotsAvailable;
	}
}
