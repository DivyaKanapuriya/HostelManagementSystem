package com.Main.Booking;

import java.text.SimpleDateFormat;
import java.util.List;

import com.Modal.Admin;
import com.Modal.Booking;
import com.Service.AdminService;
import com.Service.BookingService;

public class ReadAllBooking {
	public static void main(String[] args) {
		BookingService bookingService = new BookingService();
		System.out.println("Read Booking Details : ");
		List<Booking> bookings = bookingService.readAll();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		for (Booking booking : bookings) {
			System.out.println("----------------------------------------");
			System.out.println("Booking Id : " + booking.getBookingID());
			System.out.println("Customer name : " + booking.getCustomer().getCustomer_name());
			System.out.println("Hostel name  : " + booking.getHostel().getHostel_name());
			System.out.println("Room Id : " + booking.getRoom().getRoom_id());
			System.out.println("Status : " + booking.getBookingStatus());
			// Format and print the check-in date
			System.out.println("CheckInDate : " + dateFormat.format(booking.getCheckInDate()));
			// Format and print the check-out date
			System.out.println("CheckOutDate : " + dateFormat.format(booking.getCheckOutDate()));
			System.out.println("------------------------------------------");
		}
	}
}