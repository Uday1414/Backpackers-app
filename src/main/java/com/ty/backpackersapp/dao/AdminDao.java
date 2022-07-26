package com.ty.backpackersapp.dao;

import com.ty.backpackersapp.dto.Admin;

public interface AdminDao {
	Admin saveAdmin(Admin admin);
	Admin getAdmin(int id);
	Admin updateAdmin(int id, Admin admin);
	boolean deleteAdmin(int id);
	Admin validateAdmin(String email, String password);
}
