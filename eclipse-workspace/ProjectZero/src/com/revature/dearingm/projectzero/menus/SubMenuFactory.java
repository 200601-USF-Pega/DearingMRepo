package com.revature.dearingm.projectzero.menus;

public class SubMenuFactory {
	public IMenu getMenu(String menuType) {
		switch (menuType.toLowerCase()) {
			case "marketmenu":
				return new MarketMenu();
			case "statusmenu":
				return new StatusMenu();
			default:
				return null;
				
		}
	}
}
