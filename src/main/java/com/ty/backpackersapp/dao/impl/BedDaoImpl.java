package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.BedDao;
import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.repository.BedRepository;
@Repository
public class BedDaoImpl implements BedDao {
	
	@Autowired
	BedRepository bedRepository;

	@Override
	public Bed saveBed(Bed bed) {
		
		return bedRepository.save(bed);
	}

	@Override
	public Bed getBed(int id) {
		Optional<Bed> optional = bedRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Bed> getAllBed() {
		
		return bedRepository.findAll();
	}

	@Override
	public Bed updateBed(int id, Bed bed) {
		Optional<Bed> optional = bedRepository.findById(id);
		if(optional.isPresent()) {
			return bedRepository.save(bed);
		}
		return null;
	}

	@Override
	public boolean deleteBed(int id) {
		Optional<Bed> optional = bedRepository.findById(id);
		if(optional.isPresent()) {
			bedRepository.delete(optional.get());
			return true;
		}
		return false;
	}

}
