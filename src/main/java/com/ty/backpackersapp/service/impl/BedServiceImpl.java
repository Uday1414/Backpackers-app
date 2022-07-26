package com.ty.backpackersapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.BedDaoImpl;
import com.ty.backpackersapp.dao.impl.RoomDaoImpl;
import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Room;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.service.BedService;
@Service
public class BedServiceImpl implements BedService{
	
	@Autowired
	BedDaoImpl bedDaoImpl ;
	
	@Autowired
	RoomDaoImpl roomDaoImpl;

	@Override
	public ResponseStructure<Bed> saveBed(Bed bed , int id) {
		ResponseStructure<Bed> responseStructure = new ResponseStructure<>();
		Room room = roomDaoImpl.getRoom(id);
		room.setNo_of_beds(room.getNo_of_beds()+1);
		bed.setRoom(room);
		Bed bed2 = bedDaoImpl.saveBed(bed);
		if(bed2!=null) {
			responseStructure.setData(bed2);
			responseStructure.setMessage("Saved");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
		}else {
			throw new NoIdFoundException("No Data saved");
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<Bed> getBed(int id) {
		ResponseStructure<Bed> responseStructure = new ResponseStructure<>();
		Bed bed= bedDaoImpl.getBed(id);
		if(bed!=null) {
			responseStructure.setData(bed);
			responseStructure.setMessage("Saved");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
		}else {
			throw new NoIdFoundException("No bed with id "+id);
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Bed>> getAllBed() {
		ResponseStructure<List<Bed>> responseStructure = new ResponseStructure<>();
		List<Bed> beds = bedDaoImpl.getAllBed();
		if(beds.size()>0) {
			responseStructure.setData(beds);
			responseStructure.setMessage("Saved");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
		}else {
			throw new NoIdFoundException("No beds saved");
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<Bed> updateBed(int id, Bed bed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<String> deleteBed(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
