package com.Service;

import com.dao.AdminDao;

import com.DaoBean.Landlord;

import java.util.ArrayList;
import java.util.List;

import com.DaoBean.Admin;


public class AdminService{
	AdminDao adminDao = new AdminDao();
	LandlordService landlordService = new LandlordService();
	public void create(Admin admin) {
		adminDao.create(admin);
	}
	
	public void update(Admin admin) {
		adminDao.update(admin);
	}
	
    public Admin readById(int id) {
 		return adminDao.readById(id);
 	}
     public void delete(int id) {
		Admin admin = adminDao.readById(id);
		for (Landlord landlord : admin.getLandlords()) {
			landlordService.delete(landlord.getId());
			
		}
		adminDao.delete(id);
	}
	

     public List<Admin> readAllAdmin() {
		return adminDao.readAllAdmin();
	 }
     
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

    
	
    

