package com.mysport.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mysport.entities.Country;
import com.mysport.entities.State;
import com.mysport.repository.CountryRepository;
import com.mysport.service.CountryService;
import com.mysport.service.impl.CountryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

	@Mock
	private CountryRepository countryRepository;
	
	@Mock
	private Country country;
	
	@MockBean
	CountryServiceImpl countryServiceImpl ;
	
	@MockBean
	CountryService countryService ;
	
	@Test
	void testGetCountries() {
		List<Country> country = new ArrayList<>();
		List<State> state = new ArrayList<>();
		
		Country country1 = new Country();
		
		State state1 = new State();
		state1.setId(1);
		state1.setName("Uttar Pradesh");
		state1.setCountry(country1);
		state.add(state1);
		
		country1.setId(1);
		country1.setCode("IN");
		country1.setName("India");
		country1.setStates(state);
		
		country.add(country1);
		
//		when(countryRepository.findAll()).thenReturn(country);
		assertEquals(1, country.size());
	}

}
