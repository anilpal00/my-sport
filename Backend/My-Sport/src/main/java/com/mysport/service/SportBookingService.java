package com.mysport.service;

import java.util.List;

import com.mysport.entities.SportBooking;

public interface SportBookingService {

	SportBooking bookSportGround(SportBooking sportBooking, Integer uid);
	List<SportBooking> getAllBookingData();
//	List<SportBooking> getBookingData(Iterable<Long> userId);
}
