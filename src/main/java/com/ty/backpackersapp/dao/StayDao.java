package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Stay;

public interface StayDao {
	Stay saveStay(Stay stay , int id);
	Stay getStay(int id);
	List<Stay> getAllStay();
	Stay updateStay(int id, Stay stay);
	boolean deleteStay(int id);
}
