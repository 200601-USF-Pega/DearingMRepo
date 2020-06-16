package com.revature.dearingm.projectzero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Ship;

public class CargoRepoDB implements ICargoRepo{
	
	ConnectionService connectionService;
	
	public CargoRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public ArrayList<Commodity> getCargoInventory(Ship ship) {


		ArrayList<Commodity> result = new ArrayList<Commodity>();
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery(
					
				    "SELECT i.*, ci.quantity, ci.buy_price " +
					"FROM items AS i " +
					"LEFT JOIN cargo AS ci " +
					"ON i.id = ci.item_id " +
					"WHERE ci.ship_id = '" + ship.getShipID() + "';");
			
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				Commodity c = new Commodity();
				c.setComID(rs.getInt("id"));
				c.setComName(rs.getString("name"));
				c.setComDesc(rs.getString("economy"));
				c.setComBasePrice(rs.getInt("base_value"));
				c.setComQuantity(rs.getInt("quantity"));
				c.setComBuyPrice(rs.getInt("buy_price"));
				if (!result.contains(c)) result.add(c);
			}
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			return null;
			
		}
		
	}

	@Override
	public boolean checkCargo(Ship ship) {

		try {
			
			Statement userCheck = connectionService.getConnection().createStatement();
			
			ResultSet rs = userCheck.executeQuery("select item_id, ship_id FROM cargo WHERE ship_id='" + ship.getShipID() + "';)");
			
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
	public void addOrRemoveCargo(Ship ship, Commodity com) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"UPDATE cargo " +
					"SET quantity = '" + com.getComQuantity() + "' " +
					"WHERE item_id = '" + com.getComID() + "' AND ship_id = '" + ship.getShipID() + "';");
			
											  
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCargoToTable(Ship ship, Commodity com) {
		
		try {
			PreparedStatement addEntry = connectionService.getConnection().prepareStatement("INSERT INTO cargo VALUES (?, ?, ?, ?)");
			
			addEntry.setInt(1, ship.getShipID());
			addEntry.setInt(2, com.getComID());
			addEntry.setInt(3, com.getComQuantity());
			addEntry.setInt(4, com.getComBuyPrice());
			
			addEntry.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeCargoFromTable(Ship ship, Commodity com) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"DELETE FROM cargo WHERE" + " item_id = '" + com.getComID() + "' AND ship_id = '" + ship.getShipID() + "';");
			
											  
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	

}
