package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.skillstorm.conf.ChinookDbCreds;
import com.skillstorm.models.Artist;

public class MySQLArtistDAOImpl implements ArtistDAO {

	/*
	 * Steps for JDBC:
	 * 1. Load the JDBC Driver into memory so that I know for sure I have it
	 * 2. Establish a connection using said Driver object
	 * 3. Create an SQL statement
	 * 4. Use the connection object to execute the SQL statement
	 * 5. Parse the returned ResultSet object for the data we want
	 * 6. Close the connection
	 */
	
//	public static final String url = "";
//	public static final String username = "";
//	public static final String password = "";
	
	@Override
	public List<Artist> findAll() {
		String sql = "SELECT * FROM artist";
		
		// Connection will auto close in the event of a failure. Due to Autocloseable
		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			
		}
		
		return null;
	}

	@Override
	public Artist findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist save(Artist artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateName(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
