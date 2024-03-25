package com.Main.Landlord;

import java.util.Scanner;

import com.Service.LandlordService;

public class DeleteLandlord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter landlord id to delete :");
		int id = sc.nextInt();
		LandlordService landlordService = new LandlordService();
		landlordService.delete(id);
		System.out.println("Landlord deletd Successfully..");
	}
}
