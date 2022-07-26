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

import com.ty.backpackersapp.dto.Booking;
import com.ty.backpackersapp.dto.Login;
import com.ty.backpackersapp.dto.Manager;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.service.impl.ManagerServiceImpl;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	@PostMapping("/managers")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager){
		return managerServiceImpl.saveManager(manager);
	}
	
	@GetMapping("/managers/{id}")
	public ResponseStructure<Manager> getManager(@PathVariable int id) {
		return managerServiceImpl.getManager(id);
	}
	
	@GetMapping("/managers")
	public ResponseStructure<List<Manager>> getAllManager(){
		return managerServiceImpl.getAllManager();
	}
	
	@GetMapping("/managers/bookings/{id}")
	public ResponseStructure<List<Booking>> getBookings( @PathVariable  int id){
		return managerServiceImpl.getBookings(id);
	}
	
	@PutMapping("/managers/confirm/{id}")
	public ResponseStructure<Booking> confirmBooking(@PathVariable int id){
		return managerServiceImpl.confirmBooking(id);
	}
	
	@PutMapping("/managers/{id}")
	public ResponseStructure<Manager> updateManager(@PathVariable int id, Manager manager) {
		return managerServiceImpl.updateManager(id, manager);
	}
	
	@DeleteMapping("/managers/{id}")
	public ResponseStructure<String> deleteManager(int id) {
		return managerServiceImpl.deleteManager(id);
	}
	
	@PostMapping("/managers/login")
	public ResponseStructure<Manager> validateManager(@RequestBody Login login) {
		return managerServiceImpl.validateManager(login.getEmail() , login.getPassword());
	}
}
