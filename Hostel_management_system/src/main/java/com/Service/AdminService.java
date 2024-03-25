package com.Service;

import com.Dao.AdminDao;
import com.Modal.Admin;
import com.Modal.Landlord;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
	AdminDao adminDao = new AdminDao();
	LandlordService landlordService = new LandlordService();

	// create admin
	public void create(Admin admin) {
		adminDao.create(admin);
	}

	// admin login
	public Admin loginAdmin(String username, String password) {
		return adminDao.loginAdmin(username, password);
	}

	// update admin
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	// read admin
	public Admin readById(int id) {
		return adminDao.readById(id);
	}

	// delete admin
	public void delete(int id) {
		Admin admin = adminDao.readById(id);
		for (Landlord landlord : admin.getLandlords()) {
			landlordService.delete(landlord.getId());
		}
		adminDao.delete(id);
	}

	// read all admin list
	public List<Admin> readAllAdmin() {
		return adminDao.readAllAdmin();
	}

	// read all unapproved landlords
	public List<Landlord> readAllUnapprovedLandlords() {
		List<Landlord> landlords = landlordService.readAllLandlord();
		List<Landlord> landlords2 = new ArrayList<Landlord>();

		for (Landlord landlord : landlords) {
			if (landlord.getStatus().equalsIgnoreCase("Not Approved")) {
				landlords2.add(landlord);
			}
		}
		return landlords2;
	}

	// read all approved landlords
	public List<Landlord> readAllApprovedLandlords() {
		List<Landlord> landlords = landlordService.readAllLandlord();
		List<Landlord> landlords2 = new ArrayList<Landlord>();

		for (Landlord landlord : landlords) {
			if (landlord.getStatus().equalsIgnoreCase("Approved")) {
				landlords2.add(landlord);
			}
		}
		return landlords2;
	}

	// Approve landlord by id
	public void approveLandlordById(int id, Admin admin) {

		Landlord landlord = landlordService.readById(id);
		landlord.setAdmin(admin);
		landlord.setStatus("APPROVED");

		ArrayList<Landlord> landLords = new ArrayList<Landlord>();
		landLords.add(landlord);

		admin.setLandlords(landLords);

		adminDao.update(admin);
		landlordService.update(landlord);
	}

}
