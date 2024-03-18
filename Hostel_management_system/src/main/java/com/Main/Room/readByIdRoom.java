package com.Main.Room;

import java.util.Scanner;

import com.DaoBean.Room;
import com.Service.RoomService;

public class readByIdRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room Id to get details : ");
		int room_id = sc.nextInt();

		RoomService roomService = new RoomService();

		Room room = roomService.readById(room_id);
		System.out.println("-------------------------------------");
	    System.out.println("Id : "+ room.getRoom_id());
		System.out.println("Price : " +room.getRoom_price());
		System.out.println("Status : " + room.getRoom_status());
		System.out.println("Hostel id is " + room.getHostel());
		System.out.println("Customer id is " + room.getCustomer());
		System.out.println("--------------------------------------");
	}

}

