package com.Main.Booking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.Modal.Booking;
import com.Modal.Customer;
import com.Modal.Hostel;
import com.Modal.Room;
import com.Service.BookingService;

public class CreateBooking {
	public static void main(String[] args) {
		Booking booking = new Booking();
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Save Booking  ---");
		Customer customer = new Customer();
		System.out.println("Enter customer Id : ");
		int id1 = sc.nextInt();
		customer.setCustomer_id(id1);
		System.out.println("Enter Hostel Id : ");
		Hostel hostel = new Hostel();
		int id2 = sc.nextInt();
		hostel.setHostel_id(id2);
		System.out.println("Enter room Id : ");
		Room room = new Room();
		int id3 = sc.nextInt();
		room.setRoom_id(id3);
		System.out.println("Enter Check In Date (dd-MM-yyyy) : ");
		String checkInDateString = sc.next();
		Date checkInDate = null;
		try {
			checkInDate = new SimpleDateFormat("dd-MM-yyyy").parse(checkInDateString);
		} catch (Exception e) {
			System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
			return;
		}
		booking.setCheckInDate(checkInDate);
		System.out.println("Enter Check Out Date (dd-mm-yyyy) : ");
		String checkOutDateString = sc.next();
		Date checkOutDate = null;
		try {
			checkOutDate = new SimpleDateFormat("dd-mm-yyyy").parse(checkOutDateString);
		} catch (Exception e) {
			System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
			return;
		}

		booking.setCheckOutDate(checkOutDate);
		String status = "Booked";
		BookingService bookingservice = new BookingService();
		bookingservice.create(customer, hostel, room, checkInDate, checkOutDate, status);

		System.out.println("Booking saved Successfully");
	}
}
