package com.ty.backpackersapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.backpackersapp.dao.PersonDao;
import com.ty.backpackersapp.dto.Person;
import com.ty.backpackersapp.repository.PersonRepository;
@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public Person savePerson(Person person) {
		
		return personRepository.save(person);
	}

	@Override
	public Person getPerson(int id) {
		
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Person> getAllPerson() {
		
		return personRepository.findAll();
	}

	@Override
	public Person updatePerson(int id, Person person) {

		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			return personRepository.save(person);
		}else {
			return null;
		}
	}

	@Override
	public boolean deletePerson(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			 personRepository.delete(optional.get());
			 return true;
		}else {
			return false;
		}
	}

	@Override
	public Person validatePerson(String email, String password) {
		
		return personRepository.validatePerson(email, password);
	}

}
