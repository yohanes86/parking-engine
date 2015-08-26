package com.myproject.parking.lib.mapper;

import org.apache.ibatis.annotations.Param;

import com.myproject.parking.lib.entity.Booking;

public interface BookingMapper {
	
	public void createBooking(Booking booking);
	public Booking findBookingById(@Param("bookingId") String bookingId);
	
}
