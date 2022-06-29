package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Artist;

// Queries specific to Artist
public interface ArtistDAO {

	// CRUD is Create, Read, Update, Delete
	
	public List<Artist> findAll();
	public Artist findById(int id);
	public Artist findByName(String name);
	// I like to return the Artist since we can get it's key (if auto incremeneted)
	// You can also use the returned artist to test if it's in the table
	public Artist save(Artist artist);
	public void updateName(Artist artist); // contains the id and updates as needed
	public void delete(Artist artist);
	public void delete(int id);
	public void deleteMany(int[] ids);
}
