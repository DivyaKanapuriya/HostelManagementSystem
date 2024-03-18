package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DaoBean.Admin;
import com.DaoBean.Hostel;

public class HostelDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void create(Hostel hostel) {
		entityTransaction.begin();
		entityManager.persist(hostel);
		entityTransaction.commit();
	}

	public void update(Hostel hostel) {
		Hostel hostel2 = entityManager.find(Hostel.class, hostel.getHostel_id());
		if (hostel2 != null) {
			entityTransaction.begin();
			if (hostel.getHostel_name() != null) {
				hostel2.setHostel_name(hostel.getHostel_name());
			}
			if (hostel.getHostel_location() != null) {
				hostel2.setHostel_location(hostel.getHostel_location());
			}

			if (hostel.getNum_of_rooms() != null) {
				hostel2.setNum_of_rooms(hostel.getNum_of_rooms());
			}
			if (hostel.getRating() != null) {
				hostel2.setRating(hostel.getRating());
			}
			if (hostel.getLandlord() != null) {
				hostel2.setLandlord(hostel.getLandlord());
			}
			if (hostel.getRoom() != null) {
				hostel2.setRoom(hostel.getRoom());
			}

			entityManager.merge(hostel2);
			entityTransaction.commit();
		}

	}

	public void delete(int id) {
		Hostel hostel2 = entityManager.find(Hostel.class, id);
		entityTransaction.begin();
		entityManager.remove(hostel2);
		entityTransaction.commit();
	}

	public Hostel readhostelById(int id) {
		return entityManager.find(Hostel.class, id);
	}

	public List<Hostel> readAllHostel(){
		String sql = "Select s from Hostel s";
		Query query = entityManager.createQuery(sql);
		List<Hostel> hostels = query.getResultList();
		return hostels;
	}


}
