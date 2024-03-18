package com.Main.Hostel;

import java.util.List;

import com.DaoBean.Hostel;
import com.Service.HostelService;


public class readAllHostel{
public static void main(String[] args) {
	
	HostelService hostelService = new HostelService();
	List<Hostel> hostels = hostelService.readAllhostel();
    System.out.println("All Hostel List is here : ");
	for (Hostel hostel : hostels) {
		System.out.println("------------------------------------------");
		System.out.println("Hostel Id = " + hostel.getHostel_id());
		System.out.println("Hostel name = " + hostel.getHostel_name());
		System.out.println("Location = "+ hostel.getHostel_location());
		System.out.println("Number of Room = " + hostel.getNum_of_rooms());
		System.out.println("Hostel rating = " + hostel.getRating());
		System.out.println("--------------------------------------------");
	}
}

}

