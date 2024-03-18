package com.Main.Admin;

import com.DaoBean.Admin;
import com.Service.AdminService;
import java.util.Scanner;

public class CreateAdmin {
	public static void main(String[] args) {
		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin name");
		String name = sc.nextLine();
		admin.setAdmin_name(name);
		System.out.println("Enter Admin Email");
		String email = sc.nextLine();
		admin.setEmail_id(email);
        
		
		AdminService adminService = new AdminService();
		adminService.create(admin);
		System.out.println("Admin created successfully");

	}
	
}
