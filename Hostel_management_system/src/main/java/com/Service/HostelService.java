package com.Service;

import java.util.ArrayList;
import java.util.List;

import com.DaoBean.Hostel;
import com.DaoBean.Room;
import com.dao.HostelDao;



public class HostelService{
	HostelDao hostelDao = new HostelDao();
	RoomService roomService = new RoomService();
	public void create(Hostel hostel) {
		hostelDao.create(hostel);
	}
	
	public void update(Hostel hostel) {
		hostelDao.update(hostel);
	}

    public void delete(int id) {
    	Hostel hostel  = hostelDao.readhostelById(id);
    	for(Room room : hostel.getRoom()){
    	  roomService.deleteById(room.getRoom_id());
    	  }
    	 
    	hostelDao.delete(id);
    }
    public List<Hostel> readAllhostel() {
		List<Hostel> hostels = new ArrayList<Hostel>();
		for (Hostel hostel : hostelDao.readAllHostel()) {
		   hostels.add(hostel);
	}
		return hostels;
	}
    public List<Hostel> readAllhostelbyLandlordId(int id) {
		List<Hostel> hostels = new ArrayList<Hostel>();
		for (Hostel hostel : hostelDao.readAllHostel()) {
			if(hostel.getLandlord() != null) {
				hostels.add(hostel);
			}
		}
		return hostels;
	}
    public Hostel readById(int id) {
		return hostelDao.readhostelById(id);
	}

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
	
	public List<Room> readAllRoomsByhostelId(int id) {
		return roomService.readAllRoomByHostelId(id);
	}

}

 

