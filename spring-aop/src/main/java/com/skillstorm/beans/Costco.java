package com.skillstorm.beans;

import org.springframework.stereotype.Component;

@Component
public class Costco implements ShoppingCenter {

	@Override
	public void shop() {
		System.out.println("Shopping at Costco!");
	}

	// Shopping involves getting greeted at the door
	// Having the membership id checked
	// Having the receipt checked + signed upon leaving
	// Upon successful transaction, an electronic copy of the receipt is emailed as well
	@Override
	public double shop(Item[] groceryList, boolean hasMembership) { // joinpoint
		if (groceryList == null) {
			throw new IllegalArgumentException("No null groceryList allowed!");
		}
		System.out.println("Buying items at Costco!");
		double total = 0;
		for (Item item : groceryList) {
			total += item.getPrice();
		}
		
		
		
		return total;
	}

}
