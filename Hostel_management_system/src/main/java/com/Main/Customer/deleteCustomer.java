package com.Main.Customer;

import com.Service.CustomerService;
import java.util.*;

public class deleteCustomer {
	public static void main(String[] args) {
		System.out.println("Enter Customer id to delete");
		Scanner sc = new Scanner(System.in);
		int customer_id = sc.nextInt();
		CustomerService customerService = new CustomerService();
		customerService.delete(customer_id);
		System.out.println("Customer deleted successfully");

	}
}
