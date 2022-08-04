package com.skillstorm.demo.models;

public class Pokemon {

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}

	private String name;
	private String type;

	public Pokemon() {
		super();
	}

	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
