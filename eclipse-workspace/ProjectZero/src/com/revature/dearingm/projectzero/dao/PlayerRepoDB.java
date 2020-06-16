package com.revature.dearingm.projectzero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.projectzero.models.Player;

public class PlayerRepoDB implements IPlayerRepo{
	
	ConnectionService connectionService;
	
	public PlayerRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public void addNewPlayer(Player player) {
		
		try {
			PreparedStatement newPlayer = connectionService.getConnection().prepareStatement("INSERT INTO players VALUES (?, ?, ?)");
			
			newPlayer.setString(1, player.getPlayerName());
			newPlayer.setString(2, player.getPlayerPassword());
			newPlayer.setInt(3, player.getPlayerCredits());
			
			newPlayer.executeUpdate();
			
			System.out.println("Player data confirmed");
		
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
				
	}
	
	
	// Make sure User names are unique
	@Override
	public boolean checkUsername(String userName) {
		
		try {
			
			Statement userCheck = connectionService.getConnection().createStatement();
			//userCheck.executeQuery("SELECT name FROM players WHERE name='" + userName + "';");
			
			ResultSet rs = userCheck.executeQuery("SELECT username FROM players WHERE username='" + userName + "';");
			
			if (rs.next()) {
				
				//if (!rs.getString("")
					
					//connectionService.finalize();
					return true;
				
			} else {
				
				//connectionService.finalize();
				return false;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean getPlayer(String username, String password) {
		
		try {
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM players WHERE username='" + username + "';");
						  
			ResultSet rs = s.getResultSet();
			
			if (rs.next()) {
			
				String tempName = rs.getString("username");
				String tempPass = rs.getString("password");
			
			
				if (tempName.contentEquals(username)) {
					
					
					if (tempPass.contentEquals(password)) {
												
						Player playerData = Player.getInstance();
						 
						playerData.setPlayerName(tempName);
						playerData.setPlayerPassword(tempPass);
						playerData.setPlayerCredits(rs.getInt("credits"));
						playerData.setPlayerShipID(rs.getInt("ship_id"));
						
						return true;
					}
					
					else System.out.println("Password is incorrect");
					return false;
					
				}
				
				else System.out.println("No match");
				return false;
			
				
			}
			
			else System.out.println("User Not Found");
			return false;
			
			//Player.getInstance()
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@Override
	public boolean savePlayer(Player player) {
		
		try {
			
			Statement save = connectionService.getConnection().createStatement();
			save.executeUpdate(
					"UPDATE players " +
					"SET credits = '" + player.getPlayerCredits() + "'," +
						"ship_id = '" + player.getPlayerShipID() + "' "  +
					"WHERE username = '" + player.getPlayerName() + "';");
			System.out.println("Player data saved!");
			return true;
											  
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
}
