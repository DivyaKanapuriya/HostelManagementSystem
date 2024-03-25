package com.Main.Customer;

import java.util.Scanner;

import com.Modal.Customer;
import com.Service.CustomerService;

public class CreateCustomer {
	public static void main(String[] args) {
		System.out.println("Enter Customer Name : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.println("Enter Customer Phone no. : ");
		String phone = sc.next();
		System.out.println("Enter Customer Aadhar no. : ");
		String aadhar = sc.next();
		Customer customer = new Customer();

		customer.setCustomer_name(name);
		customer.setCustomer_phone_num(phone);
		customer.setCustomer_aadhar_num(aadhar);
		customer.setCustomer_login_pass(name + 123);
		customer.setCustomer_login_id(name);
		CustomerService customerService = new CustomerService();
		customerService.create(customer);
		System.out.println("Customer saved successfully..");
	}
}
