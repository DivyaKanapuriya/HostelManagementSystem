package com.Modal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String customer_phone_num;
	private String customer_aadhar_num;
	private String customer_login_id;
	private String customer_login_pass;

	// Entity Mapping
	@OneToMany(mappedBy = "customer")
	private List<Booking> booking;

	@OneToMany(mappedBy = "customer")
	private List<Room> rooms;

	// Getters and Setters
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone_num() {
		return customer_phone_num;
	}

	public void setCustomer_phone_num(String customer_phone_num) {
		this.customer_phone_num = customer_phone_num;
	}

	public String getCustomer_aadhar_num() {
		return customer_aadhar_num;
	}

	public void setCustomer_aadhar_num(String customer_aadhar_num) {
		this.customer_aadhar_num = customer_aadhar_num;
	}

	public String getCustomer_login_id() {
		return customer_login_id;
	}

	public void setCustomer_login_id(String customer_login_id) {
		this.customer_login_id = customer_login_id;
	}

	public String getCustomer_login_pass() {
		return customer_login_pass;
	}

	public void setCustomer_login_pass(String customer_login_pass) {
		this.customer_login_pass = customer_login_pass;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}