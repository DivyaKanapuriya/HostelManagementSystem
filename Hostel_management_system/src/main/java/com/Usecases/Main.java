package com.Usecases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Main.Admin.AdminLogin;
import com.Main.Customer.LoginCustomer;
import com.Main.Customer.CreateCustomer;
import com.Modal.Admin;
import com.Modal.Booking;
import com.Modal.Customer;
import com.Modal.Hostel;
import com.Modal.Landlord;
import com.Modal.Room;
import com.Service.AdminService;
import com.Service.BookingService;
import com.Service.CustomerService;
import com.Service.HostelService;
import com.Service.LandlordService;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Boolean y = true;
		while (y) {
			System.out.println("=======================================================");
			System.out.println("  Welcome To Hostel Management System  ");
			System.out.println("=======================================================");
			System.out.println("Select Any option:  ");
			System.out.println("1. Admin Login   ");
			System.out.println("2. Customer Registration   ");
			System.out.println("3. Customer Login ");
			System.out.println("4. Exit     ");
			System.out.println("=======================================================");
			System.out.println("Enter your choice :");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Boolean status = AdminLogin.login();
				if (status) {
					Boolean x = true;
					while (x) {
						System.out.println("===============================================");
						System.out.println("Select Any option : ");
						System.out.println("1. Read All Landlords");
						System.out.println("2. Read All Hostels ");
						System.out.println("3. Approve landlords");
						System.out.println("4. Read Booking Details");
						System.out.println("5. Read Customer Details");
						System.out.println("6. Back to previous options");
						System.out.println("7. Exit ");
						System.out.println("==================================================");
						System.out.println("Enter your choice : ");
						int ach = sc.nextInt();
						switch (ach) {
						case 1:
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
							break;
						case 2:
							System.out.println("All Hostel List : ");
							HostelService hostelService = new HostelService();
							List<Hostel> hostels = hostelService.readAllhostel();
							System.out.println("All Hostel List is here : ");
							for (Hostel hostel : hostels) {
								System.out.println("------------------------------------------");
								System.out.println("Hostel Id = " + hostel.getHostel_id());
								System.out.println("Hostel name = " + hostel.getHostel_name());
								System.out.println("Location = " + hostel.getHostel_location());
								System.out.println("Number of Room = " + hostel.getNum_of_rooms());
								System.out.println("Hostel rating = " + hostel.getRating());
								System.out.println("--------------------------------------------");
							}
							break;
						case 3:
							Scanner scanner = new Scanner(System.in);
							System.out.println("Enter Landlord Id : ");
							int landlord_id = scanner.nextInt();
							System.out.println("Enter admin Id : ");
							int admin_id = scanner.nextInt();
							Admin admin = new Admin();
							admin.setAdmin_id(admin_id);
							AdminService adminService = new AdminService();
							adminService.approveLandlordById(landlord_id, admin);
							System.out.println("Landlord approved successfully..");

							break;
						case 4:
							BookingService bookingService = new BookingService();
							System.out.println("Read Booking Details : ");
							List<Booking> bookings = bookingService.readAll();
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							for (Booking bking : bookings) {
								System.out.println("----------------------------------------");
								System.out.println("Booking Id : " + bking.getBookingID());
								System.out.println("Customer name : " + bking.getCustomer().getCustomer_name());
								System.out.println("Hostel name  : " + bking.getHostel().getHostel_name());
								System.out.println("Room Id : " + bking.getRoom().getRoom_id());
								System.out.println("Status : " + bking.getBookingStatus());
								// Format and print the check-in date
								System.out.println("CheckInDate : " + dateFormat.format(bking.getCheckInDate()));
								// Format and print the check-out date
								System.out.println("CheckOutDate : " + dateFormat.format(bking.getCheckOutDate()));
								System.out.println("------------------------------------------");
							}
							break;
						case 5:
							System.out.println(" All Customers List :");
							CustomerService customerService = new CustomerService();
							List<Customer> customers = customerService.readAllCustomer();
							for (Customer customer : customers) {
								System.out.println("-----------------------------------------------");
								System.out.println("Customer Id : " + customer.getCustomer_id());
								System.out.println("Customer Name : " + customer.getCustomer_name());
								System.out.println("Customer aadhar : " + customer.getCustomer_aadhar_num());
								System.out.println("Customer phone no : " + customer.getCustomer_phone_num());
								System.out.println("-----------------------------------------------");
							}
							break;
						case 6:
							x = false;
							break;
						case 7:
							System.out.println("Thank you for visit");
							x = false;
							y = false;
							break;
						default:
							System.out.println("Enter a valid option. ");
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("Enter Name : ");
				Scanner scner = new Scanner(System.in);
				String name = scner.next();
				System.out.println("Enter Phone no. : ");
				String phone = scner.next();
				System.out.println("Enter Aadhar no. : ");
				String aadhar = scner.next();
				Customer customer = new Customer();

				customer.setCustomer_name(name);
				customer.setCustomer_phone_num(phone);
				customer.setCustomer_aadhar_num(aadhar);
				customer.setCustomer_login_pass(name + 123);
				customer.setCustomer_login_id(name);
				CustomerService customerService = new CustomerService();
				customerService.create(customer);
				System.out.println("Customer registered successfully..");
				break;
			case 3:
				Boolean status1 = LoginCustomer.login();
				if (status1) {
					Boolean z = true;
					while (z) {
						System.out.println("===============================================");
						System.out.println("Select any option.");
						System.out.println("1. Get Landlords");
						System.out.println("2. Get Hostels");
						System.out.println("3. Get All Rooms details by Hostel Id");
						System.out.println("4. Book Room and save details");
						System.out.println("5. Cancel Booking");
						System.out.println("6. Check In");
						System.out.println("7. Check Out ");
						System.out.println("8. Back to previous options ");
						System.out.println("9. Exit  ");
						System.out.println("================================================");
						System.out.println("Enter your choice:");
						int cch = sc.nextInt();
						switch (cch) {
						case 1:
							AdminService adminService = new AdminService();
							System.out.println("All ApprovedLandlords are : ");
							List<Landlord> landlord2 = adminService.readAllApprovedLandlords(); {
							for (Landlord landlord : landlord2) {
								System.out.println("------------------------------------------------");
								System.out.println("Landlord Id : " + landlord.getId());
								System.out.println("Landlord Name : " + landlord.getName());
								System.out.println("Landlord Address : " + landlord.getAddress());
								System.out.println("Landlord Status : " + landlord.getStatus());
								System.out.println("-------------------------------------------------");
							}
						}
							break;
						case 2:
							Scanner scnr = new Scanner(System.in);
							System.out.println("Read All hostels by Landlord Id : ");
							System.out.println("Enter Landlord Id :");
							int hostel_id = scnr.nextInt();
							HostelService hostelservice = new HostelService();
							List<Hostel> hostels = hostelservice.readAllhostelbyLandlordId(hostel_id);
							for (Hostel Hostel : hostels) {
								System.out.println("------------------------------------------");
								System.out.println("Hostel Id = " + Hostel.getHostel_id());
								System.out.println("Hostel name = " + Hostel.getHostel_name());
								System.out.println("Location = " + Hostel.getHostel_location());
								System.out.println("Number of Room = " + Hostel.getNum_of_rooms());
								System.out.println("Hostel rating = " + Hostel.getRating());
								System.out.println("--------------------------------------------");
							}
							break;
						case 3:
							System.out.println("Read All Rooms By hostel Id : ");
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter hostel id :");
							int hostelid = sc1.nextInt();

							HostelService hostelService = new HostelService();
							List<Room> rooms = hostelService.readAllRoomsByhostelId(hostelid);

							for (Room room : rooms) {
								System.out.println("----------------------------------------------");
								System.out.println("Id : " + room.getRoom_id());
								System.out.println("Price : " + room.getRoom_price());
								System.out.println("Status : " + room.getRoom_status());
								System.out.println("hostel id is " + room.getHostel().getHostel_id());
								System.out.println("-----------------------------------------------");
							}
							break;
						case 4:
							Booking booking = new Booking();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("--- Save Booking  ---");
							Customer custmer = new Customer();
							System.out.println("Enter customer Id : ");
							int id1 = sc4.nextInt();
							custmer.setCustomer_id(id1);
							System.out.println("Enter Hostel Id : ");
							Hostel hostel = new Hostel();
							int id2 = sc4.nextInt();
							hostel.setHostel_id(id2);
							System.out.println("Enter room Id : ");
							Room room = new Room();
							int id3 = sc4.nextInt();
							room.setRoom_id(id3);
							System.out.println("Enter Check In Date (dd-MM-yyyy) : ");
							String checkInDateString = sc4.next();
							Date checkInDate = null;
							try {
								checkInDate = new SimpleDateFormat("dd-MM-yyyy").parse(checkInDateString);
							} catch (Exception e) {
								System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
								return;
							}
							booking.setCheckInDate(checkInDate);
							System.out.println("Enter Check Out Date (dd-mm-yyyy) : ");
							String checkOutDateString = sc4.next();
							Date checkOutDate = null;
							try {
								checkOutDate = new SimpleDateFormat("dd-mm-yyyy").parse(checkOutDateString);
							} catch (Exception e) {
								System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
								return;
							}

							booking.setCheckOutDate(checkOutDate);
							String stus = "Booked";
							BookingService bookingservice = new BookingService();
							bookingservice.create(custmer, hostel, room, checkInDate, checkOutDate, stus);

							System.out.println("Booking saved Successfully");

							break;
						case 5:
							Booking bookg = new Booking();
							System.out.println("Cancel Booking : ");
							System.out.println("Enter Booking Id : ");
							Scanner scn = new Scanner(System.in);
							int id = scn.nextInt();
							System.out.println("Enter Booking Status : ");
							String sttus = scn.next();
							BookingService bookigservice = new BookingService();
							bookigservice.update(id, sttus);
							System.out.println("Booking updated successfully.");

							break;
						case 6:
							System.out.println("Enter Customer Id : ");
							Scanner sc2 = new Scanner(System.in);
							int customer_id = sc2.nextInt();
							System.out.println("Enter room1 id : ");

							int rm = sc2.nextInt();
							Room room1 = new Room();
							room1.setRoom_id(rm);
							System.out.println("Enter room2 id : ");
							Room room2 = new Room();
							int rmm = sc2.nextInt();
							room2.setRoom_id(rmm);
							System.out.println("Enter room3 id : ");
							Room room3 = new Room();
							int rm3 = sc2.nextInt();
							room3.setRoom_id(rm3);
							ArrayList<Room> rooms1 = new ArrayList<Room>();
							rooms1.add(room1);
							rooms1.add(room2);
							rooms1.add(room3);

							CustomerService customersvce = new CustomerService();

							System.out.println(customersvce.checkIn(customer_id, rooms1));

							break;
						case 7:
							System.out.println("Enter Customer Id : ");
							Scanner sn = new Scanner(System.in);
							int custid = sn.nextInt();
							System.out.println("Enter room1 id : ");
							Room rm1 = new Room();
							int chkoutroom1 = sn.nextInt();
							rm1.setRoom_id(chkoutroom1);
							System.out.println("Enter room2 id : ");
							Room rm2 = new Room();
							int chkoutroom2 = sn.nextInt();
							rm2.setRoom_id(chkoutroom2);
							System.out.println("Enter room3 id : ");
							Room rom3 = new Room();
							int chkoutroom3 = sn.nextInt();
							rom3.setRoom_id(chkoutroom3);
							ArrayList<Room> rooms2 = new ArrayList<Room>();
							rooms2.add(rm1);
							rooms2.add(rm2);
							rooms2.add(rom3);

							CustomerService customerservice = new CustomerService();
							customerservice.checkOut(custid, rooms2);
							System.out.println("Checkout done ");

							break;
						case 8:
							z = false;
							break;
						case 9:
							System.out.println("Thank you for visit");
							z = false;
							y = false;
							break;
						default:
							System.out.println("Enter a valid choice.");
							break;
						}
					}
				}
				break;
			case 4:
				System.out.println("Thank you for visit.");
				y = false;
				break;
			default:
				System.out.println("Enter a valid option.");
				break;
			}
		}
	}

}
