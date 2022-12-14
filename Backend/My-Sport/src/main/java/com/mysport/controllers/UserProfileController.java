package com.mysport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysport.entities.Country;
import com.mysport.entities.State;
import com.mysport.entities.User;
import com.mysport.service.CountryService;
import com.mysport.service.StateService;
import com.mysport.service.UserService;


@RestController
@RequestMapping("/api/userprofile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserProfileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@PatchMapping("/{userId}")
	public ResponseEntity<User> createUserProfile(@RequestBody User userProfile, @PathVariable("userId") Long uid){
		User updatedUserProfile = this.userService.updatedUserProfile(userProfile, uid);
		return ResponseEntity.ok(updatedUserProfile);
	}
	
	@GetMapping("/state/{code}")
	public ResponseEntity<List<State>> findStateByCountryCode(@PathVariable("code") String cid){
		List<State> state = this.stateService.findByCountryCode(cid);	
		return ResponseEntity.ok(state);
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllCountries(){
		List<Country> country = this.countryService.getCountries();
		return ResponseEntity.ok(country);
	}
	
	@GetMapping("/msId/{userId}")
	public ResponseEntity<User> getMsId(@PathVariable("userId") Long userId){
		User user = this.userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
}
