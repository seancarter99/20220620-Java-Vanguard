package com.skillstorm.conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ChinookDbCreds {

	// Static intializer
//	static {
//		
//	}
	
	private static ChinookDbCreds instance;
	private String url;
	private String username;
	private String password;
	
	private ChinookDbCreds() {
		try {
			// Load it into memory immediately so that I have it
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Read the properties (key/value pairs) from the application.properties
			try (InputStream input = ChinookDbCreds.class.getClassLoader()
					.getResourceAsStream("application.properties")) {
				// Properties object
				Properties props = new Properties();
				props.load(input); // Load in the file we opened
				
				// Grab out the keys that I want
				this.url = props.getProperty("db.url");
				this.username = props.getProperty("db.username");
				this.password = props.getProperty("db.password");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ChinookDbCreds getInstance() {
		if (instance == null) { // Lazily initialize a connection to the DB
			instance = new ChinookDbCreds();
		}
		return instance;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	// Makes it simpler to retrieve a connection
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	
}
