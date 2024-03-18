package com.Main.Admin;

import java.util.List;

import com.DaoBean.Landlord;
import com.Service.AdminService;

public class readAllApprovedLandlord {
	public static void main(String[] args) {
	AdminService adminService = new AdminService();
	System.out.println("All ApprovedLandlords are : ");
	List<Landlord> landlord2 = adminService.readAllApprovedLandlords();{
	for (Landlord landlord : landlord2) {
		System.out.println("------------------------------------------------");
		System.out.println("Landlord Id : " + landlord.getId());
		System.out.println("Landlord Name : " + landlord.getName());
		System.out.println("Landlord Address : "+ landlord.getAddress());
		System.out.println("Landlord Status : " + landlord.getStatus());
		System.out.println("-------------------------------------------------");
	}
}
}
}