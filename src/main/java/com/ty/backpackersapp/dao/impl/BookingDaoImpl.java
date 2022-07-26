package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.BookingDao;
import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.TempBooking;
import com.ty.backpackersapp.repository.BookingRepository;
import com.ty.backpackersapp.repository.TempBookingRepository;
@Repository
public class BookingDaoImpl implements BookingDao{
	
	@Autowired
	BookingRepository bookingRepository ;
	
	@Autowired
	TempBookingRepository tempBookingRepository;
	
	

	@Override
	public Booking saveBooking(Booking booking) {
		
		return bookingRepository.save(booking);
	}
	
	public TempBooking addBooking(TempBooking tempBooking) {
		
		return tempBookingRepository.save(tempBooking);
	}
	
	@Override
	public Booking getBooking(int id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		
		}
		return null;
	}

	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepository.findAll();
	}

	@Override
	public Booking updateBooking(int id, Booking booking) {
		Optional<Booking> optional = bookingRepository.findById(id);
		if(optional.isPresent()) {
			return bookingRepository.save(booking);
		
		}
		return null;
	}

	@Override
	public boolean deleteBooking(int id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		if(optional.isPresent()) {
			bookingRepository.delete(optional.get());
			return true;
		}
		return false;
	}

}
