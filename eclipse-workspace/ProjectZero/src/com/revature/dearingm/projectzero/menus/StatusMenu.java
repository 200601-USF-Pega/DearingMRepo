package com.revature.dearingm.projectzero.menus;

public class StatusMenu implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	// Constructor
	public StatusMenu(MainMenu menu) {	mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		mainMenu.shipService.showStatus();
		
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 0:
					
					// Show cargo items
					
					
					break;
			
				case 1:
					// Back to orbit menu
					mainMenu.setMenuState(mainMenu.orbitMenu);
					break;
					
				default:
					System.out.println("Invalid Input");
			
			}
		}	
	}
}
