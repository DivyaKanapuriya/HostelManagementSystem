package com.Main.Customer;

import java.util.List;

import com.DaoBean.Customer;
import com.Service.CustomerService;

public class readByAllCustomer {
   public static void main(String[] args) {
	   System.out.println(" All Customers List :");
	   CustomerService customerService = new CustomerService();
	   List<Customer> customers = customerService.readAllCustomer();
	   for(Customer customer : customers) {
		   System.out.println("-----------------------------------------------");
		   System.out.println("Customer Id : " + customer.getCustomer_id());
		   System.out.println("Customer Name : " + customer.getCustomer_name());
		   System.out.println("Customer aadhar : " + customer.getCustomer_aadhar_num());
		   System.out.println("Customer phone no : " + customer.getCustomer_phone_num());
		   System.out.println("-----------------------------------------------");
		   
	   }
}
}