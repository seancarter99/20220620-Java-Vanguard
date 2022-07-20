package com.skillstorm.beans;

import org.springframework.beans.factory.annotation.Qualifier;

public class Nunchuck implements Weapon {

	@Override
	public void attack() {
		System.out.println("Whack!");
	}

}
