package com.Main.Customer;

import java.util.Scanner;

import com.DaoBean.Customer;
import com.Service.CustomerService;

public class updateCustomer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id to update : ");
		int id = sc.nextInt();
		System.out.println("Enter Customer Name to update : ");
		String name=sc.next();
		Customer customer = new Customer();
		customer.setCustomer_id(id);
		customer.setCustomer_name(name);

		CustomerService customerService = new CustomerService();
		customerService.update(customer);
		System.out.println("Customer updated successfully..");
	}
}
