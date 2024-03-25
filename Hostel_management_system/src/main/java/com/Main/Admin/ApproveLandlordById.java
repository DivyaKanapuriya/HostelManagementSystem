package com.Main.Admin;

import com.Modal.Admin;
import com.Service.AdminService;
import java.util.Scanner;

public class ApproveLandlordById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Landlord Id : ");
		int landlord_id = sc.nextInt();
		System.out.println("Enter admin Id : ");
		int admin_id = sc.nextInt();
		Admin admin = new Admin();
		admin.setAdmin_id(admin_id);
		AdminService adminService = new AdminService();
		adminService.approveLandlordById(landlord_id, admin);
		System.out.println("Landlord approved successfully..");
	}
}
