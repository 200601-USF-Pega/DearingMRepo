
import java.util.Scanner;

import com.revature.dearingm.preojectzero.service.ConnectionService;
import com.revature.dearingm.preojectzero.service.PlayerService;
import com.revature.dearingm.projectzero.dao.PlayerRepoDB;
import com.revature.dearingm.projectzero.menus.MainMenu;
import com.revature.dearingm.projectzero.models.Player;
import com.revature.dearingm.projectzero.models.Ship;

public class Driver {

	static Scanner getInput = new Scanner(System.in);
	
	
	
	
	public static void main(String[] args) {
		
		MainMenu game = new MainMenu();
	
		game.printMenu();
	
	}
	
}


