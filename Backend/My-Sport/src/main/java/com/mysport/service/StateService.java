package com.mysport.service;

import java.util.List;

import com.mysport.entities.State;

public interface StateService {

	 List<State> findByCountryCode(String code);
}
