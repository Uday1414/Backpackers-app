package com.ty.backpackersapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.backpackersapp.dao.impl.BookingDaoImpl;
import com.ty.backpackersapp.dao.impl.ManagerDaoImpl;
import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.Manager;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.repository.BookingRepository;
import com.ty.backpackersapp.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDaoImpl managerDaoImpl;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BookingDaoImpl bookingDaoImpl;

	@Override
	public ResponseStructure<Manager> saveManager(Manager manager) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		Manager manager2 = managerDaoImpl.saveManager(manager);
		if (manager2 != null) {
			responseStructure.setData(manager2);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Manager> getManager(int id) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		Manager manager = managerDaoImpl.getManager(id);
		if (manager != null) {
			responseStructure.setData(manager);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Manager with id "+id+" found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Manager>> getAllManager() {
		ResponseStructure<List<Manager>> responseStructure = new ResponseStructure<List<Manager>>();
		List<Manager> managers = managerDaoImpl.getAllManager();
		if (managers.size() > 0) {
			responseStructure.setData(managers);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Managers Found");
		}
		return responseStructure;
	}

	public ResponseStructure<List<Booking>> getBookings(int id) {
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<List<Booking>>();
		List<Booking> bookings = bookingDaoImpl.getAllBooking();
		List<Booking> bookings2 = bookings.stream().filter(p->p.getStay().getId()==id).collect(Collectors.toList());
		
		if (bookings2.size() > 0) {
			responseStructure.setData(bookings2);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No bookings Found");
		}
		return responseStructure;
	}

	public ResponseStructure<Booking> confirmBooking(@PathVariable int id) {
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		Optional<Booking> optional = bookingRepository.findById(id);
		if (optional.isPresent()) {
			Booking booking = optional.get();
			if (booking != null) {
				booking.setStatus("confirmed");
				Booking booking2 = bookingDaoImpl.updateBooking(id, booking);
				responseStructure.setData(booking2);
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Success");
			} else {
				throw new NoIdFoundException("No stay Found");
			}
		} else {
			throw new NoIdFoundException("No stay Found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Manager> updateManager(int id, Manager manager) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		Manager manager2 = managerDaoImpl.updateManager(id, manager);
		if (manager2 != null) {
			responseStructure.setData(manager2);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Manager with id "+id+" found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<String> deleteManager(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = managerDaoImpl.deleteManager(id);
		if (flag) {
			responseStructure.setData("Deleted Data");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Manager with id "+id+" found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Manager> validateManager(String email, String password) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		Manager manager = managerDaoImpl.validateManager(email, password);
		if (manager != null) {
			responseStructure.setData(manager);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No Manager with given credentials found");
		}
		return responseStructure;
	}

}
