package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Modal.Landlord;

public class LandlordDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// create landlord
	public void create(Landlord landlord) {
		entityTransaction.begin();
		entityManager.persist(landlord);
		entityTransaction.commit();
	}

	// update landlord by id
	public void update(Landlord landlord) {
		Landlord landlord2 = entityManager.find(Landlord.class, landlord.getId());
		if (landlord2 != null) {
			entityTransaction.begin();
			if (landlord.getName() != null) {
				landlord2.setName(landlord.getName());
			}
			if (landlord.getAddress() != null) {
				landlord2.setAddress(landlord.getAddress());
			}

			if (landlord.getHostels() != null) {
				landlord2.setHostels(landlord.getHostels());
			}
			if (landlord.getAdmin() != null) {
				landlord2.setAdmin(landlord.getAdmin());
			}

			entityManager.merge(landlord2);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}

	// delete landlord by id
	public void delete(int id) {
		Landlord landlord2 = entityManager.find(Landlord.class, id);
		if (landlord2 != null) {
			entityTransaction.begin();
			entityManager.remove(landlord2);
			entityTransaction.commit();
		}
	}

	// read landlord by id
	public Landlord readById(int id) {
		return entityManager.find(Landlord.class, id);
	}

	// read List of landlord
	public List<Landlord> readAllLandlord() {
		String sql = "select e from Landlord e";
		Query query = entityManager.createQuery(sql);
		List<Landlord> landlords = query.getResultList();
		return landlords;
	}
}
