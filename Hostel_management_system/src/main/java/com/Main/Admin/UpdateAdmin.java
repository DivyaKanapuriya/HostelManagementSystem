package com.Main.Admin;

import java.util.Scanner;

import com.Modal.Admin;
import com.Service.AdminService;

public class UpdateAdmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter admin id to update : ");
		int id = sc.nextInt();

		System.out.println("Enter admin name to update : ");
		String name = sc.next();
		Admin admin = new Admin();
		admin.setAdmin_id(id);
		admin.setAdmin_name(name);

		AdminService adminService = new AdminService();
		adminService.update(admin);
		System.out.println("Admin updated successfully..");
	}

}
