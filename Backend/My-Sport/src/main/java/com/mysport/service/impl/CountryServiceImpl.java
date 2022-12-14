package com.mysport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysport.entities.Country;
import com.mysport.repository.CountryRepository;
import com.mysport.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> getCountries() {
		List<Country> country = this.countryRepository.findAll();
		return country;
	}

}
