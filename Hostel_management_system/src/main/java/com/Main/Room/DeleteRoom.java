package com.Main.Room;

import java.util.Scanner;

import com.Service.RoomService;

public class DeleteRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room Id to delete : ");
		int room_id = sc.nextInt();
		RoomService roomService = new RoomService();
		roomService.deleteById(room_id);
		System.out.println("Room deletd successfully..");

	}
}
