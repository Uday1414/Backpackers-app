package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.ResponseStructure;

public interface BookingService {
	
	ResponseStructure<Booking> saveBooking(Booking booking , int pid);
	ResponseStructure<Booking> getBooking(int id);
	ResponseStructure<List<Booking>> getAllBooking();
	ResponseStructure<Booking> updateBooking(int id, Booking booking);
	ResponseStructure<String> deleteBooking(int id);
}
