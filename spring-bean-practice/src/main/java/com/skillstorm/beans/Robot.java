package com.skillstorm.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Robot implements Character {

	// Using the beans I have, give me one
	@Autowired
	// Spring first checks the type to see if there's one only one bean with that type
	// If there is only one, Spring just gives me that
	// Else, the variable name is used to determine what bean I want
//	@Qualifier("pistol")
	// If I want the variable name to be weapon, but I want to use a pistol. Use @Qualifier
	Weapon fadsf;
	
	@Override
	public void act() {
		System.out.println("Beep boop");
		fadsf.attack();
	}

}
