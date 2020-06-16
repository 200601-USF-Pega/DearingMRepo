package garbage;

import java.util.Scanner;

public class SubMenu implements IMenu{ // Main Menu
	
	//Scanner userInput;
	//SubMenu previousMenu;
	
	
	public SubMenu() {
		
	}
	
	
	
	@Override
	public void printMenu() {
		
		IMenu nextMenu;
		MenuFactory menuFactory = new MenuFactory();
		Scanner userInput = new Scanner(System.in);
		
		// Print Welcome Message
		
		while(true) {
			
			//Print Options
			
			System.out.println("Print menu options");
			
			int menuChoice = userInput.nextInt();
			
			switch (menuChoice) {
			
			case 1:
				nextMenu = menuFactory.getMenu("Menu Name");
				nextMenu.printMenu();
				break;
				
			// case 2: etc...
				
			case 0:
				// Quit the game
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Selection");
				continue;
			
			}
			
		}	
		
	}
	
}
