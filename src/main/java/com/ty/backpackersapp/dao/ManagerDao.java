package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Manager;

public interface ManagerDao {
	Manager saveManager(Manager manager);
	Manager getManager(int id);
	List<Manager> getAllManager();
	Manager updateManager(int id, Manager manager);
	boolean deleteManager(int id);
	Manager validateManager(String email, String password);
}
