package com.skillstorm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.demo.models.Park;
import com.skillstorm.demo.services.ParkService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parks")
@Tag(name = "Park Controller", description = "A place to look up all different state parks")
public class ParkController {
	
	@Autowired
	private ParkService service;

	@GetMapping
	@Operation(summary = "Find all parks!", description = "An API endpoint to find all state parks. Does not support pagination at this time")
	public List<Park> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Park findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Park> create(@RequestBody Park park) {
		park =  service.create(park);
		return new ResponseEntity<>(park, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Park update(@RequestBody Park park, @PathVariable int id) {
		park.setId(id);
		return service.update(park);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
