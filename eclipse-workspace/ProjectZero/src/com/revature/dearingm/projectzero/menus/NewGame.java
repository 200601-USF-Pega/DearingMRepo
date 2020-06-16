package com.revature.dearingm.projectzero.menus;

public class NewGame implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	// Constructor
	public NewGame(MainMenu menu) {	mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		System.out.println("New Game Menu\n");
		
		
		System.out.println("[1] Create New Player");
		System.out.println("[2] Back to Title Menu");
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:
					
					if (mainMenu.playerService.createNewPlayer()) {
						mainMenu.shipService.newShip();
						mainMenu.setMenuState(mainMenu.orbitMenu);
					}
						
					break;
			
				case 2:
					
					mainMenu.setMenuState(mainMenu.titleMenu);
					break;
					
				default:
					System.out.println("Invalid Input");
			
			}
		}	
		
		else mainMenu.setMenuState(mainMenu.titleMenu);
	}
}
