package com.skillstorm.demo.models;

public class Planet {
	
	private String name;
	private double au;
	
	public Planet() {
		super();
	}

	public Planet(String name, double au) {
		super();
		this.name = name;
		this.au = au;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAu() {
		return au;
	}

	public void setAu(double au) {
		this.au = au;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", au=" + au + "]";
	}
}
