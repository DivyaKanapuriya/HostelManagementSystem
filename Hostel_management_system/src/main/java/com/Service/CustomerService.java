package com.Service;

import java.util.List;

import com.DaoBean.Customer;
import com.DaoBean.Room;
import com.dao.CustomerDao;



public class CustomerService{
	CustomerDao customerDao = new CustomerDao();
	RoomService roomService  = new RoomService();
	public void create(Customer customer) {
		customerDao.create(customer);
	}
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	public void delete(int id) {
		customerDao.delete(id);
	}
	public Customer readById(int id) {
		return customerDao.readById(id);
	}
	
	public List<Customer> readAllCustomer(){
		return customerDao.readAllCustomer();
	}
	

		public String checkIn(int customer_id, List<Room> rooms) {
			for (Room room : rooms) {
				Room room2 = roomService.readById(room.getRoom_id());
				if (room2.getRoom_status().equalsIgnoreCase("BOOKED") ){
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

