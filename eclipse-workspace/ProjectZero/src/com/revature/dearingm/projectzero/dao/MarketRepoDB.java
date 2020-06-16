package com.revature.dearingm.projectzero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Planet;
import com.revature.dearingm.projectzero.models.Ship;

public class MarketRepoDB implements IMarketRepo{
	
	ConnectionService connectionService;
	
	public MarketRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public ArrayList<Commodity> getPlanetInventory(Ship ship) {
		
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery(
					
				    "SELECT i.*, pi.quantity " +
					"FROM items AS i " +
					"LEFT JOIN planet_inventory AS pi " +
					"ON i.id = pi.item_id " +
					"WHERE pi.planet_id = '" + ship.getLocation() + "';");
			
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				Commodity c = new Commodity();
				c.setComID(rs.getInt("id"));
				c.setComName(rs.getString("name"));
				c.setComDesc(rs.getString("economy"));
				c.setComBasePrice(rs.getInt("base_value"));
				c.setComQuantity(rs.getInt("quantity"));
				if (!result.contains(c)) result.add(c);
			}
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	@Override
	public boolean checkEntryExists(Ship ship) {
		
		try {
			
			Statement userCheck = connectionService.getConnection().createStatement();
			//userCheck.executeQuery("SELECT name FROM players WHERE name='" + userName + "';");
			
			ResultSet rs = userCheck.executeQuery("select item_id, planet_id FROM planet_inventory WHERE planet_id='" + ship.getLocation() + "';)");
			
			if (rs.next()) {
				
				return true;
				
			} else {
				
				return false;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
			
		}
	}
	
	@Override
	public void addOrRemoveInventory(Commodity com, Ship ship) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"UPDATE planet_inventory " +
					"SET quantity = '" + com.getComQuantity() + "' " +
					"WHERE item_id = '" + com.getComID() + "' AND planet_id = '" + ship.getLocation() + "';");
			
											  
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void addToTable(Commodity com, Ship ship) {
		
		try {
			PreparedStatement addEntry = connectionService.getConnection().prepareStatement("INSERT INTO planet_inventory VALUES (?, ?, ?)");
			
			addEntry.setInt(1, ship.getLocation());
			addEntry.setInt(2, com.getComID());
			addEntry.setInt(3, com.getComQuantity());
			
			addEntry.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteFromTable(Commodity com, Ship ship) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"DELETE FROM planet_inventory WHERE" + " item_id = '" + com.getComID() + "' AND planet_id = '" + ship.getLocation() + "';");
			
											  
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
