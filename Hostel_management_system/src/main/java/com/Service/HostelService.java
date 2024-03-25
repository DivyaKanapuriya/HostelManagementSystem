package com.Service;

import java.util.ArrayList;
import java.util.List;
import com.Dao.HostelDao;
import com.Modal.Hostel;
import com.Modal.Room;

public class HostelService {
	HostelDao hostelDao = new HostelDao();
	RoomService roomService = new RoomService();

	// create hostel
	public void create(Hostel hostel) {
		hostelDao.create(hostel);
	}

	// update hostel
	public void update(Hostel hostel) {
		hostelDao.update(hostel);
	}

	// delete hostel by id
	public void delete(int id) {
		Hostel hostel = hostelDao.readhostelById(id);
		for (Room room : hostel.getRoom()) {
			roomService.deleteById(room.getRoom_id());
		}
		hostelDao.delete(id);
	}

	// read all hostel list
	public List<Hostel> readAllhostel() {
		List<Hostel> hostels = new ArrayList<Hostel>();
		for (Hostel hostel : hostelDao.readAllHostel()) {
			hostels.add(hostel);
		}
		return hostels;
	}

	// read all hostel by landlordid
	public List<Hostel> readAllhostelbyLandlordId(int id) {
		List<Hostel> hostels = new ArrayList<Hostel>();
		for (Hostel hostel : hostelDao.readAllHostel()) {
			if (hostel.getLandlord() != null) {
				hostels.add(hostel);
			}
		}
		return hostels;
	}

	// read hostel by id
	public Hostel readById(int id) {
		return hostelDao.readhostelById(id);
	}

	// add rooms by hostel Id
	public void addRoomsByhostelId(int id, Hostel hostel) {
		Hostel hostel2 = hostelDao.readhostelById(hostel.getHostel_id());
		if (hostel2.getLandlord() != null) {
			Room room = roomService.readById(id);
			room.setHostel(hostel);
			ArrayList<Room> rooms = new ArrayList<Room>();
			rooms.add(room);
			hostel.setRoom(rooms);
			hostelDao.update(hostel);
			roomService.update(room);
		} else {
			System.out.println("hostel Is Not Approved");
		}
	}

	// read all rooms by hostel id
	public List<Room> readAllRoomsByhostelId(int id) {
		return roomService.readAllRoomByHostelId(id);
	}

}
