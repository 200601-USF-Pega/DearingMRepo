package com.revature.dearingm.projectzero.menus;

public class TravelMenu implements MenuState {
	
	// Store reference to Menu State control
	MainMenu mainMenu;
	
	//private String planet;
	//private String[] locations = {"Sol", "Ghost", "Helenna"};
	
	// Constructor
	public TravelMenu(MainMenu menu) {	mainMenu = menu; }
	
	@Override
	public void printMenu() {
		
		mainMenu.planetService.getPlanets();
		

		
		
		
		
		if (mainMenu.userInput.hasNextInt()) {
			int choice = mainMenu.userInput.nextInt();
			
			switch (choice) {
			
				case 1:
					
					//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-//
					// LOGIC FOR TRAVEL SIMULATION  & EVENTS //				
					//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-//
					
					System.out.println("Map:");
					System.out.println("[x]==================================[x]");
					System.out.println("||                                    ||");
					System.out.println("||  *         o                 o     ||");
					System.out.println("||                      *             ||");
					System.out.println("||      o                             ||");
					System.out.println("||            *        o              ||");
					System.out.println("||                         o          ||");
					System.out.println("||   *           <o>               *  ||");
					System.out.println("[x]==================================[x]");
					
					System.out.println("\n[] Back to Previous Menu\"");
					//planet = locations[0];
					//destSelected = true;
					//mainMenu.setMenuState(mainMenu.orbitMenu);
					break;
			
				case 2: // With destination selected, transition to next destination
					
					//if (destSelected) 	System.out.println("Blast Off!"); // plus change player location
					//else 				System.out.println("Cannot Comply");//
					break;
					
				case 3: // With destination selected, show details about selected planet
					
					//if (destSelected)	System.out.println("Here's some info about " + planet + "!");
					//else				System.out.println("Cannot Comply");
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
