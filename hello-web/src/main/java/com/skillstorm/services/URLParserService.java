package com.skillstorm.services;

public class URLParserService {
	public int extractIdFromURL(String url) {
//		System.out.println(url); // /12/123
		String[] splitString = url.split("/"); // [12, 123]
		
		return Integer.parseInt(splitString[1]); // Throws an exception if this isn't a int
	}
}
