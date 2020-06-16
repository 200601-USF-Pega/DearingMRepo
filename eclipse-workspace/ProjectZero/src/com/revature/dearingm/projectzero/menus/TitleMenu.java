package com.revature.dearingm.projectzero.menus;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.preojectzero.service.PlayerService;
import com.revature.dearingm.projectzero.dao.PlayerRepoDB;

public class TitleMenu implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	
	// Constructor
	public TitleMenu(MainMenu menu) { mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		// Print Title Menu Welcome Message
		System.out.println("[]==========================================[]");
		System.out.println("][ Welcome to the Galactic Trade Simulator! ][");
		System.out.println("[]==========================================[]\n\n");
		
		// Menu Selection for Title Screen
		System.out.println("[1] New Game");
		System.out.println("[2] Load Game");
		System.out.println("[3] Exit");
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:
					
					mainMenu.setMenuState(mainMenu.newGame);
					break;
			
				case 2:
					
					mainMenu.setMenuState(mainMenu.loadGame);
					break;
					
				case 3:
					
					System.out.println("GoodBye!");
					System.exit(0);
			
			}
		}	
	}
}
