package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.models.Artist;

// I need to tell TomCat about my Servlet
// Akin to altering the web.xml to configure servlet

// http:8080/hello-web/hello
// http:8080/hello-web/hola
@WebServlet(urlPatterns = {"/hello", "/hola"}) // This is an annotation parameter
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -5590522137436265416L;

	// doGet + CTL + SPACE
	// Handle GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet!");
		
		// 1. Send the message itself
		// 2. Redirect them to the HTML page
//		resp.getWriter().write("<h1>Hello Servlet!</h1>");
		resp.sendRedirect("public/pages/index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello POST!");
		// Using Jackson we can parse the request body for the data to create an Artist
		
		// Using JSON
		ObjectMapper mapper = new ObjectMapper(); // Use the mapper to map JSON to POJO
		InputStream reqBody = req.getInputStream();
		// Pass the InputStream as well as the class of the object to translate to
		Artist artist = mapper.readValue(reqBody, Artist.class); 
		System.out.println(artist);
		artist.setName("Sean Carter");
		
		// Send back the updated object as JSON
//		resp.setHeader("Content-Type", "application/json");
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(artist));
		
		// Using HTML Forms
	}
	
}
