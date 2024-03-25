package com.Main.Admin;

import com.Modal.Admin;
import com.Service.AdminService;

import java.util.Scanner;

public class ReadByIdAdmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get admin details : ");

		int admin_id = sc.nextInt();
		AdminService adminService = new AdminService();

		Admin admin = adminService.readById(admin_id);

		System.out.println("Admin Id : " + admin.getAdmin_id());
		System.out.println("Admin Name : " + admin.getAdmin_name());
		System.out.println("Admin Email : " + admin.getEmail_id());
	}
}
