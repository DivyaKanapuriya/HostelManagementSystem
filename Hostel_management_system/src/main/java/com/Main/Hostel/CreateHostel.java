package com.Main.Hostel;

import java.util.Scanner;

import com.Modal.Hostel;
import com.Service.HostelService;

public class CreateHostel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Save New GuestHouse :");
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter location : ");
		String location = sc.next();
		System.out.println("Enter No. of Rooms : ");
		int rooms = sc.nextInt();
		System.out.println("Enter Rating : ");
		int rating = sc.nextInt();

		Hostel hostel = new Hostel();
		hostel.setHostel_name(name);
		hostel.setHostel_location(location);
		hostel.setNum_of_rooms(rooms);
		hostel.setRating(rating);

		HostelService hostelService = new HostelService();
		hostelService.create(hostel);

		System.out.println("Hostel created Successfully..");
	}

}
