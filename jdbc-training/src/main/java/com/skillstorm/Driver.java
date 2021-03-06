package com.skillstorm;

import java.util.List;

import com.skillstorm.daos.ArtistDAO;
import com.skillstorm.daos.MySQLArtistDAOImpl;
import com.skillstorm.models.Artist;

public class Driver {
	
	// static initializer
//	static {
//		try {
//			// Load it into memory immediately so that I have it
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		ArtistDAO dao = new MySQLArtistDAOImpl();
		
		List<Artist> artists = dao.findAll();
		System.out.println(artists);
		
		System.out.println(dao.findById(55));
		System.out.println(dao.findById(1000)); // Could not find
		
		// SQL Injection example
		// "SELECT * FROM Artist WHERE name = " + name;
		System.out.println(dao.findByName("'' OR '' = ''; --")); // This returns ALL artists
	}
}
