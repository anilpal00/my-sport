package com.mysport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysport.entities.State;
import com.mysport.repository.StateRepository;
import com.mysport.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<State> findByCountryCode(String code) {
		
		List<State> state = this.stateRepository.findByCountryCode(code);
		return state;
	}
	
}
