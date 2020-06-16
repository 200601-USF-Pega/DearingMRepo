package com.revature.dearingm.projectzero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.projectzero.models.Player;
import com.revature.dearingm.projectzero.models.Ship;

public class ShipRepoDB implements IShipRepo{
	
	ConnectionService connectionService;
	
	public ShipRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	@Override
	public void addNewShip(Ship ship) {
		
		try {
			
			Statement newShip = connectionService.getConnection().createStatement();
				newShip.executeUpdate("INSERT INTO ships "
								+ "(integrity, shields, fuel, capacity, ship_location) "
								+ "VALUES ('" + ship.getIntegrity() + "',"
								+ "'" + ship.getShields() + "',"
								+ "'" + ship.getFuel() + "',"
								+ "'" + ship.getCargoCapacity() + "',"
								+ "'" + ship.getLocation() + "');");
								
			
	
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public boolean getShip(int playerShipID) {
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM ships WHERE id = '" + playerShipID + "';");
			
			ResultSet rs = s.getResultSet();
			
			if (rs.next()) {
				
				Ship shipData = Ship.getInstance();
				
				shipData.setID(rs.getInt("id"));
				shipData.setIntegrity(rs.getInt("integrity"));
				shipData.setShields(rs.getInt("shields"));
				shipData.setFuel(rs.getInt("fuel"));
				shipData.setCargoSpace(rs.getInt("capacity"));
				shipData.setLocation(rs.getInt("ship_location"));
				
				return true;
			}
			
			return false;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean saveShip(Ship ship) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"UPDATE ships " +
					"SET integrity = '" + ship.getIntegrity() + "'," +
						"shields   = '" + ship.getShields() + "'," +
						"fuel      = '" + ship.getFuel() + "'," +
						"capacity  = '" + ship.getCargoCapacity() + "'," +
					"ship_location = '" + ship.getLocation() + "' " +
					"WHERE id IN (SELECT ship_id FROM players WHERE ship_id = '" + Player.getInstance().getPlayerShipID()  + "');" );
			return true;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String getLocation() {
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM planets WHERE id = '" + Ship.getInstance().getLocation() + "';");
			
			ResultSet rs = s.getResultSet();
			
			if (rs.next()) {
				return rs.getString("name");
			}
			return "Error";
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return "Error";
		}
	}

}













