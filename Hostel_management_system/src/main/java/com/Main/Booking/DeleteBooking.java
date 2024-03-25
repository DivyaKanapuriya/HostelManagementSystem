package com.Main.Booking;

import java.util.Scanner;

import com.Service.BookingService;

public class DeleteBooking {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter booking id to delete : ");
		int id = sc.nextInt();
		BookingService bookingservice = new BookingService();
		bookingservice.delete(id);
		System.out.println("Booking deleted successfully");
	}

}
