package com.Service;

import java.util.Date;
import java.util.List;

import com.Dao.BookingDao;
import com.Modal.Booking;
import com.Modal.Customer;
import com.Modal.Hostel;
import com.Modal.Room;

public class BookingService {
	BookingDao bookingDao = new BookingDao();

	// create Booking
	public void create(Customer customer, Hostel hostel, Room room, Date checkInDate, Date checkOutDate,
			String status) {
		bookingDao.createBooking(customer, hostel, room, checkInDate, checkOutDate, status);
	}

	// update Booking
	public void update(int BookingId, String newStatus) {
		bookingDao.updateBooking(BookingId, newStatus);
	}

	// delete Booking
	public void delete(int id) {
		bookingDao.delete(id);
	}

	// read By Id
	public Booking readById(int id) {
		return bookingDao.readBookingById(id);
	}

	// Read Booking by Hostel
	public void readByHostel(Hostel hostel) {
		bookingDao.readByHostel(hostel);
	}

	// Read Booking By Customer
	public void readByCustomer(Customer customer) {
		bookingDao.readByCustomer(customer);

	}

	// Read List of Booking
	public List<Booking> readAll() {
		return bookingDao.readAllBooking();
	}

}
