package com.Main.Room;

import java.util.Scanner;

import com.Modal.Room;
import com.Service.RoomService;

public class CreateRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- Add new Room ----- ");
		System.out.println("Enter price : ");
		String price = sc.next();
		System.out.println("Enter status");
		String status = sc.next();

		Room room = new Room();
		room.setRoom_price(Double.parseDouble(price));
		room.setRoom_status(status);

		RoomService roomService = new RoomService();
		roomService.create(room);
		System.out.println("Room created Successfully..");
	}
}
