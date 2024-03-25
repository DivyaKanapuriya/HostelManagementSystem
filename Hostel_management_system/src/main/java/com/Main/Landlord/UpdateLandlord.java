package com.Main.Landlord;

import java.util.Scanner;

import com.Modal.Landlord;
import com.Service.LandlordService;

public class UpdateLandlord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Landlord Id which should be updated : ");
		int id = sc.nextInt();
		System.out.println("Enter Landlord Name to update : ");
		String name = sc.next();
		System.out.println("Enter Landlord address to update : ");
		String address = sc.next();

		Landlord landlord = new Landlord();
		landlord.setId(id);
		landlord.setName(name);
		landlord.setAddress(address);

		LandlordService landlordService = new LandlordService();
		landlordService.update(landlord);
		System.out.println("Landlord updated successfully..");
	}
}
