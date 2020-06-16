package com.revature.dearingm.projectzero.models;


public class Player {
	
	// Singleton Design Pattern
	private static Player playerInstance = null;
	
	private String playerName;
	private String playerPassword;
	private int playerCredits;
	private int playerShipID;
	private Ship playerShip;
	
	
	
	public static Player getInstance() {
		
		if(playerInstance == null) {
						
			// Logic for loading player info from DB?
			// or logic for creating a new player...
			playerInstance = new Player();
			
		}
		
		return playerInstance;
	}
	
	
	private Player() {}
	
	private Player(String playerName, String playerPassword) {
		this.playerName = playerName;
		this.playerPassword = playerPassword;
		this.playerCredits = 1000;
	}
	
	public void addCredits(int add) {
		this.playerCredits += add;
	}
	
	public void subtractCredits(int less) {
		this.playerCredits -= less;
	}
	
	// Get Methods for Player
	public String getPlayerName() {	return playerName; }
	public String getPlayerPassword() { return playerPassword; }
	public int getPlayerCredits() { return playerCredits; }
	public int getPlayerShipID() { return playerShipID; }
	public Ship getPlayerShip() { return playerShip; }
	
	// Set Methods for Player
	public void setPlayerName(String playerName) { this.playerName = playerName; }
	public void setPlayerPassword(String playerPassword) { this.playerPassword = playerPassword; }
	public void setPlayerCredits(int playerCredits) { this.playerCredits = playerCredits; }
	public void setPlayerShipID(int playerShipID) {this.playerShipID = playerShipID; }
	public void setPlayerShip(Ship playerShip) { this.playerShip = playerShip; }
	

	
	
	
	
	
}
