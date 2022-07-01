package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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
	
	/**
	 * @return The list of artists from the database if successful. Null in the event of failure
	 */
	@Override
	public List<Artist> findAll() {
		String sql = "SELECT * FROM artist";
		
		// Connection will auto close in the event of a failure. Due to Autocloseable
		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			// Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			// Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Artist> artists = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// Looping over individual rows of the result set
				Artist artist = new Artist(rs.getInt("ArtistId"), rs.getString("Name"));
				artists.add(artist);
			}
			
			return artists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Failure. If I receive null back from this function. Something went wrong
	}

	/**
	 * @return The Artist with the given id if found, null if the artist does not exist
	 */
	@Override
	public Artist findById(int id) {
		String sql = "SELECT * FROM Artist WHERE ArtistId = " + id;
		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Artist(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Null if not found
	}

	@Override
	public Artist findByName(String name) {
		// This is bad
//		String sql = "SELECT * FROM Artist WHERE name = " + name;
		
		// Instead, use parameterized queries
		String sql = "SELECT * FROM Artist WHERE name = ?";
		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
//			Statement stmt = conn.createStatement();
			
			
			// Instead of using Statement, we will use PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// Java is going to check our statement ahead of time to make sure it's okay
			ps.setString(1, name); // This auto escapes any malicious characters
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // Make sure there was at least one item there
				return new Artist(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Null if not found
	}

	/*
	 * ACID Compliance
	 * 
	 * Atomicity - Treating multiple operation as a single unit. If any fails, they all fail together
	 * Consistency - Data is consistent with the schema. Anything that does not comply will not succeed
	 * Isolation - Each database transaction is isolated and one transaction shouldn't result in another failing
	 *             just because they happened at the same time. Add mutexes to these fields
	 * Durability - In the event of a failure (power cut), the data is persisted
	 */
	
	@Override
	public Artist save(Artist artist) {
		// If this was auto-increment, then the artistid is not needed
		String sql = "INSERT INTO Artist (ArtistId, Name) VALUES (?, ?)";
		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			
			// Start a transaction
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			
			// Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, artist.getId());
			ps.setString(2, artist.getName());
			
			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				// If I want my keys do this code
				ResultSet keys = ps.getGeneratedKeys();
				// List a of all generated keys
//				if (keys.next()) {
//					int key = keys.getInt(1); // Give me the auto generated key
//					artist.setId(key);
//					return artist;
//				}
				conn.commit(); // Executes ALL queries in a given transaction. Green button
				return artist;
			} else {
				conn.rollback(); // Undoes any of the queries. Database pretends those never happened
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
