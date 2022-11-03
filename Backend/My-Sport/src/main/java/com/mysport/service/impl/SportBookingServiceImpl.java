package com.mysport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysport.entities.SportBooking;
import com.mysport.repository.SportRepository;
import com.mysport.service.SportBookingService;

@Service
public class SportBookingServiceImpl implements SportBookingService {

	
	@Autowired
	private SportRepository sportRepo;

	@Override
	public SportBooking bookSportGround(SportBooking sportBooking, Integer uid) {

		sportBooking.setUser_id(uid);
		sportBooking.setSportName(sportBooking.getSportName());;
		sportBooking.setStart(sportBooking.getStart());
		sportBooking.setEnd(sportBooking.getEnd());
		sportBooking.setStatus(sportBooking.getStatus());
		SportBooking sportBookingConfirmed = sportRepo.save(sportBooking);	
		return sportBookingConfirmed;
	}

	@Override
	public List<SportBooking> getAllBookingData() {
		List<SportBooking> sportBooking = this.sportRepo.findAll();
		return sportBooking;
	}
	
}
