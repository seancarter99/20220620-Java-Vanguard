package com.skillstorm.beans;

public class Sword implements Weapon {

	@Override
	public void attack() {
		System.out.println("Swoosh!");
	}
}
