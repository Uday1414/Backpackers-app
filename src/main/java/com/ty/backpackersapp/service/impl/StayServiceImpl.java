package com.ty.backpackersapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.ManagerDaoImpl;
import com.ty.backpackersapp.dao.impl.StayDaoImpl;
import com.ty.backpackersapp.dto.Manager;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.exception.InvalidCredentialsException;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.service.StayService;
@Service
public class StayServiceImpl implements StayService {

	@Autowired
	StayDaoImpl stayDaoImpl;
	
	@Autowired
	ManagerDaoImpl managerDaoImpl;
	
	@Override
	public ResponseStructure<Stay> saveStay(Stay stay , int id) {
		ResponseStructure<Stay> responseStructure = new ResponseStructure<Stay>();
		Manager manager = managerDaoImpl.getManager(id);
		if(manager.getStay()==null) {
			stay.setManager(manager);
			Stay stay2  = stayDaoImpl.saveStay(stay,id);
			if(stay2!=null) {
				responseStructure.setData(stay2);
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Success");
			}else {
				throw new NoIdFoundException();
			}
		}else {
			throw new InvalidCredentialsException("duplicate Manager");
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<Stay> getStay(int id) {
		ResponseStructure<Stay> responseStructure = new ResponseStructure<Stay>();
		Stay stay  = stayDaoImpl.getStay(id);
		if(stay!=null) {
			responseStructure.setData(stay);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Stay>> getAllStay() {
		ResponseStructure<List<Stay>> responseStructure = new ResponseStructure<List<Stay>>();
		List<Stay> stays = stayDaoImpl.getAllStay();
		if(stays.size()>0) { 
			responseStructure.setData(stays);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException("No stays Found");
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Stay>> showAllStays(){
		ResponseStructure<List<Stay>> responseStructure = new ResponseStructure<List<Stay>>();
		List<Stay> stays= stayDaoImpl.showAllStays();
		if(stays.size()>0) {
			responseStructure.setData(stays);
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
		}else {
			throw new InvalidCredentialsException();
		}
		return responseStructure;
	}
	
	public ResponseStructure<Stay> approveStay(int id){
		ResponseStructure<Stay> responseStructure = new ResponseStructure<Stay>();
		Stay stay  = stayDaoImpl.getStay(id);
		stay.setStatus("approved");
		Stay stay2 = stayDaoImpl.updateStay(id, stay);
		if(stay2!=null) {
			responseStructure.setData(stay2);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		}else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Stay> updateStay(int id, Stay stay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<String> deleteStay(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
