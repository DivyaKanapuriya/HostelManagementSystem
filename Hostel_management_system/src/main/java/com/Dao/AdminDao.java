package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Modal.Admin;
import com.Modal.Landlord;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// create new admin
	public void create(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
    
	// login Admin
	public Admin loginAdmin(String username, String password) {
		// Query to find admin by username
		Query query = entityManager.createQuery("SELECT a FROM Admin a WHERE a.login_id = :login_id");
		query.setParameter("login_id", username);
		Admin admin = null;
		try {
			admin = (Admin) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("admin not found");
			return null;
		}
		// Verify password
		if (admin.getLogin_pass().equals(password)) {
			return admin; // Login successful
		} else {
			return null; // Password incorrect
		}
	}

	// update admin by admin Id
	public void update(Admin admin) {
		Admin admin1 = entityManager.find(Admin.class, admin.getAdmin_id());
		if (admin1 != null) {
			entityTransaction.begin();
			if (admin.getAdmin_name() != null) {
				admin1.setAdmin_name(admin.getAdmin_name());
			}
			if (admin.getEmail_id() != null) {
				admin1.setEmail_id(admin.getEmail_id());
			}
			if (admin.getLandlords() != null) {
				admin1.setLandlords(admin.getLandlords());
			}

			entityManager.merge(admin1);
			entityTransaction.commit();
		}
	}

	// Read admin by Id
	public Admin readById(int id) {
		return entityManager.find(Admin.class, id);
	}

	// Read List of admin
	public List<Admin> readAllAdmin() {
		String sql = "Select s From Admin s";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		return admins;
	}

	// Delete admin by Id
	public void delete(int id) {
		Admin admin1 = entityManager.find(Admin.class, id);
		if (admin1 != null) {
			entityTransaction.begin();
			entityManager.remove(admin1);
			entityTransaction.commit();
		}
	}

}