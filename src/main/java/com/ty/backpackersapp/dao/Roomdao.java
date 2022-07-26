package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Room;

public interface Roomdao {
	Room saveRoom(Room room);
	Room getRoom(int id);
	List<Room> getAllRoom();
	Room updateRoom(int id, Room room);
	boolean deleteRoom(int id);
}
