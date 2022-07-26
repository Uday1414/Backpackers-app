package com.ty.backpackersapp.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.AdminDao;
import com.ty.backpackersapp.dto.Admin;
import com.ty.backpackersapp.repository.AdminRepository;
import com.ty.backpackersapp.repository.StayRepository;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	StayRepository stayRepository;

	@Override
	public Admin saveAdmin(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdmin(int id) {

		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return adminRepository.save(admin);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteAdmin(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			adminRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Admin validateAdmin(String email, String password) {
		
		return adminRepository.validateAdmin(email, password);
	}
	
	

}
