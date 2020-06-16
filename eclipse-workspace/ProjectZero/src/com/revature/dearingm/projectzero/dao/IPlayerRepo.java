package com.revature.dearingm.projectzero.dao;

import com.revature.dearingm.projectzero.models.Player;

public interface IPlayerRepo {
	
	public void addNewPlayer(Player player);
	public boolean checkUsername(String userName);
	public boolean getPlayer(String username, String password);
	public boolean savePlayer(Player player);
	
}
