package com.Service;

import java.util.ArrayList;
import java.util.List;
import com.Dao.LandlordDao;
import com.Modal.Hostel;
import com.Modal.Landlord;

public class LandlordService {
	LandlordDao landlordDao = new LandlordDao();
	HostelService hostelService = new HostelService();

	// create landlord
	public void create(Landlord landlord) {
		landlord.setStatus("Not Approved");
		landlordDao.create(landlord);
	}

	// delete landlord
	public void delete(int id) {
		Landlord landlord = landlordDao.readById(id);
		for (Hostel hotel : landlord.getHostels()) {
			hostelService.delete(hotel.getHostel_id());
		}
		landlordDao.delete(id);
	}

	// update landlord
	public void update(Landlord landlord) {
		landlordDao.update(landlord);
	}

	// read landlord by Id
	public Landlord readById(int id) {
		return landlordDao.readById(id);
	}

	// read landlord list
	public List<Landlord> readAllLandlord() {
		return landlordDao.readAllLandlord();
	}

	// add hostel by landlord Id
	public void addHostelById(int id, Landlord landLord) {
		Landlord landLord1 = landlordDao.readById(landLord.getId());
		if (landLord1.getStatus().equalsIgnoreCase("APPROVED")) {
			Hostel hostel = hostelService.readById(id);
			hostel.setLandlord(landLord1);

			ArrayList<Hostel> hostels = new ArrayList<Hostel>();
			hostels.add(hostel);

			landLord1.setHostels(hostels);

			landlordDao.update(landLord1);
			hostelService.update(hostel);
			System.out.println("Hostel added successfully..");
		} else {
			System.out.println("LandLord is not approved");
		}
	}
}
