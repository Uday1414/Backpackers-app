package com.ty.backpackersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.backpackersapp.dto.Manager;


public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	
	@Query("SELECT m FROM Manager m WHERE m.email=:myemail AND m.password=:mypassword")
	Manager validateManager(@Param("myemail") String email , @Param("mypassword") String password);
}
