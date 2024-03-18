package com.Main.Room;

import java.util.Scanner;

import com.DaoBean.Room;
import com.Service.RoomService;

public class updateRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter room id to update: ");
		int id = sc.nextInt();
		System.out.println("Enter room price to update : ");
		double price = sc.nextDouble();
		Room room= new Room();
		room.setRoom_id(id);
		room.setRoom_price(price);
		
		RoomService roomService= new RoomService();
		roomService.update(room);
		System.out.println("Room updated successfully..");
	}
	
}
