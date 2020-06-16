package com.revature.dearingm.preojectzero.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dearingm.projectzero.dao.ICargoRepo;
import com.revature.dearingm.projectzero.dao.IMarketRepo;
import com.revature.dearingm.projectzero.models.Commodity;
import com.revature.dearingm.projectzero.models.Player;
import com.revature.dearingm.projectzero.models.Ship;

public class CargoService {
	
	ICargoRepo repo;
	Scanner input = new Scanner(System.in);
	Player player = Player.getInstance();
	
	Ship ship = Ship.getInstance();
	
	ArrayList<Commodity> cargo;
	
	public CargoService(ICargoRepo repo) {
		this.repo = repo;
	}
	
	public void displayCargo() {
		
		cargo = repo.getCargoInventory(ship);
		
		int n = 0;
		for (Commodity item: cargo) {
			
			n = n+1;
			//System.out.println("index: " + commodities.size());
			System.out.println(
				"[" + n + 
				"] - " + item.getComName() + 
				" - (" + item.getComDesc() + 
				") - " + item.getComBasePrice() + "cr");
				
		}
		
	}
	
	public void sellItem() {	
		
		if (input.hasNextInt()) {
			int choice = input.nextInt();
			
			try {
				
				
				Commodity selectedItem = cargo.get(choice-1);
				
				
				System.out.println("How many? (" + selectedItem.getComQuantity() + " on the ship)");
				
				int quantity = input.nextInt();
				
				if (quantity > selectedItem.getComQuantity()) {
					
					System.out.println("Invalid Selection");
				} else {
					int total = quantity * selectedItem.getComBasePrice();
					
											
					System.out.println("Confirm Sell? Total Gain: " + total + "cr\n");
					System.out.println("[0] No / [1] Yes");
						
					
					int confirm = input.nextInt();
					
						switch (confirm) {
					
					 		case 1:
					 			player.addCredits(total);
					 			
					 			if (selectedItem.comQuantity == quantity) {
					 				// remove item from DB
					 				
					 				repo.removeCargoFromTable(ship,  selectedItem);
					 				cargo.remove(choice);
					 				
					 			} else {
					 				// reduce quantity and update record
					 				
					 				
					 				selectedItem.subtractQuantity(quantity);
					 				repo.addOrRemoveCargo(ship, selectedItem);
					 			}
					 			
					 			
					 		
					 		default:
					 			break;
					 			
						
					}
				}
				
			} catch (Exception e ) {
				
				System.out.println("Invalid Selection");
				
			}
			
		}
			
			
			
	
	}
	
	
}
