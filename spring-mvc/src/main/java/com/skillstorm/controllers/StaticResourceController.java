package com.skillstorm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Controller represents the Controller in the MVC pattern
// This guy handles HTTP requests
public class StaticResourceController {

	// path: url
	// method: HTTP method
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index() {
		System.out.println("Redirecting to home page!");
		return "index";
	}
}
