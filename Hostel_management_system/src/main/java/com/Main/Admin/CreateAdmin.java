package com.Main.Admin;

import com.Modal.Admin;
import com.Service.AdminService;
import java.util.Scanner;

public class CreateAdmin {
	public static void main(String[] args) {
		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println(" ------------Create New Admin --------------");
		System.out.println("Enter New Admin name");
		String name = sc.nextLine();
		admin.setAdmin_name(name);
		System.out.println("Enter Admin Email");
		String email = sc.nextLine();
		admin.setEmail_id(email);
		admin.setLogin_id(email);
		admin.setLogin_pass(name);

		AdminService adminService = new AdminService();
		adminService.create(admin);
		System.out.println("Admin created successfully");

	}

}
