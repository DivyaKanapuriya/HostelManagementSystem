package com.Modal;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookingID")
	private int bookingID;

	// Entity Mapping
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "HostelID")
	private Hostel hostel;

	@ManyToOne
	@JoinColumn(name = "RoomID")
	private Room room;

	@Column(name = "CheckInDate")
	private Date checkInDate;

	@Column(name = "CheckOutDate")
	private Date checkOutDate;

	@Column(name = "BookingStatus")
	private String bookingStatus;

	// Constructors, Getters, and Setters

	public Booking() {
	}

	// Constructor with all fields
	public Booking(Customer customer, Hostel hostel, Room room, Date checkInDate, Date checkOutDate,
			String bookingStatus) {
		this.customer = customer;
		this.hostel = hostel;
		this.room = room;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingStatus = bookingStatus;
	}

	// Getters and Setters for all fields
	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
