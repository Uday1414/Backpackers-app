package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.ManagerDao;
import com.ty.backpackersapp.dto.Manager;
import com.ty.backpackersapp.repository.ManagerRepository;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	ManagerRepository managerRepository;

	@Override
	public Manager saveManager(Manager manager) {

		return managerRepository.save(manager);
	}

	@Override
	public Manager getManager(int id) {
		Optional<Manager> optional = managerRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Manager> getAllManager() {
		return managerRepository.findAll();
	}

	@Override
	public Manager updateManager(int id, Manager manager) {
		Optional<Manager> optional = managerRepository.findById(id);
		if (optional.isPresent()) {
			return managerRepository.save(manager);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteManager(int id) {
		Optional<Manager> optional = managerRepository.findById(id);
		if (optional.isPresent()) {
			 managerRepository.delete(optional.get());
			 return true;
		} else {
			return false;
		}
	}

	@Override
	public Manager validateManager(String email, String password) {
		
		return managerRepository.validateManager(email, password);
	}

}
