package com.mysport.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mysport.entities.Country;
import com.mysport.entities.State;
import com.mysport.entities.User;
import com.mysport.service.CountryService;
import com.mysport.service.StateService;
import com.mysport.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserProfileControllerTest {

	@Mock
	private UserService userService;
	
	@Mock
	private CountryService countryService;
	
	@Mock
	private StateService stateService;
	
	@InjectMocks
	UserProfileController userProfileController;
	
	@Mock
	User user;
	
	@Mock
	Country country;
	
	@Mock
	State state;
	
	@Test
	void testCreateUserProfile() {
		user.setFirstName("Anil");
		user.setLastName("Pal");
		user.setId((long) 1);
		user.setMobileNo("9999999999");
		user.setCountry("India");
		user.setState("Uttar Pradesh");
		user.setCity("Noida");
		user.setEmail("anil@gmail.com");
		user.setPan("ASDFG1234N");
		user.setStreet("Gaur");
		
		when(userService.updatedUserProfile(user, (long) 1)).thenReturn(user);
		assertEquals(200, userProfileController.createUserProfile(user, (long) 1).getStatusCodeValue());
		
	}
	
	@Test
	void testGetAllCountries() {
		List<Country> list = new ArrayList<>();
		when(countryService.getCountries()).thenReturn(list);
		assertEquals(200, userProfileController.getAllCountries().getStatusCodeValue());
	}
	
	@Test
	void testFindStateByCountryCode() {
		List<State> state = new ArrayList<>();
		when(stateService.findByCountryCode("IN")).thenReturn(state);
		assertEquals(200, userProfileController.findStateByCountryCode("IN").getStatusCodeValue());
	}
		
}
