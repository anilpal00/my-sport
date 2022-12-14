package com.mysport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysport.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
