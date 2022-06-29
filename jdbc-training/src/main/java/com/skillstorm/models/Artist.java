package com.skillstorm.models;

public class Artist {

	private int id; // ArtistId in the database
	private String name;
	
	public Artist() {
		
	}
	
	// Use this one for auto increment ids
	public Artist(String name) {
		
	}
	
	public Artist(int id, String name) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}
	
	
}
