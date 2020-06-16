package com.revature.dearingm.projectzero.menus;

import com.revature.dearingm.projectzero.models.Ship;

public class LoadGame implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	// Constructor
	public LoadGame(MainMenu menu) { mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		System.out.println("Load Game Menu\n");
		
		
		System.out.println("[1] Enter UserName");
		System.out.println("[2] Back to Title Menu");
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:
					
					if (mainMenu.playerService.loadPlayer()) {
						int id = Ship.getInstance().getShipID();
						mainMenu.shipService.getShip(id);
						mainMenu.setMenuState(mainMenu.orbitMenu);
					}
					
					break;
			
				case 2:
					// Back to title menu
					mainMenu.setMenuState(mainMenu.titleMenu);
					break;
					
				default:
					System.out.println("Invalid Input");
			
			}
		}	
	}
}
