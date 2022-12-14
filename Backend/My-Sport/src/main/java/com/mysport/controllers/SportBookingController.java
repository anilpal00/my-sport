package com.mysport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysport.entities.SportBooking;
import com.mysport.service.SportBookingService;

@RestController
@RequestMapping("/api/book-sport-ground")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SportBookingController {

	@Autowired
	private SportBookingService sportBookingService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<SportBooking> createPlayerAppointment(@RequestBody SportBooking sportBooking, @PathVariable("userId") Integer pid){
		SportBooking sportGroundBooked = sportBookingService.bookSportGround(sportBooking, pid);
		return new ResponseEntity<SportBooking>(sportGroundBooked, HttpStatus.CREATED);
		//return ResponseEntity.ok(sportGroundBooked);
	}
		
	@GetMapping("/allBookingData")
	public ResponseEntity<List<SportBooking>> getAllBooks(){
		List<SportBooking> sportBooking = sportBookingService.getAllBookingData();
		return ResponseEntity.ok(sportBooking);
	}
}
