package com.myproject.parking.lib.service.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.Booking;
import com.myproject.parking.lib.mapper.BookingMapper;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.utils.Constants;

@Service
public class ReleaseBookingNonPaymentService {
	private static final Logger LOG = LoggerFactory.getLogger(ReleaseBookingNonPaymentService.class);
	
	@Autowired
	private BookingMapper bookingMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	@Transactional(rollbackFor=Exception.class)
	public void release(){
		LOG.info("release on process");	
		List<Booking> listBookings = bookingMapper.findBookingNotPay();
		LOG.debug("release on process with listBookings " + listBookings.size());	
		for (Booking booking : listBookings) {
			bookingMapper.updateMallSlotStatusAvailable(booking.getIdSlot());
			booking.setBookingStatus(Constants.BOOKING_ALREADY_SCAN);
			bookingMapper.updateBookingStatus(booking);
		}
		LOG.info("release done");
	}
}
