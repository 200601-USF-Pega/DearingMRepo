package com.revature.dearingm.projectzero.menus;

import java.util.Scanner;

import com.revature.dearingm.preojectzero.service.CargoService;
import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.preojectzero.service.MarketService;
import com.revature.dearingm.preojectzero.service.PlanetService;
import com.revature.dearingm.preojectzero.service.PlayerService;
import com.revature.dearingm.preojectzero.service.ShipService;
import com.revature.dearingm.projectzero.dao.CargoRepoDB;
import com.revature.dearingm.projectzero.dao.MarketRepoDB;
import com.revature.dearingm.projectzero.dao.PlanetRepoDB;
import com.revature.dearingm.projectzero.dao.PlayerRepoDB;
import com.revature.dearingm.projectzero.dao.ShipRepoDB;

public class MainMenu { // Main Menu
	
	// Menu State Behaviors
	MenuState titleMenu;
	MenuState newGame;
	MenuState loadGame;
	MenuState orbitMenu;
	MenuState travelMenu;
	MenuState stationMenu;
	MenuState statusMenu;
	MenuState marketMenu;
	
	// For Changing current state
	MenuState menuState;
	MenuState prevState;
	
	Scanner userInput = new Scanner(System.in);
	
	private ConnectionService connectionService =  ConnectionService.getInstance();
	public CargoService cargoService = new CargoService(new CargoRepoDB(connectionService));
	
	public PlayerService playerService = new PlayerService(new PlayerRepoDB(connectionService));
	public ShipService shipService = new ShipService(new ShipRepoDB(connectionService));
	public PlanetService planetService = new PlanetService(new PlanetRepoDB(connectionService));
	public MarketService marketService = new MarketService(cargoService, new MarketRepoDB(connectionService));
	
	
	public MainMenu() {
		
		titleMenu = new TitleMenu(this);
		newGame = new NewGame(this);
		loadGame = new LoadGame(this);
		orbitMenu = new OrbitMenu(this);
		travelMenu = new TravelMenu(this);
		stationMenu = new StationMenu(this);
		statusMenu = new StatusMenu(this);
		marketMenu = new MarketMenu(this);
		
		// Set initial menu state
		menuState = titleMenu;
	}
	
	void setMenuState(MenuState newMenu) { menuState = newMenu; }
	
	void setPrevMenu(MenuState newMenu) { prevState = newMenu; }
	
	public void printMenu() {
		
		while (true) {
		
			menuState.printMenu();
		}
	}
	
	// Methods for changing Menu State
	public MenuState getTitleMenuState() 	{ return titleMenu; }
	public MenuState getNewGameState() 		{ return newGame; }
	public MenuState getLoadGameState() 	{ return loadGame; }
	public MenuState getOrbitMenuState() 	{ return orbitMenu; }
	public MenuState getTravelMenuState() 	{ return travelMenu; }
	public MenuState getStationMenuState() 	{ return stationMenu; }
	public MenuState getStatusMenuState() 	{ return statusMenu; }
	public MenuState getMarketMenuState() 	{ return marketMenu; }
	
	public MenuState getPrevMenu()			{ return prevState; }
	
	
	
	
	
	
	
	
	
		
}
	
	
	
	
	
	/*
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
	

