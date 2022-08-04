package com.skillstorm.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	// Really should be reading from some cache database instead
	// List<Park>
	
	@GetMapping("/cache/parks")
	// This is where the requests go when the circuit breaker pops
	public String cachedParks() {
		return "Yosemite National Park in California";
	}
}
