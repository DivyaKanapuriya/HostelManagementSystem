package com.Main.Hostel;

import java.util.Scanner;

import com.Modal.Hostel;
import com.Service.HostelService;

public class ReadByIdHostel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Hostel Id to get Hostel details : ");
		int hostel_id = sc.nextInt();
		HostelService hostelService = new HostelService();
		Hostel hostel = hostelService.readById(hostel_id);
		System.out.println("----------------------------------------");
		System.out.println("Name : " + hostel.getHostel_name());
		System.out.println("Location : " + hostel.getHostel_location());
		System.out.println("Rating : " + hostel.getRating());
		System.out.println("No. of rooms: " + hostel.getNum_of_rooms());
		System.out.println("-------------------------------------------");
	}
}
