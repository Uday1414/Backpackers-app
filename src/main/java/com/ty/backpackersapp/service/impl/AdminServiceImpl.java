package com.ty.backpackersapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.AdminDaoImpl;
import com.ty.backpackersapp.dto.Admin;
import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.exception.InvalidCredentialsException;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.repository.BookingRepository;
import com.ty.backpackersapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDaoImpl adminDaoImpl;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public ResponseStructure<Admin> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin2 = adminDaoImpl.saveAdmin(admin);
		if(admin2!=null) {
			responseStructure.setData(admin2);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Admin> getAdmin(int id) {
		
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDaoImpl.getAdmin(id);
		if(admin!=null) {
			responseStructure.setData(admin);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Admin> updateAdmin(int id, Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin1 = adminDaoImpl.updateAdmin(id, admin);
		if(admin1!=null) {
			responseStructure.setData(admin1);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Updated");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<String> deleteAdmin(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag= adminDaoImpl.deleteAdmin(id);
		if(flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		}else {
			throw new NoIdFoundException("Admin id "+id+" Does not exist");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Admin> validateAdmin(String email, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin= adminDaoImpl.validateAdmin(email, password);
		if(admin!=null) {
			responseStructure.setData(admin);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Updated");
		}else {
			throw new InvalidCredentialsException();
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Booking>> showAllBookingsByStayId( int id){
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
		List<Booking> bookings = bookingRepository.showBookingsByStayId(id);
		List<Booking> bookings2= bookings.stream().filter(p->p.getStatus().equals("confirmed")).collect(Collectors.toList());
		if(bookings2.size()>0) {
			responseStructure.setData(bookings2);
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Success");
		}else {
			throw new InvalidCredentialsException("No Bookings with for given stay");
		}
		return responseStructure;
	}

}
