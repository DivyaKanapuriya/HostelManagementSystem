package com.Main.Landlord;

import java.util.Scanner;

import com.Modal.Landlord;
import com.Service.LandlordService;

public class AddHostelById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Landlord id : ");
		int id = sc.nextInt();
		System.out.println("Enter Hostel id : ");
		int hostel_id = sc.nextInt();
		Landlord landLord = new Landlord();
		landLord.setId(id);
		LandlordService landlordService = new LandlordService();
		landlordService.addHostelById(hostel_id, landLord);
	}
}
