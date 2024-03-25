package com.Main.Room;

import java.util.Scanner;

import com.Modal.Customer;
import com.Service.RoomService;

public class ReadCustomerByRoomId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room id");
		int room_id = sc.nextInt();
		RoomService roomService = new RoomService();
		Customer customer = roomService.readCustomerByRoomId(room_id);
		System.out.println("------------------------------------------");
		System.out.println("Customer Id - " + customer.getCustomer_id());
		System.out.println("Customer Name - " + customer.getCustomer_name());
		System.out.println("Phone number - " + customer.getCustomer_phone_num());
		System.out.println("Aadhar Number - " + customer.getCustomer_aadhar_num());
		System.out.println("---------------------------------------------");
	}
}
