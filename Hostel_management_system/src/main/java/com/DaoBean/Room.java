package com.DaoBean;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	private Double room_price;
	private String room_status;

	@ManyToOne
	@JoinColumn
	private Hostel hostel;

	@ManyToOne
	@JoinColumn
	private Customer customer;

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(Double room_price) {
		this.room_price = room_price;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}