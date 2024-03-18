package com.Main.Landlord;

import java.util.List;

import com.Service.LandlordService;
import com.DaoBean.Landlord;



public class readAllLandlord {
	
		public static void main(String[] args) {
			System.out.println("All landlord List : ");
			LandlordService landlordService = new LandlordService();
			List<Landlord> landlord = landlordService.readAllLandlord();
			for (Landlord landlord2 : landlord) {
				System.out.println("-----------------------------------------");
				System.out.println("Id : " + landlord2.getId());
				System.out.println("Name : " + landlord2.getName());
				System.out.println("Address : " + landlord2.getAddress());
				System.out.println("Status : " + landlord2.getStatus());
				System.out.println("-----------------------------------------");
			}
		}
	}

