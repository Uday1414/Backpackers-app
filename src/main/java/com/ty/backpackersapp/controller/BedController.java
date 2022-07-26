package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.service.impl.BedServiceImpl;

@RestController
public class BedController {
	
	@Autowired
	BedServiceImpl bedServiceImpl;
	
	@PostMapping("/beds/{id}")
	public ResponseStructure<Bed> saveBed(@RequestBody Bed bed,@PathVariable int id){
		return bedServiceImpl.saveBed(bed, id);
	}
	
	@GetMapping("/beds")
	public ResponseStructure<List<Bed>> getAllBed(){
		return bedServiceImpl.getAllBed();
	}
}
