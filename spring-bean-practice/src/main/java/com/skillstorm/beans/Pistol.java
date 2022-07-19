package com.skillstorm.beans;

public class Pistol implements Weapon {
	
	public Pistol() {
		System.out.println("Creating Pistol");
	}
	
	@Override
	public void attack() {
		System.out.println("Bang bang!");
	}

}
