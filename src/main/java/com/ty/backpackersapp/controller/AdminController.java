package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.Admin;
import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.Login;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.service.impl.AdminServiceImpl;
import com.ty.backpackersapp.service.impl.StayServiceImpl;

@RestController
public class AdminController {

	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@Autowired
	StayServiceImpl stayServiceImpl;
	
	

	@PostMapping("/admins")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {

		return adminServiceImpl.saveAdmin(admin);
	}

	@GetMapping("/admins/{id}")
	public ResponseStructure<Admin> getAdmin(@PathVariable int id) {
		return adminServiceImpl.getAdmin(id);
	}
	
	@GetMapping("/admins/stays")
	public ResponseStructure<List<Stay>> showAllStays(){
		return stayServiceImpl.getAllStay();
	}

	@PutMapping("/admins/{id}")
	public ResponseStructure<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		return adminServiceImpl.updateAdmin(id, admin);
	}

	@DeleteMapping("/admins/{id}")
	public ResponseStructure<String> deleteAdmin(@PathVariable int id) {
		return adminServiceImpl.deleteAdmin(id);
	}
	
	@PostMapping("/admins/login")
	public ResponseStructure<Admin> validateAdmin(@RequestBody Login login){
		return adminServiceImpl.validateAdmin(login.getEmail(), login.getPassword());
	}
	
	@PutMapping("/admins/approve/{id}")
	public ResponseStructure<Stay> approveStay(@PathVariable int id) {
		return stayServiceImpl.approveStay(id);
	}
	
	@GetMapping("/admins/bookings/{id}")
	public ResponseStructure<List<Booking>> showAllBookingsByStayId(@PathVariable int id){
		return adminServiceImpl.showAllBookingsByStayId(id);
	}
}
