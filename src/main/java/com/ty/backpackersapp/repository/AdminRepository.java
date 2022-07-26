package com.ty.backpackersapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.backpackersapp.dto.Admin;
import com.ty.backpackersapp.dto.Stay;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("SELECT a FROM Admin a WHERE a.email=:myemail AND a.password=:mypassword")
	Admin validateAdmin(@Param("myemail")String email ,@Param("mypassword") String password);
	
	
}
