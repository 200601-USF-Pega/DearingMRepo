package com.revature.dearingm.projectzero.dao;


import com.revature.dearingm.projectzero.models.Ship;

public interface IShipRepo {
	
	public void addNewShip(Ship ship);
	public boolean getShip(int playerShipID);
	public boolean saveShip(Ship ship);
	public String getLocation();
	
	
	
}
