package com.Main.Booking;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.Modal.Booking;
import com.Service.BookingService;

public class ReadBookingById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Booking Id to get details : ");
		int id = sc.nextInt();
		BookingService bookingservice = new BookingService();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Booking booking = bookingservice.readById(id);
		System.out.println("---------------------------------");
		System.out.println("Booking Details : ");
		System.out.println("Booking Id : " + booking.getBookingID());
		System.out.println("Customer name : " + booking.getCustomer().getCustomer_name());
		System.out.println("Hostel name : " + booking.getHostel().getHostel_name());
		System.out.println("Room Id : " + booking.getRoom().getRoom_id());
		System.out.println("Status : " + booking.getBookingStatus());
		// Format and print the check-in date
		System.out.println("CheckInDate : " + dateFormat.format(booking.getCheckInDate()));
		// Format and print the check-out date
		System.out.println("CheckOutDate : " + dateFormat.format(booking.getCheckOutDate()));
		System.out.println("------------------------------------------");

	}
}
