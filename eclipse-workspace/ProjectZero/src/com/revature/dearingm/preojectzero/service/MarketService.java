package com.revature.dearingm.preojectzero.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dearingm.projectzero.dao.IMarketRepo;
import com.revature.dearingm.projectzero.menus.MainMenu;
import com.revature.dearingm.projectzero.menus.MarketMenu;
import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Planet;
import com.revature.dearingm.projectzero.models.Player;
import com.revature.dearingm.projectzero.models.Ship;

public class MarketService {
	
	IMarketRepo repo;
	CargoService cargoService;
	
	
	Scanner input = new Scanner(System.in);
	Player player = Player.getInstance();
	
	Ship ship = Ship.getInstance();
	
	ArrayList<Commodity> commodities;
	
	public MarketService(CargoService cargoService, IMarketRepo repo) {
		this.cargoService = cargoService;
		this.repo = repo;
	}
	
	public void displayCommodities() {
		
		commodities = repo.getPlanetInventory(ship);
		
		int n = 0;
		for (Commodity item: commodities) {
			
			n = n+1;
			//System.out.println("index: " + commodities.size());
			System.out.println(
				"[" + n + 
				"] - " + item.getComName() + 
				" - (" + item.getComDesc() + 
				") - " + item.getComBasePrice() + "cr");
				
		}
		
	}
	
	public void buyItem() {	
		
		if (input.hasNextInt()) {
			int choice = input.nextInt();
			
			try {
				
				
				Commodity selectedItem = commodities.get(choice-1);
				
				
				System.out.println("How many? (" + selectedItem.getComQuantity() + " left)");
				
				int quantity = input.nextInt();
				
				if (quantity > selectedItem.getComQuantity()) {
					
					System.out.println("Invalid Selection");
				} else {
					int total = quantity * selectedItem.getComBasePrice();
					
					if (player.getPlayerCredits() < total) {
						System.out.println("Insufficient Credits!");
						
						
					} else {
						
						System.out.println("Confirm Purchase? Total: " + total + "cr\n");
						System.out.println("[0] No / [1] Yes");
						int confirm = input.nextInt();
					
						switch (confirm) {
					
					 		case 1:
					 			player.subtractCredits(total);
					 			
					 			if (selectedItem.comQuantity == quantity) {
					 				// remove item from DB
					 				repo.deleteFromTable(selectedItem, ship);
					 				commodities.remove(choice);
					 			} else {
					 				// reduce quantity and update record
					 				selectedItem.subtractQuantity(quantity);
					 				repo.addOrRemoveInventory(selectedItem, ship);
					 			}
					 			
					 			ship.addCargo(selectedItem);
					 			
					 			if (cargoService.repo.checkCargo(ship)) {
					 				cargoService.repo.addOrRemoveCargo(ship, selectedItem);
					 			}else {
					 				cargoService.repo.addCargoToTable(ship, selectedItem);
					 			}
					 			
					 		default:
					 			break;
					 			
						}
					}
				}
				
			} catch (Exception e ) {
				
				System.out.println("Invalid Selection");
				
			}
			
		}
			
			
			
		
		//switch (choice) {
	}	
		

	public void calculatePrice(Commodity com) {
		
		
	}
	
	
	}
