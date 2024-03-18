package com.Main.Room;

import java.util.List;
import java.util.Scanner;

import com.DaoBean.Room;
import com.Service.HostelService;



public class readAllRoomByHostelId {
	public static void main(String[] args) {
		System.out.println("Read All Rooms By hostel Id : ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter hostel id :");
		int hostel_id = sc.nextInt();

		HostelService hostelService = new HostelService();
		List<Room> rooms = hostelService.readAllRoomsByhostelId(hostel_id);

		for (Room room : rooms) {
			System.out.println("----------------------------------------------");
			System.out.println("Id : " +room.getRoom_id());
			System.out.println("Price : "+  room.getRoom_price());
			System.out.println("Status : " +room.getRoom_status());
			System.out.println("hostel id is " + room.getHostel().getHostel_id());
			System.out.println("-----------------------------------------------");
		}
	}
}
