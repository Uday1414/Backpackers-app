package com.ty.backpackersapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.PersonDaoImpl;
import com.ty.backpackersapp.dto.Person;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonDaoImpl personDaoImpl;

	@Override
	public ResponseStructure<Person> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		Person person2 = personDaoImpl.savePerson(person);
		if(person2!=null) {
			responseStructure.setData(person2);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Person> getPerson(int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		Person person = personDaoImpl.getPerson(id);
		if(person!=null) {
			responseStructure.setData(person);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Person>> getAllPerson() {
		ResponseStructure<List<Person>> responseStructure = new ResponseStructure<List<Person>>();
		List<Person> persons = personDaoImpl.getAllPerson();
		if(persons.size()>0) {
			responseStructure.setData(persons);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException("No Persons Found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Person> updatePerson(int id, Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		Person person1 = personDaoImpl.updatePerson(id, person);
		if(person1!=null) {
			responseStructure.setData(person1);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<String> deletePerson(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Person person = personDaoImpl.getPerson(id);
		if(person!=null) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Person> validatePerson(String email, String password) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		Person person = personDaoImpl.validatePerson(email, password);
		if(person!=null) {
			responseStructure.setData(person);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("valid");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

}
