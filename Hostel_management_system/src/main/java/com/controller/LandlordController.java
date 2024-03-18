package com.controller;

import java.util.ArrayList;

import com.DaoBean.Hostel;
import com.DaoBean.Landlord;
import com.DaoBean.Room;
import com.Service.HostelService;
import com.Service.LandlordService;
import com.Service.RoomService;



public class LandlordController {

	 public static void main(String[] args) {

			Landlord landLord1 = new Landlord();
			Landlord landLord2 = new Landlord();
			Landlord landLord3 = new Landlord();
			landLord1.setId(1);
			landLord2.setId(2);
			landLord3.setId(3);
			
			Hostel Hostel = new Hostel();
			Hostel.setHostel_name("Oberoi GuestHouse");
			Hostel.setHostel_location("Indore");
			Hostel.setNum_of_rooms(3);
			Hostel.setRating(4);
			Hostel.setLandlord(landLord1);

			Hostel Hostel2 = new Hostel();
			Hostel2.setHostel_name("Prestige GuestHouse");
			Hostel2.setHostel_location("Mumbai");
			Hostel2.setNum_of_rooms(2);
			Hostel2.setRating(4);
			Hostel2.setLandlord(landLord2);

			Hostel Hostel3 = new Hostel();
			Hostel3.setHostel_name("Sanskar Palace");
			Hostel3.setHostel_location("Bhopal");
			Hostel3.setNum_of_rooms(4);
			Hostel3.setRating(5);
			Hostel3.setLandlord(landLord3);
           
			Room room1 = new Room();
			room1.setRoom_price(2000.00);
			room1.setRoom_status("AVAILABLE");
			room1.setHostel(Hostel);

			Room room2 = new Room();
			room2.setRoom_price(1000.00);
			room2.setRoom_status("AVAILABLE");
			room2.setHostel(Hostel);

			Room room3 = new Room();
			room3.setRoom_price(3000.00);
			room3.setRoom_status("AVAILABLE");
			room3.setHostel(Hostel);

			Room room4 = new Room();
			room4.setRoom_price(2000.00);
			room4.setRoom_status("AVAILABLE");
			room4.setHostel(Hostel2);

			Room room5 = new Room();
			room5.setRoom_price(1000.00);
			room5.setRoom_status("AVAILABLE");
			room5.setHostel(Hostel2);

			Room room6 = new Room();
			room6.setRoom_price(3000.00);
			room6.setRoom_status("AVAILABLE");
			room6.setHostel(Hostel2);

			Room room7 = new Room();
			room7.setRoom_price(2000.00);
			room7.setRoom_status("AVAILABLE");
			room7.setHostel(Hostel3);

			Room room8 = new Room();
			room8.setRoom_price(1000.00);
			room8.setRoom_status("AVAILABLE");
			room8.setHostel(Hostel3);

			Room room9 = new Room();
			room9.setRoom_price(3000.00);
			room9.setRoom_status("AVAILABLE");
			room9.setHostel(Hostel3);

			ArrayList<Room> roomAl = new ArrayList<Room>();
			roomAl.add(room1);
			roomAl.add(room2);
			roomAl.add(room3);

			ArrayList<Room> roomAl2 = new ArrayList<Room>();
			roomAl2.add(room4);
			roomAl2.add(room5);
			roomAl2.add(room6);

			ArrayList<Room> roomAl3 = new ArrayList<Room>();
			roomAl3.add(room7);
			roomAl3.add(room8);
			roomAl3.add(room9);

//			setting rooms for Hostels
			Hostel.setRoom(roomAl);
			Hostel2.setRoom(roomAl2);
			Hostel3.setRoom(roomAl3);

			ArrayList<Hostel> HostelAl = new ArrayList<Hostel>();
			HostelAl.add(Hostel);
			ArrayList<Hostel> HostelAl1 = new ArrayList<Hostel>();
			HostelAl1.add(Hostel2);
			ArrayList<Hostel> HostelAl2 = new ArrayList<Hostel>();
			HostelAl2.add(Hostel3);

//			 setting Hostel ArrayList to landlords

			landLord1.setHostels(HostelAl);
			landLord2.setHostels(HostelAl1);
			landLord3.setHostels(HostelAl2);

			LandlordService landlordService = new LandlordService();
			landlordService.update(landLord1);
			landlordService.update(landLord2);
			landlordService.update(landLord3);

			HostelService HostelService = new HostelService();
			HostelService.create(Hostel);
			HostelService.create(Hostel2);
			HostelService.create(Hostel3);

			RoomService roomService = new RoomService();
			roomService.create(room1);
			roomService.create(room2);
			roomService.create(room3);
			roomService.create(room4);
			roomService.create(room5);
			roomService.create(room6);
			roomService.create(room7);
			roomService.create(room8);
			roomService.create(room9);

 }
}
