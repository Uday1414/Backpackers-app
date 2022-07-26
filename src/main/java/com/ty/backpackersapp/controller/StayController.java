package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.service.impl.StayServiceImpl;

@RestController
public class StayController {
	
	@Autowired
	StayServiceImpl serviceImpl;
	
	@PostMapping("/stays/{id}")
	public ResponseStructure<Stay> saveStay(@RequestBody Stay stay , @PathVariable int id){
		return serviceImpl.saveStay(stay , id);
	}
	
	@GetMapping("/stays/{id}")
	public ResponseStructure<Stay> getStay(@PathVariable int id){
		return serviceImpl.getStay(id);
	}
	
	@GetMapping("/stays")
	public ResponseStructure<List<Stay>> getAllStay() {
		return serviceImpl.getAllStay();
	}
}
