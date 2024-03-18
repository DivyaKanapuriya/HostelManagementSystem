package com.Main.Hostel;

import java.util.List;
import java.util.Scanner;

import com.DaoBean.Hostel;
import com.DaoBean.Room;
import com.Service.HostelService;
import com.Service.LandlordService;



public class readAllHostelbyLandlord {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Read All hostels by Landlord Id : ");
		System.out.println("Enter Landlord Id :");
		int hostel_id = sc.nextInt();
		HostelService hostelservice = new HostelService();
		List<Hostel> hostels = hostelservice.readAllhostelbyLandlordId(hostel_id);
     	for (Hostel Hostel : hostels) {
				System.out.println("------------------------------------------");
				System.out.println("Hostel Id = " + Hostel.getHostel_id());
				System.out.println("Hostel name = " + Hostel.getHostel_name());
				System.out.println("Location = "+ Hostel.getHostel_location());
				System.out.println("Number of Room = " + Hostel.getNum_of_rooms());
				System.out.println("Hostel rating = " + Hostel.getRating());
				System.out.println("--------------------------------------------");
			}
		}
		

	}

	

