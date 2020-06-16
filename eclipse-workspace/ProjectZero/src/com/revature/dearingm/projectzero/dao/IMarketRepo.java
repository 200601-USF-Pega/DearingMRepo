package com.revature.dearingm.projectzero.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Ship;

public interface IMarketRepo {
	
	// List all
	public ArrayList<Commodity> getPlanetInventory(Ship ship);
	
	// Check for entry
	public boolean checkEntryExists(Ship ship);
	
	// Add to table
	public void addOrRemoveInventory(Commodity com, Ship ship);
	
	// Add to quantity
	public void addToTable(Commodity com, Ship ship);
	
	// Remove from table
	public void deleteFromTable(Commodity com, Ship ship);
}
