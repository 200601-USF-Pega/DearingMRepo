package garbage;

import java.util.Scanner;

public class Title { // Main Menu
	
	
	Menu previousMenu;
	
	
	public TitleMenu() {
		
	}
	
	public TitleMenu(Menu previousMenu) {
		this.previousMenu = previousMenu;
	}
	
	@Override
	public void printMenu() {
		
		IMenu nextMenu;
		MenuFactory menuFactory = new MenuFactory();
		Scanner userInput = new Scanner(System.in);
		
		
		
		
		
		
		while(true) {
			
			//Print Options
			System.out.println(" Please select an option below to get started.");
			System.out.println(" [New Game (1)] [Load Game (2)] [Quit (3)]");
			
			
			
			int menuChoice = userInput.nextInt();
			
			switch (menuChoice) {
			
			case 1:	// New Game
					
					// TODO:
					// Create new player
						// Get username
							 // Check name is available (JDBC)
						// Get password
						// Write to DB
						
				// Logic For New Game
				nextMenu = menuFactory.getMenu("stationmenu");
				nextMenu.printMenu();
				break;
				
				
				
			case 2:	// Load Game
				
					// TODO:
					// Get username + password
					// search database
					// Deserialize player data
				nextMenu = menuFactory.getMenu();
				
				
			case 3:
				// Quit the game
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Selection");
				continue;
			
			}
		}
		
		
	}
	
/*	
	// Basic Menu Selection
	public void chooseMenu() {	
		
		System.out.println("Please Choose a Menu: ");
		
		if (userInput.hasNextInt()) {
			
			int menuChoice = userInput.nextInt();
			
			switch (menuChoice) {
		
				case 1: 
					printMenu();
					break;
				case 2: 
					SubMenu subMenu = new SubMenu(userInput);
					subMenu.printMenu();
					break;
				default: 
					System.out.println("Invalid Input");
					break;
			}
		}
	}
	
	// Print the Main Menu
	public void printMenu() {
		System.out.println("========================");
		System.out.println("This is the Main Menu");
		System.out.println("========================");
		chooseMenu();
	}															*/
	
}
