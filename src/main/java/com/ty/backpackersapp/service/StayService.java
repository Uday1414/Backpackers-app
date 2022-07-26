package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;

public interface StayService {
	
	ResponseStructure<Stay> saveStay(Stay stay , int id);
	ResponseStructure<Stay> getStay(int id);
	ResponseStructure<List<Stay>> getAllStay();
	ResponseStructure<Stay> updateStay(int id, Stay stay);
	ResponseStructure<String> deleteStay(int id);
}
