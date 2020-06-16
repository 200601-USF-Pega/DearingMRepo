package com.revature.dearingm.preojectzero.service;

import java.util.List;

import com.revature.dearingm.projectzero.dao.IPlanetRepo;
import com.revature.dearingm.projectzero.models.Planet;

public class PlanetService {
	
	IPlanetRepo repo;
	
	public PlanetService(IPlanetRepo repo) {
		this.repo = repo;
	}
	
	public void getPlanets() {
		
		List<Planet> planets = repo.getAllPlanets();
		
		for (Planet planet: planets) {
			System.out.println(
				"[" + planet.planetID + "] - " + planet.planetName + " - (" + planet.getPlanetDesc() + ")");
		}
				
	}
}
