package com.myproject.parking.lib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.Booking;
import com.myproject.parking.lib.mapper.BookingMapper;
import com.myproject.parking.lib.mapper.TransactionDetailMapper;
import com.myproject.parking.lib.utils.CommonUtil;
import com.myproject.parking.lib.utils.Constants;

@Service
public class BookingService {
	private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private BookingMapper bookingMapper;
	
	@Autowired
	private TransactionDetailMapper transactionDetailMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	public String generateBookingCode(String phoneNo){
		String bookingCode = "BCODE"+phoneNo+CommonUtil.generateNumeric(Constants.LENGTH_GENERATE_BOOKING_CODE);
		return bookingCode;		
	}
	
	public String generateBookingId(String phoneNo){
		String bookingId = "BID"+phoneNo+CommonUtil.generateNumeric(Constants.LENGTH_GENERATE_BOOKING_CODE);
		return bookingId;		
	}
	
	protected void updateSlotStatus(int idSlot) {	
		// update mall slot menjadi 1 alias booked tapi belum bayar
		transactionDetailMapper.updateMallSlotStatus(idSlot);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveBooking(Booking booking,int idSlot) throws ParkingEngineException {
		LOG.info("saveBooking with param : " + booking + " mall slot id : " + idSlot);
		bookingMapper.createBooking(booking);
		transactionDetailMapper.updateMallSlotStatus(idSlot);
		
		LOG.info("saveBooking done with param : " + booking);
	}
}
