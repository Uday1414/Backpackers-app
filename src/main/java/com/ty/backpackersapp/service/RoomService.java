package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Room;

public interface RoomService {
	
	ResponseStructure<Room> saveRoom(Room room , int id);
	ResponseStructure<Room> getRoom(int id);
	ResponseStructure<List<Room>> getAllRoom();
	ResponseStructure<Room> updateRoom(int id, Room room);
	ResponseStructure<String> deleteRoom(int id);
}
