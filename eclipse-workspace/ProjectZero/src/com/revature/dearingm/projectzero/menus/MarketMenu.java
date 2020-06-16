package com.revature.dearingm.projectzero.menus;

import com.revature.dearingm.projectzero.models.Ship;

public class MarketMenu implements MenuState{
	
	MainMenu mainMenu;
	
	public MarketMenu(MainMenu menu) { 
		
		mainMenu = menu; 
	}
	
	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
		
		
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
	
			
			
			switch (choice) {
			
				case 1: // Buy
					
					System.out.println(">------Available Commodities------<\n");
					
					mainMenu.marketService.displayCommodities();
					mainMenu.marketService.buyItem();
					mainMenu.setMenuState(mainMenu.marketMenu);
					break;
			
				case 2: // Sell
					
					//mainMenu.setMenuState(mainMenu.stationMenu);
					break;
					
				case 3: // Refuel
					
					
					mainMenu.shipService.showStatus();
					break;
					
				case 4: // Return to orbit
					
					mainMenu.setMenuState(mainMenu.orbitMenu);
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
	}

}
