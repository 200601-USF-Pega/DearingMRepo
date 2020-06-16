package com.revature.dearingm.projectzero.menus;

public class OrbitMenu implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	// Constructor
	public OrbitMenu(MainMenu menu) {	mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		System.out.println("You are now in orbit\n");
		
		
		System.out.println("[1] Travel");
		System.out.println("[2] Land on Planet");
		System.out.println("[3] Ship Status");
		System.out.println("[4] Quit to Title Menu");
		
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:	// Menu State -> Travel Menu
					
					mainMenu.setMenuState(mainMenu.travelMenu);
					break;
			
				case 2: // Menu State -> Station Menu
					
					mainMenu.setMenuState(mainMenu.stationMenu);
					break;
					
				case 3: // Menu State -> Status Menu
					
					mainMenu.setMenuState(mainMenu.statusMenu);
					break;
					
				case 4: // Menu State -> Title Menu
					
					if (mainMenu.playerService.saveGame()) {
						
						mainMenu.shipService.saveShip();
						mainMenu.setMenuState(mainMenu.titleMenu);
					} else {
						System.out.println("Something went wrong!");
					}
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
			
			}
		}	
	}
}
