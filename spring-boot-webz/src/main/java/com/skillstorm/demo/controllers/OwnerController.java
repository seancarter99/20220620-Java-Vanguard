package com.skillstorm.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.demo.models.Owner;
import com.skillstorm.demo.models.Pet;
import com.skillstorm.demo.services.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	
	/*
	 * Loggers allow us to flip a switch on certain log levels in certain environments
	 * This way, I don't have to delete any debug prints, they'll just be disabled
	 * 
	 * Log Levels:
	 * TRACE: A specific type of debug more pertaining to control flow
	 * DEBUG: These are used for debug prints. They don't make it to production
	 * INFO: Informational. Ex. Printing the IP address on a web request
	 * WARN: Something went wrong, but was recovered from. Worth looking into
	 * ERROR: Larger issues that could break the app. Ex. Third party API is down
	 * FATAL: Application cannot continue as is. Ex. Database is gone
	 * 
	 * If I set the log level to info. Then only info-fatal logs are printed. Debug and trace do not happen
	 */
	
	private static final Logger log = Logger.getLogger(OwnerController.class);
	
	@Autowired
	private OwnerService service;
	
	// "/owners?limit=5&page=2"
	@GetMapping
	//                                               Must be a string
	public List<Owner> findAll(@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "3") int limit) {
		return service.findAll(--page, limit);
	}
	
	@GetMapping("/{id}")
	public Owner findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// /owners/1/pets
	@GetMapping("/{id}/pets")
	public List<Pet> findPetsByOwnerId(@PathVariable int id) {
		log.warn("Finding pets with owner id of " + id);
//		System.out.println("Finding pets with owner id of " + id); // These prints are frowned upon in industry
		return service.findPetsByOwnerId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Owner save(@Valid @RequestBody Owner owner) {
//		System.out.println("Got here!"); // This never it to production
		log.trace("Got here!");
		return service.save(owner);
	}
}
