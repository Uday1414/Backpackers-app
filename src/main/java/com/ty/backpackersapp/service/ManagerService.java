package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.Manager;
import com.ty.backpackersapp.dto.ResponseStructure;

public interface ManagerService {
	
	ResponseStructure<Manager> saveManager(Manager manager);
	ResponseStructure<Manager> getManager(int id);
	ResponseStructure<List<Manager>> getAllManager();
	ResponseStructure<Manager> updateManager(int id, Manager manager);
	ResponseStructure<String> deleteManager(int id);
	ResponseStructure<Manager> validateManager(String email, String password);
}
