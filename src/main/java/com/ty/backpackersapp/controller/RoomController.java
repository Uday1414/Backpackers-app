package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Room;
import com.ty.backpackersapp.service.impl.RoomServiceImpl;

@RestController
public class RoomController {

	@Autowired
	RoomServiceImpl roomServiceImpl;
	
	@PostMapping("/rooms/{id}")
	public ResponseStructure<Room> saveRoom(@RequestBody Room room,@PathVariable int id) {
			return roomServiceImpl.saveRoom(room, id);
	}
	
	@GetMapping("/rooms/{id}")
	public ResponseStructure<Room> getRoom(@PathVariable int id){
		return roomServiceImpl.getRoom(id);
	}
	
	@GetMapping("/rooms")
	public ResponseStructure<List<Room>> getAllRoom() {
		return roomServiceImpl.getAllRoom();
	}
}
