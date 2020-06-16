package com.revature.dearingm.projectzero.models;


public class Commodity {
	
	public int comID;
	public String comName;
	public String comDesc;
	public int comBasePrice;
	public int comBuyPrice;
	public int comQuantity;
	
	
	public Commodity() {
		
	}
	
	public Commodity(int comID, String comName, String comDesc, int comBasePrice, int comQuantity) {
		
		this.comID = comID;
		this.comName = comName;
		this.comDesc = comDesc;
		this.comBasePrice = comBasePrice;
		this.comBuyPrice = comBuyPrice;
		this.comQuantity = comQuantity;
	}

	public int getComID() {
		return comID;
	}
	
	public void setComID(int comID) {
		this.comID = comID;
	}
	
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public String getComDesc() {
		return comDesc;
	}
	
	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}

	public int getComBasePrice() {
		return comBasePrice;
	}

	public void setComBasePrice(int comBasePrice) {
		this.comBasePrice = comBasePrice;
	}
	
	public int getComBuyPrice() {
		return comBuyPrice;
	}
	
	public void setComBuyPrice(int comBuyPrice) {
		this.comBuyPrice = comBuyPrice;
	}
		
	public int getComQuantity() {
		return comQuantity;
	}
	
	public void setComQuantity(int comQuantity) {
		this.comQuantity = comQuantity;
	}
	
	public void addComQuantity(int add) {
		this.comQuantity += add;
	}
	
	public void subtractQuantity(int less) {
		this.comQuantity -= less;
	}
	
	
	
}
