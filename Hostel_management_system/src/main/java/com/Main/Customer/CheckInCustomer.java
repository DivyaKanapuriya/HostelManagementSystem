package com.Main.Customer;

import java.util.ArrayList;

import com.Modal.Room;
import com.Service.CustomerService;

import java.util.Scanner;

public class CheckInCustomer {
	public static void main(String[] args) {
		System.out.println("Enter Customer Id : ");
		Scanner sc = new Scanner(System.in);
		int customer_id = sc.nextInt();
		System.out.println("Enter room1 id : ");

		int room = sc.nextInt();
		Room room1 = new Room();
		room1.setRoom_id(room);
		System.out.println("Enter room2 id : ");
		Room room2 = new Room();
		int rm = sc.nextInt();
		room2.setRoom_id(rm);
		System.out.println("Enter room3 id : ");
		Room room3 = new Room();
		int rm3 = sc.nextInt();
		room3.setRoom_id(rm3);
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);

		CustomerService customerService = new CustomerService();

		System.out.println(customerService.checkIn(customer_id, rooms));
	}
}
