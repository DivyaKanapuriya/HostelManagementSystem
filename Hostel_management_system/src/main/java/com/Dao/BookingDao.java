package com.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Modal.Booking;
import com.Modal.Customer;
import com.Modal.Hostel;
import com.Modal.Room;

public class BookingDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOSTEL_Book");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// create booking
	public Booking createBooking(Customer customer, Hostel hostel, Room room, Date checkInDate, Date checkOutDate, String status) {
		Booking booking = new Booking();
		booking.setCustomer(customer);
		booking.setHostel(hostel);
		booking.setRoom(room);
		booking.setCheckInDate(checkInDate);
		booking.setCheckOutDate(checkOutDate);
		booking.setBookingStatus(status);
        // Save the booking to the database
		entityTransaction.begin();
		entityManager.persist(booking);
		entityTransaction.commit();

		return booking;
	}

	// update Booking
	public Booking updateBooking(int bookingId, String newStatus) {
		Booking booking = entityManager.find(Booking.class, bookingId);
		if (booking != null) {
			entityTransaction.begin();
			if (booking.getBookingStatus() != null) {
				booking.setBookingStatus(newStatus);
			}
			// Save the updated booking to the database
			entityManager.merge(booking);
			entityTransaction.commit();

			return booking;
		} else {
			throw new RuntimeException("Booking not found with ID: " + bookingId);
		}
	}

	// Read Booking By Id
	public Booking readBookingById(int id) {
		return entityManager.find(Booking.class, id);
	}

	// Read Booking By Hostel
	public Booking readByHostel(Hostel hostel) {
		return entityManager.find(Booking.class, hostel);
	}

	// Read Booking By Customer
	public Booking readByCustomer(Customer customer) {
		return entityManager.find(Booking.class, customer);
	}

	// Read All Booking
	public List<Booking> readAllBooking() {
		String sql = "Select s From Booking s";
		Query query = entityManager.createQuery(sql);
		List<Booking> bookings = query.getResultList();
		return bookings;
	}

	// Delete Booking
	public void delete(int id) {
		Booking booking = entityManager.find(Booking.class, id);
		if (booking != null) {
			entityTransaction.begin();
			entityManager.remove(booking);
			entityTransaction.commit();
		}

	}
}
