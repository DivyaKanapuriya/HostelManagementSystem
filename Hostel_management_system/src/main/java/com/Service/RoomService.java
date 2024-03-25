package com.Service;

import java.util.ArrayList;
import java.util.List;

import com.Dao.RoomDao;
import com.Modal.Customer;
import com.Modal.Room;

public class RoomService {
	RoomDao roomDao = new RoomDao();

	// create room
	public void create(Room room) {
		roomDao.create(room);
	}

	// update room
	public void update(Room room) {
		roomDao.update(room);
	}

	// delete room by Id
	public void deleteById(int id) {
		roomDao.delete(id);
	}

	// read room by Id
	public Room readById(int id) {
		return roomDao.readById(id);
	}

	// read all room list by Hostel Id
	public List<Room> readAllRoomByHostelId(int id) {
		List<Room> rooms = roomDao.readAllRoom();
		List<Room> roomsAl = new ArrayList<Room>();
		for (Room room : rooms) {
			if ((room.getHostel() != null) && room.getHostel().getHostel_id() == id) {
				roomsAl.add(room);
			}
		}
		return roomsAl;
	}

	// read all rooms details
	public List<Room> readAllRooms() {
		return roomDao.readAllRoom();
	}

	// read customer by room Id
	public Customer readCustomerByRoomId(int id) {
		Room room = roomDao.readById(id);
		return room.getCustomer();
	}
}
