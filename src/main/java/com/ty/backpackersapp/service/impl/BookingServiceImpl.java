package com.ty.backpackersapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.BedDaoImpl;
import com.ty.backpackersapp.dao.impl.BookingDaoImpl;
import com.ty.backpackersapp.dao.impl.PersonDaoImpl;
import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.Person;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.dto.TempBooking;
import com.ty.backpackersapp.exception.InvalidCredentialsException;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.repository.TempBookingRepository;
import com.ty.backpackersapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDaoImpl bookingDaoImpl;

	@Autowired
	PersonDaoImpl personDaoImpl;

	@Autowired
	BedDaoImpl bedDaoImpl;

	@Autowired
	TempBookingRepository tempBookingRepository;

	@Override
	public ResponseStructure<Booking> saveBooking(Booking booking, int pid) {
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		Person person = personDaoImpl.getPerson(pid);
		booking.setPerson(person);
		booking.setStatus("requested");
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		List<TempBooking> tempBookings = tempBookingRepository.getAllbookings(pid);
		List<Bed> beds = new ArrayList<>();
		double total = 0;
		for (TempBooking tempBooking : tempBookings) {
			for (Bed bed : tempBooking.getBeds()) {
				for (Booking b : bed.getBookings()) {
					if (b.getCheckInDate().equals(booking.getCheckInDate())) {
						throw new NoIdFoundException();
					} else {
						beds.add(bed);
						total += bed.getCost();
						bed.setBookings(bookings);
						bed.setTempBooking(null);
						bed.setStatus("booked");
						Stay stay = bed.getRoom().getStay();
						booking.setStay(stay);
					}
					
				}
				booking.setTotal(total);
				booking.setBeds(beds);

				Booking booking2 = bookingDaoImpl.saveBooking(booking);

				if (booking2 != null) {
					responseStructure.setData(booking2);
					responseStructure.setStatusCode(HttpStatus.CREATED.value());
					responseStructure.setMessage("Success");
				} else {
					throw new NoIdFoundException();
				}
			}
		}

		return responseStructure;
	}

	public ResponseStructure<TempBooking> addBooking(TempBooking tempBooking, int pid, int bid) {
		ResponseStructure<TempBooking> responseStructure = new ResponseStructure<TempBooking>();
		Person person = personDaoImpl.getPerson(pid);
		Bed bed = bedDaoImpl.getBed(bid);
		if (person != null) {
			if (bed.getTempBooking() == null && bed.getStatus().equals("available")) {
				tempBooking.setPerson(person);
				List<Bed> beds = new ArrayList<>();
				beds.add(bed);
				tempBooking.setBeds(beds);
				for (Bed b : beds) {
					b.setTempBooking(tempBooking);

				}
				TempBooking tempBooking2 = bookingDaoImpl.addBooking(tempBooking);
				if (tempBooking2 != null) {
					responseStructure.setData(tempBooking2);
					responseStructure.setStatusCode(HttpStatus.CREATED.value());
					responseStructure.setMessage("Success");
				} else {
					throw new NoIdFoundException();
				}
			} else {
				throw new InvalidCredentialsException("Bed not available");
			}
		} else {
			throw new InvalidCredentialsException("person not valid");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Booking> getBooking(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Booking>> getAllBooking() {
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<List<Booking>>();
		List<Booking> bookings = bookingDaoImpl.getAllBooking();
		if (bookings.size() > 0) {
			responseStructure.setData(bookings);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Bookings Found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Booking> updateBooking(int id, Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseStructure<String> checkoutBooking(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Booking booking = bookingDaoImpl.getBooking(id);

		if (booking != null && booking.getStatus().equals("confirmed")) {
			booking.setStatus("checkout");
			for (Bed b : booking.getBeds()) {
				b.setStatus("available");
				b.setBookings(null);
			}

			Booking booking2 = bookingDaoImpl.updateBooking(id, booking);
			if (booking2 != null) {

				responseStructure.setData("checkout Booking Done");
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setMessage("Success");
			} else {
				throw new NoIdFoundException("No Booking found");
			}

		} else {
			throw new NoIdFoundException("No Booking with given id found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<String> deleteBooking(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
