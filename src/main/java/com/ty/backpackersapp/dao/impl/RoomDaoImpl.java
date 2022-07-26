package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.Roomdao;
import com.ty.backpackersapp.dto.Room;
import com.ty.backpackersapp.repository.RoomRepository;
@Repository
public class RoomDaoImpl implements Roomdao{
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room saveRoom(Room room) {
		
		return roomRepository.save(room);
	}

	@Override
	public Room getRoom(int id) {
		Optional<Room> optional = roomRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Room> getAllRoom() {
		
		return roomRepository.findAll();
	}

	@Override
	public Room updateRoom(int id, Room room) {
		Optional<Room> optional = roomRepository.findById(id);
		if(optional.isPresent()) {
			return roomRepository.save(room);
		}
		return null;   
	}

	@Override
	public boolean deleteRoom(int id) {
		Optional<Room> optional = roomRepository.findById(id);
		if(optional.isPresent()) {
			 roomRepository.delete(optional.get());
			 return true;
		}
		return false; 
	}

}
