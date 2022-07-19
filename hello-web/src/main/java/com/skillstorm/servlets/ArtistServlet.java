package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletConfig;
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
	
	/*
	 * Servlet Lifecycle
	 * 
	 * init - A method called when the web server first creates our servlet
	 * service - method called before EVERY request
	 * destroy - method called when the web server is stopped/servlet terminates
	 */
	
	@Override
	public void init() throws ServletException {
		// This allows us to write code that is run right as the servlet is created
		// You can establish any connections

		System.out.println("ArtistServlet Created!");
		super.init();
	}

	@Override
	public void destroy() {
		// If any connections were established in init
		// Terminate those connections here
		System.out.println("ArtistServlet Destroyed!");
		super.destroy();
	}
	
	// I would prefer filters to this
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// This method activates on ALL HTTP requests to this servlet
		System.out.println("Servicing request!");
		super.service(req, resp); // Keep this line
	}
	
	private static final long serialVersionUID = 5795274365670879885L;
	ArtistDAO dao = new MySQLArtistDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	// Returns all artists
	// /artists/{id}
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
//		int id = Integer.parseInt(req.getParameter("artist-id"));
//		String name = req.getParameter("artist-name");
//		System.out.println(id);
//		System.out.println(name);
//		
		
		InputStream reqBody = req.getInputStream();
		Artist newArtist = mapper.readValue(reqBody, Artist.class);
//		validatorService.validate(newArtist); // Could be a service
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