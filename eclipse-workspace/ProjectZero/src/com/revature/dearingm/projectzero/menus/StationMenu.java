package com.revature.dearingm.projectzero.menus;

public class StationMenu implements MenuState{
	
	MainMenu mainMenu;
	
	public StationMenu(MainMenu menu) { 
		
		mainMenu = menu; 
	}
	
	@Override
	public void printMenu() {
		
//System.out.println("You are now in orbit\n");
		
		
		System.out.println("[1] Market\n");
		//System.out.println("[2] Land on Planet");
		System.out.println("[3] Ship Status");
		System.out.println("[4] Return to orbit");
		
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:	// Menu State -> Travel Menu
					
					mainMenu.setMenuState(mainMenu.marketMenu);
					break;
			
				//case 2: // Menu State -> Station Menu
					
					//mainMenu.setMenuState(mainMenu.stationMenu);
					//break;
					
				case 3: // Menu State -> Status Menu
					
					
					mainMenu.shipService.showStatus();
					break;
					
				case 4: 
					
					mainMenu.setMenuState(mainMenu.orbitMenu);
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
		
	}

}
