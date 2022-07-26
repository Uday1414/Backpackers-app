package com.ty.backpackersapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.backpackersapp.dto.Stay;

public interface StayRepository extends JpaRepository<Stay, Integer> {
	
	@Query("SELECT s FROM Stay s WHERE s.status LIKE 'pending'")
	List<Stay> showallStays();
	
	@Query("SELECT s FROM Stay s WHERE s.status LIKE 'approved'")
	List<Stay> showallApprovedStays();
}
