package com.revature.dearingm.projectzero.models;

public class Planet {
	
	public int planetID;
	public String planetName;
	public String planetDesc;
	
	
	public Planet() {
		
	}
	
	public Planet(int planetID, String planetName, String planetDesc, int comPriceHigh, int comPriceLow) {
		super();
		
		this.planetID = planetID;
		this.planetName = planetName;
		this.planetDesc = planetDesc;
		this.comPriceHigh = comPriceHigh;
		this.comPriceLow = comPriceLow;
	}
	
	public int getPlanetID() {
		return planetID;
	}
	
	public void setPlanetID(int id) {
		this.planetID = id;
	}
	
	public String getplanetName() {
		return planetName;
	}
	
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	public String getPlanetDesc() {
		return planetDesc;
	}
	
	public void setPlanetDesc(String planetDesc) {
		this.planetDesc = planetDesc;
	}
	
	public int getComPriceHigh() {
		return comPriceHigh;
	}
	
	public void setComPriceHigh(int comPriceHigh) {
		this.comPriceHigh = comPriceHigh;
	}
	
	public int getComPriceLow() {
		return comPriceLow;
	}
	
	public void setComPriceLow(int comPriceLow) {
		this.comPriceLow = comPriceLow;
	}
	
	
	
}







