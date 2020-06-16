package com.revature.dearingm.preojectzero.service;

import com.revature.dearingm.projectzero.dao.IShipRepo;
import com.revature.dearingm.projectzero.models.Ship;

public class ShipService {
	
	IShipRepo repo;
	
	public ShipService(IShipRepo repo) {
		this.repo = repo;
	}
	
	public void newShip() {
		
		Ship playerShip = Ship.getInstance();
		repo.addNewShip(playerShip);
	}
	
	public void getShip(int playerShipID) {
		
		repo.getShip(playerShipID);
	}
	
	
	public void saveShip() {
		
		Ship playerShip = Ship.getInstance();
		repo.saveShip(playerShip);
		
	}
	
	public void showStatus() {
		
		Ship ship = Ship.getInstance();
		String location = repo.getLocation();
		System.out.println("------------------------");
		System.out.println("In orbit above   " + location + ".\n");
		System.out.println("Hull Integrity:  " + ship.getIntegrity() +"%");
		System.out.println("Shield Strength: " + ship.getShields() + "%");
		System.out.println("Fuel Reserves:   " + ship.getFuel() + "%");
		System.out.println("------------------------");
		
		
	}
}
