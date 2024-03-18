package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DaoBean.Admin;
import com.DaoBean.Landlord;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void create(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}

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

	public Admin readById(int id) {
		return entityManager.find(Admin.class, id);
	}

	public List<Admin> readAllAdmin() {
		String sql = "Select s From Admin s";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		return admins;
	}

	public void delete(int id) {
		Admin admin1 = entityManager.find(Admin.class, id);
		if (admin1 != null) {
			entityTransaction.begin();
			entityManager.remove(admin1);
			entityTransaction.commit();
		}
	}

}