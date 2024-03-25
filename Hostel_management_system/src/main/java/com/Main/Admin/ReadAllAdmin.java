package com.Main.Admin;

import java.util.List;

import com.Modal.Admin;
import com.Service.AdminService;

public class ReadAllAdmin {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		System.out.println("All Admin List is written here : ");
		List<Admin> admins = adminService.readAllAdmin();
		for (Admin admin : admins) {
			System.out.println("----------------------------------------------");
			System.out.println("Admin id : " + admin.getAdmin_id());
			System.out.println("Admin name : " + admin.getAdmin_name());
			System.out.println("Admin Email : " + admin.getEmail_id());
			System.out.println("----------------------------------------------");
		}
	}
}