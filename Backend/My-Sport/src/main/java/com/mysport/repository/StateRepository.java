package com.mysport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mysport.entities.State;

public interface StateRepository extends JpaRepository<State, Integer> {

	List<State> findByCountryCode(@Param("code") String code);

//	List<State> findAllById(Integer id);

}
