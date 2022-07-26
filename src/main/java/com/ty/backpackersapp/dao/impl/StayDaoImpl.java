package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.StayDao;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.repository.StayRepository;
@Repository
public class StayDaoImpl implements StayDao {
	
	@Autowired
	StayRepository stayRepository;

	@Override
	public Stay saveStay(Stay stay , int id) {
		
		return stayRepository.save(stay);
	}

	@Override
	public Stay getStay(int id) {
		Optional<Stay> optional = stayRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Stay> getAllStay() {
		return stayRepository.findAll();
	}

	@Override
	public Stay updateStay(int id, Stay stay) {
		Optional<Stay> optional = stayRepository.findById(id);
		if(optional.isPresent()) {
			return stayRepository.save(stay);
		}
		return null;
	}

	@Override
	public boolean deleteStay(int id) {
		Optional<Stay> optional = stayRepository.findById(id);
		if(optional.isPresent()) {
			 stayRepository.delete(optional.get());
			 return true;
		}
		return false;
	}
	
	public List<Stay> showAllStays(){
		return stayRepository.showallStays();
	}
	
	

}
