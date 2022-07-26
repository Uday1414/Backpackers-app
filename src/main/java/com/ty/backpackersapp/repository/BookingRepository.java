package com.ty.backpackersapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.backpackersapp.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
//	@Query("SELECT b FROM Booking b WHERE b.stay.id=?1")
//	List<Booking> showBookings(int id);
	
	@Query("SELECT b FROM Booking b WHERE b.stay.id=:myid")
	List<Booking> showBookingsByStayId(@Param("myid") int id);
}
