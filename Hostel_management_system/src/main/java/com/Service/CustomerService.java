package com.Service;

import java.util.List;

import com.Dao.CustomerDao;
import com.Modal.Customer;
import com.Modal.Room;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	RoomService roomService = new RoomService();

	// create customer
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	// login customer
	public Customer loginCustomer(String username, String password) {
		return customerDao.loginCustomer(username, password);
	}

	// update customer
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	// delete customer
	public void delete(int id) {
		customerDao.delete(id);
	}

	// read customer by Id
	public Customer readById(int id) {
		return customerDao.readById(id);
	}

	// Read all customer list
	public List<Customer> readAllCustomer() {
		return customerDao.readAllCustomer();
	}

	// customer checkIn by id and list of room
	public String checkIn(int customer_id, List<Room> rooms) {
		for (Room room : rooms) {
			Room room2 = roomService.readById(room.getRoom_id());
			if (room2.getRoom_status().equalsIgnoreCase("BOOKED")) {
				return "Selected Room Is Already Booked......Please Select Another Room";
			}
		}
		Customer customer = customerDao.readById(customer_id);
		customer.setRooms(rooms);
		customerDao.update(customer);

		for (Room room : rooms) {
			room.setCustomer(customer);
			room.setRoom_status("BOOKED");
			roomService.update(room);
		}
		return "CheckIn Done";
	}

	// customer checkout by id and list of room
	public void checkOut(int customer_id, List<Room> rooms) {
		Customer customer = customerDao.readById(customer_id);
		customer.setRooms(null);
		customerDao.update(customer);

		for (Room room : rooms) {
			room.setCustomer(null);
			room.setRoom_status("AVAILABLE");
			roomService.update(room);
		}

	}

}
