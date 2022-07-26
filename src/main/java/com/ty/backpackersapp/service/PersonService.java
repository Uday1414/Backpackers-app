package com.ty.backpackersapp.service;

import java.util.List;

import com.ty.backpackersapp.dto.Person;
import com.ty.backpackersapp.dto.ResponseStructure;

public interface PersonService {
	
	ResponseStructure<Person> savePerson(Person person);
	ResponseStructure<Person> getPerson(int id);
	ResponseStructure<List<Person>> getAllPerson();
	ResponseStructure<Person> updatePerson(int id, Person person);
	ResponseStructure<String> deletePerson(int id);
	ResponseStructure<Person> validatePerson(String email, String password);
}
