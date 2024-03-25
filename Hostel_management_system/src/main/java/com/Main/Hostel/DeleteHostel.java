package com.Main.Hostel;

import java.util.Scanner;

import com.Service.HostelService;

public class DeleteHostel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Hostel id to delete :");
		int hostel_id = sc.nextInt();
		HostelService hostelService = new HostelService();

		hostelService.delete(hostel_id);

		System.out.println("Hostel deleted successfully..");
	}
}
