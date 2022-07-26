package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Booking;

public interface BookingDao {
	
	Booking saveBooking(Booking booking);
	Booking getBooking(int id);
	List<Booking> getAllBooking();
	Booking updateBooking(int id, Booking booking);
	boolean deleteBooking(int id);
}
