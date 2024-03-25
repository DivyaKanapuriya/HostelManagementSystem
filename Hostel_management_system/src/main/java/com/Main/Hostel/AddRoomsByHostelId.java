package com.Main.Hostel;

import java.util.Scanner;

import com.Modal.Hostel;
import com.Service.HostelService;

public class AddRoomsByHostelId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Hostel id : ");

		int hotelid = sc.nextInt();
		System.out.println("Enter room id");
		int room_id = sc.nextInt();
		Hostel hotel = new Hostel();
		hotel.setHostel_id(hotelid);
		HostelService hotelService = new HostelService();
		hotelService.addRoomsByhostelId(room_id, hotel);
		System.out.println("Room added successfully..");
	}
}
