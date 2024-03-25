package com.Main.Booking;

import java.util.Scanner;

import com.Modal.Booking;
import com.Service.BookingService;

public class UpdateBooking {
	public static void main(String[] args) {
		System.out.println("Update Booking : ");
		System.out.println("Enter Booking Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter Booking Status : ");
		String status = sc.next();
		BookingService bookingservice = new BookingService();
		bookingservice.update(id, status);
		System.out.println("Booking updated successfully.");

	}
}
