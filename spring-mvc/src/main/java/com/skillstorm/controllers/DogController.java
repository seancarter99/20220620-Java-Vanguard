package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.models.Dog;

@Controller
public class DogController {

	// To get all dogs
	// GetMapping is @RequestMapping with method as RequestMethod.GET by default
	@GetMapping("/dogs")
	@ResponseBody
	public List<Dog> findAllDogs() {
		System.out.println("Finding all dogs!");
		ArrayList<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Levi", "Golden Retriever", 1));
		dogs.add(new Dog("Shelty", "Shetsland Sheep Dog", 5));
		
		// Nice thing about Spring MVC.
		
		// Jackson is auto done for us if we annotate the method @ResponseBody
		return dogs;
	}
	
	// Find dog by id
	
	// Create dog
	
	// Update dog
	
	// Delete dog
}
