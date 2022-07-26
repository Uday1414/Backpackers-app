package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Bed;

public interface BedDao {
	Bed saveBed(Bed bed);
	Bed getBed(int id);
	List<Bed> getAllBed();
	Bed updateBed(int id, Bed bed);
	boolean deleteBed(int id);
}
