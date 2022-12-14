package com.mysport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mysport.entities.SportBooking;

public interface SportRepository extends JpaRepository<SportBooking, Long> {

//	@Query(value = "SELECT  b.end FROM sport_booking b inner join users u on b.user_id = b.user_id where b.user_id=:userId", nativeQuery = true)	
//	List<SportBooking> findBookingData(@Param("userId") Long userId);
}
