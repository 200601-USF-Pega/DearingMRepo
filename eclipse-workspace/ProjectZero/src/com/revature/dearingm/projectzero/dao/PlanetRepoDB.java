package com.revature.dearingm.projectzero.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.projectzero.models.Planet;

public class PlanetRepoDB implements IPlanetRepo{

	ConnectionService connectionService;
	
	public PlanetRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	
	
	@Override
	public List<Planet> getAllPlanets() {
		
		List<Planet> result = new ArrayList<Planet>(); 
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM planets;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				
				Planet p = new Planet();
				p.setPlanetID(rs.getInt("id"));
				p.setPlanetName(rs.getString("name"));
				p.setPlanetDesc(rs.getString("desc"));
				if (!result.contains(p)) result.add(p);
			}
			
			return result;
			
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
		
	}

}
