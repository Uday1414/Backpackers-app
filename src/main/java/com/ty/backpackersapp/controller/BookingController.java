package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.TempBooking;
import com.ty.backpackersapp.service.impl.BookingServiceImpl;

@RestController
public class BookingController {
	
	@Autowired
	BookingServiceImpl bookingServiceImpl;
	
	@PostMapping("/bookings/{pid}")
	public ResponseStructure<Booking> saveBooking(@RequestBody Booking booking , @PathVariable int pid ){
		return bookingServiceImpl.saveBooking(booking, pid);
	}
	
	@PostMapping("/bookings/add/{pid}/{bid}")
	public ResponseStructure<TempBooking> addBooking(@RequestBody TempBooking tempBooking , @PathVariable int pid , @PathVariable int bid){
		return bookingServiceImpl.addBooking(tempBooking, pid,bid);
	}
	
	@DeleteMapping("/bookings/{id}")
	public ResponseStructure<String> checkoutBooking(@PathVariable int id ) {
		return bookingServiceImpl.checkoutBooking(id);
	}
	
	@GetMapping("/bookings")
	public ResponseStructure<List<Booking>> getAllBooking(){
		return bookingServiceImpl.getAllBooking();
	}
}
