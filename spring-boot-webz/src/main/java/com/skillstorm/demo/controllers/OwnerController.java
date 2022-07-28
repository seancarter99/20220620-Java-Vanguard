package com.skillstorm.demo.controllers;

import java.util.List;

import javax.validation.Valid;

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
		return service.findPetsByOwnerId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Owner save(@Valid @RequestBody Owner owner) {
		return service.save(owner);
	}
}
