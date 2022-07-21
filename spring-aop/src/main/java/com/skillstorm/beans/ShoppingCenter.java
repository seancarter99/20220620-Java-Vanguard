package com.skillstorm.beans;

public interface ShoppingCenter {

	// Used for people just looking around
	public void shop();
	
	// Used for people to buy items on their list. Return is the total price
	public double shop(Item[] groceryList, boolean hasMembership);
}
