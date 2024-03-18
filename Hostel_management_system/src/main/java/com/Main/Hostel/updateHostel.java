package com.Main.Hostel;

import java.util.Scanner;

import com.DaoBean.Hostel;
import com.DaoBean.Landlord;
import com.Service.HostelService;
import com.Service.LandlordService;

public class updateHostel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Hostel Id which should be updated : ");
	    int id = sc.nextInt(); 
	    System.out.println("Enter location : ");
	    String location = sc.next();
	    System.out.println("Enter no. of rooms to update");
	    int room = sc.nextInt();
	    System.out.println("Enter Hostel Name to update : ");
	    String name = sc.next();
	    
	    
	    
	    Hostel hostel = new Hostel();
	    hostel.setHostel_id(id);
	    hostel.setHostel_name(name);
	    hostel.setHostel_location(location);
	    hostel.setNum_of_rooms(room);
	    
	    HostelService hostelservice = new HostelService();
	    hostelservice.update(hostel);
	    System.out.println("Hostel updated successfully..");
	   
}
}
