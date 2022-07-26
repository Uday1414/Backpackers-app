package com.ty.backpackersapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.backpackersapp.dao.impl.RoomDaoImpl;
import com.ty.backpackersapp.dao.impl.StayDaoImpl;
import com.ty.backpackersapp.dto.Bed;
import com.ty.backpackersapp.dto.ResponseStructure;
import com.ty.backpackersapp.dto.Room;
import com.ty.backpackersapp.dto.Stay;
import com.ty.backpackersapp.exception.NoIdFoundException;
import com.ty.backpackersapp.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDaoImpl roomDaoImpl;

	@Autowired
	StayDaoImpl stayDaoImpl;

	@Override
	public ResponseStructure<Room> saveRoom(Room room, int id) {
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		Stay stay = stayDaoImpl.getStay(id);
		if (stay.getStatus().equals("approved")) {
			room.setStay(stay);
			List<Bed> beds = room.getBeds();
			int a=0;
			if(beds!=null) {
			for (Bed bed : beds) {
				bed.setRoom(room);
				a++;
				
			}
			}
			room.setNo_of_beds(a);
			Room room2 = roomDaoImpl.saveRoom(room);

			if (room2 != null) {
				responseStructure.setData(room2);
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Success");
			} else {
				throw new NoIdFoundException();
			}
		} else {
			throw new NoIdFoundException("Stay is not approved yet");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Room> getRoom(int id) {
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		Room room = roomDaoImpl.getRoom(id);

		if (room != null) {
			responseStructure.setData(room);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException();
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Room>> getAllRoom() {
		ResponseStructure<List<Room>> responseStructure = new ResponseStructure<List<Room>>();
		List<Room> rooms = roomDaoImpl.getAllRoom();
		if (rooms.size() > 0) {
			responseStructure.setData(rooms);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
		} else {
			throw new NoIdFoundException("No stays Found");
		}
		return responseStructure;
	}

	@Override
	public ResponseStructure<Room> updateRoom(int id, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<String> deleteRoom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
