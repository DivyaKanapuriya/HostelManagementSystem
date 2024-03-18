package com.DaoBean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostel_id;
	private String hostel_name;
	private String hostel_location;
	private Integer num_of_rooms;
	private Integer rating;

	@OneToMany(mappedBy = "hostel")
	private List<Room> room;

	@ManyToOne
	@JoinColumn
	private Landlord landlord;

	public int getHostel_id() {
		return hostel_id;
	}

	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}

	public String getHostel_name() {
		return hostel_name;
	}

	public void setHostel_name(String hostel_name) {
		this.hostel_name = hostel_name;
	}

	public String getHostel_location() {
		return hostel_location;
	}

	public void setHostel_location(String hostel_location) {
		this.hostel_location = hostel_location;
	}

	public Integer getNum_of_rooms() {
		return num_of_rooms;
	}

	public void setNum_of_rooms(Integer num_of_rooms) {
		this.num_of_rooms = num_of_rooms;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

}