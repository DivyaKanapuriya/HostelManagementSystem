package com.Controller;

import java.util.ArrayList;
import com.Modal.Admin;
import com.Modal.Landlord;
import com.Service.AdminService;
import com.Service.LandlordService;



public class AdminController {
	public static void main(String[] args) {
	//admin created
	Admin admin = new Admin();
	admin.setAdmin_name("admin");
	admin.setEmail_id("admin@gmail.com");
	admin.setLogin_id("admin@gmail.com");
	admin.setLogin_pass("admin");
	//one admin can create many landlords
	Landlord landlord = new Landlord();
	
	landlord.setName("Nitin");
	landlord.setAddress("Indore");
	landlord.setStatus("Not approved");
	
	Landlord landlord1 = new Landlord();
	landlord1.setName("SNEHA");
	landlord1.setAddress("Mumbai");
	landlord.setStatus("Not approved");

	Landlord landlord2 = new Landlord();
	landlord2.setName("SAHIBA");
	landlord2.setAddress("Bhopal");
	landlord.setStatus("Not approved");
	
	Landlord landlord3 = new Landlord();
	landlord3.setName("Pratik");
	landlord3.setAddress("Kanpur");
	landlord3.setStatus("Not Approved");

	ArrayList<Landlord> landlords = new ArrayList<Landlord>();
	landlords.add(landlord);
	landlords.add(landlord1);
	landlords.add(landlord2);
	landlords.add(landlord3);

	admin.setLandlords(landlords);

	AdminService adminService = new AdminService();
	adminService.create(admin);

	LandlordService landlordService = new LandlordService();
	landlordService.create(landlord);
	landlordService.create(landlord1);
	landlordService.create(landlord2);
	System.out.println("");
	}
}
