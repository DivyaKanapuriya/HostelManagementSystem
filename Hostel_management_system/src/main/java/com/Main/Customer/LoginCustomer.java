package com.Main.Customer;

import java.util.Scanner;

import com.Modal.Customer;
import com.Service.CustomerService;

public class LoginCustomer {
	public static Boolean login() {
		Boolean status = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username :");
		String uname = sc.next();
		System.out.println("Enter Password :");
		String pass = sc.next();
		CustomerService cusService = new CustomerService();
		try {
			Customer customer = cusService.loginCustomer(uname, pass);
			status = true;
			System.out.println("--------------------------------------------------------");
			System.out.println("    WELCOME " + customer.getCustomer_name());
			System.out.println("--------------------------------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}
