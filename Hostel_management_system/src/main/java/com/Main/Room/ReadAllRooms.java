package com.Main.Room;

import java.util.List;

import com.Modal.Admin;
import com.Modal.Room;
import com.Service.AdminService;
import com.Service.RoomService;

public class ReadAllRooms {
	public static void main(String[] args) {
		System.out.println("-------------- Read All rooms details -------------");
		RoomService roomService = new RoomService();
		List<Room> rooms = roomService.readAllRooms();
		{
			for (Room room : rooms) {
				System.out.println("--------------------------");
				System.out.println("Id : " + room.getRoom_id());
				System.out.println("Price : " + room.getRoom_price());
				System.out.println("Status : " + room.getRoom_status());
				System.out.println("---------------------------------------");
			}
		}
	}
}
