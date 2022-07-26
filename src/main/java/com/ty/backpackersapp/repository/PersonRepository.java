package com.ty.backpackersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.backpackersapp.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	@Query("SELECT p FROM Person p WHERE p.email=:myemail AND p.password=:mypassword")
	Person validatePerson(@Param("myemail") String email , @Param("mypassword") String password);
}
