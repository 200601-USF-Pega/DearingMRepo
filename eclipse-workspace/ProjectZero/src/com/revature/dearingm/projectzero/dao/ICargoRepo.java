package com.revature.dearingm.projectzero.dao;

import java.util.ArrayList;

import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Ship;

public interface ICargoRepo {
	
	// List all
	public ArrayList<Commodity> getCargoInventory(Ship ship);
	
	// Check for entries
	public boolean checkCargo(Ship ship);
	
	// Add to quantity
	public void addOrRemoveCargo(Ship ship, Commodity com);
	
	public void addCargoToTable(Ship ship, Commodity com);
	
	// remove from table
	public void removeCargoFromTable(Ship ship, Commodity com);
}
