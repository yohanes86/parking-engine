package com.myproject.parking.lib.service.scheduler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.Booking;
import com.myproject.parking.lib.mapper.BookingMapper;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.utils.CommonUtil;
import com.myproject.parking.lib.utils.Constants;

@Service
public class AutoReleaseBookingService {
	private static final Logger LOG = LoggerFactory.getLogger(AutoReleaseBookingService.class);
	
	@Autowired
	private BookingMapper bookingMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	@Transactional(rollbackFor=Exception.class)
	public void release(){
		/**
		 * Release parkiran jika tidak dibayar
		 */
		LOG.info("release on process");	
		List<Booking> listBookingNotPay = bookingMapper.findBookingNotPay();
		LOG.debug("release on process with listBookingNotPay " + listBookingNotPay.size());	
		for (Booking booking : listBookingNotPay) {
			
				if(isExpiredPay(booking.getBookingDate())){
					bookingMapper.updateMallSlotStatusAvailable(booking.getIdSlot());
					booking.setBookingStatus(Constants.STATUS_AUTO_RELEASE_AFTER_BOOKING);
					bookingMapper.updateBookingStatus(booking);
				}					
			
			
		}
		/**
		 * Release parkiran jika sudah lewat dari 2 jam
		 */
		List<Booking> listBookingNotCheckIn = null;
		listBookingNotCheckIn = bookingMapper.findBookingNotCheckIn();
		LOG.debug("release on process with listBookingNotCheckIn " + listBookingNotCheckIn.size());	
		for (Booking booking : listBookingNotCheckIn) {
			
				if(isExpiredCheckIn(booking.getBookingDate())){
					bookingMapper.updateMallSlotStatusAvailable(booking.getIdSlot());
					booking.setBookingStatus(Constants.STATUS_AUTO_RELEASE_AFTER_PAY);
					bookingMapper.updateBookingStatus(booking);
				}					
			
			
		}
		LOG.info("release done");
	}
	
	private boolean isExpiredPay(Date bookDate){
		boolean hasil = false;
		Date now = timeService.getCurrentTime();
		LOG.info("isExpiredPay with param : " + " Booking Id Date: " + bookDate + " current time : " + now );
		long minutes = CommonUtil.dateDifferentInMinutes(bookDate, now);
		if(minutes>=Constants.EXPIRED_PAY_IN_MINUTES){
			LOG.warn("Expired Booking Id with setting : " + Constants.EXPIRED_PAY_IN_MINUTES + " minutes.");
			hasil = true;
		}		
		LOG.info("isExpiredPay Done with param : " + " Booking Id Date: " + bookDate + " current time : " + now );
		return hasil;
	}
	
	private boolean isExpiredCheckIn(Date bookDate){
		boolean hasil = false;
		Date now = timeService.getCurrentTime();
		LOG.info("isExpiredCheckIn with param : " + " BookingCodeDate: " + bookDate + " current time : " + now );
		long minutes = CommonUtil.dateDifferentInMinutes(bookDate, now);
		if(minutes>=Constants.EXPIRED_BOOKING_CODE_IN_MINUTES){
			LOG.warn("Expired Booking Code with setting : " + Constants.EXPIRED_BOOKING_CODE_IN_MINUTES + " minutes.");
			hasil = true;
		}		
		LOG.info("isExpiredCheckIn Done with param : " + " BookingCodeDate: " + bookDate + " current time : " + now );
		return hasil;
	}
}
