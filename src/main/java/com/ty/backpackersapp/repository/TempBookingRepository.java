package com.ty.backpackersapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.backpackersapp.dto.TempBooking;

public interface TempBookingRepository extends JpaRepository<TempBooking, Integer>{
	
	@Query("SELECT t FROM TempBooking t WHERE t.person.id=:myid")
	List<TempBooking> getAllbookings(@Param("myid") int id);
	
	
}
