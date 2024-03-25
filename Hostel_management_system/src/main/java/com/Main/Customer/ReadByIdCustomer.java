package com.Main.Customer;

import java.util.Scanner;

import com.Modal.Customer;
import com.Service.CustomerService;

public class ReadByIdCustomer {
	public static void main(String[] args) {
		System.out.println("Enter Customer Id : ");
		Scanner sc = new Scanner(System.in);

		int customer_id = sc.nextInt();
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.readById(customer_id);
		System.out.println("---------------------------------------------");
		System.out.println("Customer Id : " + customer.getCustomer_id());
		System.out.println("Customer Name : " + customer.getCustomer_name());
		System.out.println("Customer Phone no. : " + customer.getCustomer_phone_num());
		System.out.println("Customer Aadhar no. : " + customer.getCustomer_aadhar_num());
		System.out.println("--------------------------------------------");
	}
}
