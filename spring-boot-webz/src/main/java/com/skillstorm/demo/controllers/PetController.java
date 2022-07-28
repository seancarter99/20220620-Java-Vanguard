package com.skillstorm.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.demo.models.Pet;
import com.skillstorm.demo.services.PetService;

/*
 * REST (Representational State Transfer)
 * SOAP, GraphQL
 * 
 * 6 Constraints of REST:
 * 
 * 1. Uniform Interface
 *    - One logical URI (URL) per resource
 *    - Because of this, naming of URLs is VERY important
 * 2. Client-Server
 *    - Client and Server should be completely separate (only know about each other through API endpoints)
 *    - Allows the Server and the Client to evolve separately
 * 3. Stateless
 *    - Every request should be stateless (no data is persisted. Server does not remember)
 *    - Treat every request as a new request
 *    - Sessions are stateful since they're bound to a server (JWTs are stateless)
 * 4. Cacheable
 *    - Requests should be able to have a header that enables a resource to be "cached"
 *    - Should be able to be invalidated on a whim (clear the cache)
 *    - Typically done through HTTP headers such as "Expires" or "Cache-Control"
 * 5. Layered System
 *    - Gateways (ELB)
 * 6. Code On Demand (Optional)
 *    - Have the ability to return executable code
 *    
 * URL Naming Conventions:
 * 
 * 1. Do NOT use the HTTP method in the URL. Let the method carry the meaning
 * Bad: DELETE http://my-website.com/deleteMovie/42
 *      GET http://my-website.com/findMovie/42
 * Good: DELETE http://my-website.com/movies/42
 *       GET http://my-website.com/movies/42
 * 
 * 2. Implement hierarchies in your URL (Treat it like a file structure)
 * http://my-website.com/owners/4/pets
 * 
 * 3. Filtering (Allow user to pass parameters that alter a request)
 * GET http://my-website.com/movies (Returns every movie)
 * GET http://my-website.com/movies?limit=100&page=3 (Returns every movie)
 * 
 * 4. Versioning (Enables our backend API to evolve without breaking things for existing users)
 * 
 * Changing this will result in breaking peoples' frontend code
 * GET http://my-website.com/movies -> [{title: string, year: number, director: {name: string}]
 * 
 * Instead label v1 as deprecated and just spin up a new API endpoint for v2
 * GET http://my-website.com/movies/v1 -> [{title: string, year: number, director: string]
 * GET http://my-website.com/movies/v2 -> [{title: string, year: number, director: {name: string}]
 */

@RestController // @RestController = @Controller + @ResponseBody
@CrossOrigin("*") // If you don't like CorsFilter, you're in luck. They do the same thing
@RequestMapping("/pets") // Adds /pets to all methods in this function
public class PetController {
	
	@Autowired
	private PetService service;
	
	// find all
	@GetMapping
	public Set<Pet> findAllOwnerlessPets() {
		// List will get transformed by Jackson into a JSON array
//		LinkedList<Pet> pets = new LinkedList<>();
//		pets.add(new Pet(1, "Turkey", "Dinner", "Mr. Gobble", null));
//		pets.add(new Pet(2, "Alien Donkey", "Martian", "Marty", null));
//		pets.add(new Pet(3, "Parrot", "African Gray", "Einstein", null));
		return service.findAllOwnerlessPets();
	}
	
	// find by id
	// The {id} symbolizes that I can pull this out of the URL path
	@GetMapping("/{id}")
	public Pet findById(@PathVariable int id) {
//		return new Pet(id, "Dog", "Golden Doodle", "Jimmy", null);
		return service.findById(id);
	}
	
	// create
	@PostMapping
	public ResponseEntity<Pet> create(@Valid @RequestBody Pet pet) {
		return new ResponseEntity<>(service.save(pet), HttpStatus.CREATED);
	}
	
	// update
	@PutMapping("/{id}")
	public Pet update(@Valid @RequestBody Pet pet, @PathVariable int id) {
		pet.setId(id);
		return service.update(pet); // repository.save(pet);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		// Deletes the pet from the database
		service.deleteById(id);
	}
}
