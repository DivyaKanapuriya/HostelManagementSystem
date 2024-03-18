package com.Service;

import java.util.ArrayList;
import java.util.List;

import com.DaoBean.Customer;
import com.DaoBean.Room;
import com.dao.RoomDao;




	public class RoomService {
		RoomDao roomDao = new RoomDao();

		public void create(Room room) {
			roomDao.create(room);
		}

		public void update(Room room) {
			roomDao.update(room);
		}

		public void deleteById(int id) {
			roomDao.delete(id);
		}

		public Room readById(int id) {
			return roomDao.readById(id);
		}

		public List<Room> readAllRoomByHostelId(int id) {
			List<Room> rooms = roomDao.readAllRoom();
			List<Room> roomsAl = new ArrayList<Room>();

			for (Room room : rooms) {
				if ((room.getHostel() != null ) && room.getHostel().getHostel_id() == id) {
					roomsAl.add(room);
				}
			}
			return roomsAl;
		}


		public List<Room> readAllRooms() {
			return roomDao.readAllRoom();
		}

		public Customer readCustomerByRoomId(int id) {
			Room room = roomDao.readById(id);
			return room.getCustomer();
		}
	}


