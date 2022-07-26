package com.ty.backpackersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.backpackersapp.dto.Person;
import com.ty.backpackersapp.dto.Login;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.service.impl.PersonServiceImpl;

@RestController
public class PersonController {
	
	@Autowired
	PersonServiceImpl personServiceImpl;

	@PostMapping("/persons")
	public ResponseStructure<Person> savePerson(@RequestBody Person person) {

		return personServiceImpl.savePerson(person);
	}

	@GetMapping("/persons/{id}")
	public ResponseStructure<Person> getPerson(@PathVariable int id) {
		return personServiceImpl.getPerson(id);
	}
	
	@GetMapping("/persons")
	public ResponseStructure<List<Person>> getAllPerson(){
		return personServiceImpl.getAllPerson();
	}

	@PutMapping("/persons/{id}")
	public ResponseStructure<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
		return personServiceImpl.updatePerson(id, person);
	}

	@DeleteMapping("/persons/{id}")
	public ResponseStructure<String> deletePerson(@PathVariable int id) {
		return personServiceImpl.deletePerson(id);
	}
	
	@PostMapping("/persons/login")
	public ResponseStructure<Person> validatePerson(@RequestBody Login login){
		return personServiceImpl.validatePerson(login.getEmail(), login.getPassword());
	}
}
