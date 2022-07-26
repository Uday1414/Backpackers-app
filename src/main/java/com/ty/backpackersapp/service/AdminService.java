package com.ty.backpackersapp.service;

import com.ty.backpackersapp.dto.Admin;
import com.ty.backpackersapp.dto.ResponseStructure;

public interface AdminService {
	
	ResponseStructure<Admin> saveAdmin(Admin admin);
	ResponseStructure<Admin> getAdmin(int id);
	ResponseStructure<Admin> updateAdmin(int id, Admin admin);
	ResponseStructure<String> deleteAdmin(int id);
	ResponseStructure<Admin> validateAdmin(String email, String password);
}
