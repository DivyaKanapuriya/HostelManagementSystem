package com.Main.Landlord;

import com.Modal.Landlord;
import com.Service.LandlordService;

import java.util.Scanner;

public class ReadByIdLandlord {
	public static void main(String[] args) {
		System.out.println(" -------------Read Landlord by Id ------");
		System.out.println("Enter Id to Get details : ");
		Scanner sc = new Scanner(System.in);
		int landlord_id = sc.nextInt();

		LandlordService landlordService = new LandlordService();
		Landlord landlord = landlordService.readById(landlord_id);
		System.out.println("Id : " + landlord.getId());
		System.out.println("Name : " + landlord.getName());
		System.out.println("Address : " + landlord.getAddress());
		System.out.println("Status : " + landlord.getStatus());
	}
}
