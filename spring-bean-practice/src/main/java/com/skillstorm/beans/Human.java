package com.skillstorm.beans;


// I want my Knights to use swords and the cowboys to use pistols
public class Human implements Character {

	private Weapon primaryWeapon; // weapon bean gets injected here
	
	public Human() {
		this.primaryWeapon = null;
	}
	
	public Human(Weapon weapon) {
		this.primaryWeapon = weapon;
	}
	
	public void setPrimaryWeapon(Weapon weapon) {
		this.primaryWeapon = weapon;
	}
	
	@Override
	public void act() {
		System.out.println("Hello!");
		primaryWeapon.attack(); // Attack with the equipped weapon
	}

}
