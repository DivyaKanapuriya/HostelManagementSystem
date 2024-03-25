package com.Main.Admin;

import com.Service.AdminService;
import java.util.Scanner;

public class DeleteAdmin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin id to Delete : ");
		int admin_id = sc.nextInt();

		AdminService adminService = new AdminService();
		adminService.delete(admin_id);
		System.out.println("Admin deleted successfully..");

	}
}
