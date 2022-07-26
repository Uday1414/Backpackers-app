package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.dto.ResponseStructure;

public interface BedService {
	
	ResponseStructure<Bed> saveBed(Bed bed , int id);
	ResponseStructure<Bed> getBed(int id);
	ResponseStructure<List<Bed>> getAllBed();
	ResponseStructure<Bed> updateBed(int id, Bed bed);
	ResponseStructure<String> deleteBed(int id);
}
