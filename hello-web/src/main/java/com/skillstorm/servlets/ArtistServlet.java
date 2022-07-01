package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.ArtistDAO;
import com.skillstorm.daos.MySQLArtistDAOImpl;
import com.skillstorm.models.Artist;
import com.skillstorm.models.NotFound;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/artists/*")
public class ArtistServlet extends HttpServlet {

	private static final long serialVersionUID = 5795274365670879885L;
	ArtistDAO dao = new MySQLArtistDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	// Returns all artists
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = urlService.extractIdFromURL(req.getPathInfo());
			// This means they want a specific artist. Find that artist
			Artist artist = dao.findById(id);
			if (artist != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(artist));
			} else {
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new NotFound("No artist with the provided Id found")));
			}
			
		} catch (Exception e) {
			// Means that there wasn't an id in the URL. Fetch all artists instead
			List<Artist> artists = dao.findAll();
			System.out.println(artists);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(artists));
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Artist newArtist = mapper.readValue(reqBody, Artist.class);
		newArtist = dao.save(newArtist); // IF the id changed
		if (newArtist != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(newArtist));
			resp.setStatus(201); // The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound("Unable to create artist")));
		}
	}

}
