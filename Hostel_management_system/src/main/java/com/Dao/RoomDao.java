package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Modal.Room;

public class RoomDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// create room
	public void create(Room room) {
		entityTransaction.begin();
		entityManager.persist(room);
		entityTransaction.commit();
	}

	// update room by id
	public void update(Room room) {
		Room room2 = entityManager.find(Room.class, room.getRoom_id());
		entityTransaction.begin();
		if (room2 != null) {
			if (room.getRoom_price() != null) {
				room2.setRoom_price(room.getRoom_price());
			}
			if (room.getRoom_status() != null) {
				room2.setRoom_status(room.getRoom_status());
			}
			if (room.getHostel() != null) {
				room2.setHostel(room.getHostel());
			}
			room2.setCustomer(room.getCustomer());
			entityManager.merge(room2);
			entityTransaction.commit();
		}
	}

	// delete room by id
	public void delete(int id) {
		Room room2 = entityManager.find(Room.class, id);
		if (room2 != null) {
			entityTransaction.begin();
			entityManager.remove(room2);
			entityTransaction.commit();
		}
	}

	// read room by id
	public Room readById(int id) {
		return entityManager.find(Room.class, id);
	}

	// read all room list
	public List<Room> readAllRoom() {
		String sql = "Select s From Room s";
		Query query = entityManager.createQuery(sql);
		List<Room> rooms = query.getResultList();
		return rooms;
	}
}
