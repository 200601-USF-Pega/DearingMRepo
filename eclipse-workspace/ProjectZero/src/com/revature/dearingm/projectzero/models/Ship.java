package com.revature.dearingm.projectzero.models;

import java.util.ArrayList;

public class Ship {
	
	private static Ship shipInstance = null;
	
	private int shipID;
	private int integrity;
	private int shields;
	private int fuel;
	private int cargoCapacity;
	private int shipLocation;
	
	private ArrayList<Commodity> cargoLoad; 
	
	
	public static Ship getInstance() {
		
		if(shipInstance == null) {
						
			// Logic for loading player info from DB?
			// or logic for creating a new player...
			shipInstance = new Ship();
			
		}
		
		return shipInstance;
	}
	
	// Default settings for new ship
	private Ship() {
		this.integrity = 100;
		this.shields = 100;
		this.fuel = 100;
		this.cargoCapacity = 25;
		this.shipLocation = 1;
	}
	
	public void setID(int shipID) {
		this.shipID = shipID;
	}
	
	public void setIntegrity(int shipIntegrity) {
		this.integrity = shipIntegrity;
	}
	
	public void setShields(int shipShields) {
		this.shields = shipShields;
	}
	
	public void setFuel(int shipFuel) {
		this.fuel = shipFuel;
	}
	
	public void setCargoSpace(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	
	public void setLocation(int location) {
		this.shipLocation = location;
	}
	
	public int getShipID() {
		return this.shipID;
	}
	
	public int getIntegrity() {
		return this.integrity;
	}
	
	public int getShields() {
		return this.shields;
	}
	
	public int getFuel() {
		return this.fuel;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getLocation() {
		return this.shipLocation;
	}
	
	public void viewCargo() {
		
				
		for (Commodity item: cargoLoad) {
			
			
			System.out.println(
				"[" + item.getComQuantity() + "] " + item.getComName() + " - Bought at " + item.getComBuyPrice() + "cr each"); 
				
		}
		
	}
	
	public void setCargoLoad (ArrayList<Commodity> cargoLoad) {
		this.cargoLoad = cargoLoad;
	}
	
	public void addCargo(Commodity newItem) {
		this.cargoLoad.add(newItem);
	}
	
	public void removeItem(Commodity remove) {
		this.cargoLoad.remove(remove);
	}
	
	
}
