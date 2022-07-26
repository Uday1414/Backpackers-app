package com.ty.backpackersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.backpackersapp.dto.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	
}
