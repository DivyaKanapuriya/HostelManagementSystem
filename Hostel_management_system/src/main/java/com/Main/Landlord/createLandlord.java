package com.Main.Landlord;

import java.util.Scanner;

import com.DaoBean.Landlord;
import com.Service.LandlordService;

public class createLandlord {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("--Add New Landlord--");
    	System.out.println("Enter new Landlord name : ");
    	String name  = sc.nextLine();
    	System.out.println("Enter Address : ");
    	String address = sc.nextLine();
    	System.out.println("Enter Status : ");
    	String status = sc.nextLine();
    	Landlord ld = new Landlord();
    	ld.setName(name);
    	ld.setAddress(address);
    	ld.setStatus(status);
		
		LandlordService landlordService = new LandlordService();
		
		landlordService.create(ld);
		System.out.println("Landlord created successfully..");

    }
} 	

