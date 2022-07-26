package com.ty.backpackersapp.dao;

import java.util.List;

import com.ty.backpackersapp.dto.Person;

public interface PersonDao {
	Person savePerson(Person person);
	Person getPerson(int id);
	List<Person> getAllPerson();
	Person updatePerson(int id, Person person);
	boolean deletePerson(int id);
	Person validatePerson(String email, String password);
}
