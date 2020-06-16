package com.revature.dearingm.preojectzero.service;


import java.util.Scanner;

import com.revature.dearingm.projectzero.dao.IPlayerRepo;
import com.revature.dearingm.projectzero.models.Player;
import com.revature.dearingm.projectzero.models.Ship;

public class PlayerService {
	
	Scanner input = new Scanner(System.in);
	IPlayerRepo repo;
	
	public PlayerService(IPlayerRepo repo) {
		this.repo = repo;
		
	}
	
	public boolean createNewPlayer() {
		
		System.out.println("Choose a unique username");
		String username = input.next();
		String password;
		
		if (!repo.checkUsername(username)) {
			
			boolean validation = false;
			
			do {
				
				System.out.println("Choose a password");
				password = input.next();
				System.out.println("Confirm password");
				String confirm = input.next();
				
				if (password == confirm)
					validation = true;
					break;
				
			} while (!validation);
			
			// Initialize values for a new player
			Player player = Player.getInstance();
			player.setPlayerName(username);
			player.setPlayerPassword(password);
			player.setPlayerCredits(1000);
			repo.addNewPlayer(player);
			
			return true;
		}
		else {
			System.out.println("Username already taken!");
			return false;
		}
		
		
		
		
	}
	
	public boolean loadPlayer() {
		
		System.out.println("Please Enter Your Username");
		String user = input.next();
		System.out.println("Please Enter Your Password");
		String pass = input.next();
		
		if (repo.getPlayer(user, pass)) {
			return true;
		}
		else return false;
	}
	
	public boolean saveGame() {
		
		Player player = Player.getInstance();
		Ship ship = Ship.getInstance();
		player.setPlayerShipID(ship.getShipID());
		
		if (repo.savePlayer(player)) {
			return true;
		}
		else return false;
		
	}
}
