package com.skillstorm.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // This adds @ResponseBody to every method in the class
@RestController // This annotation is @Controller + @ResponseBody
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String sayHello() {
		return "<h1>Hello</h1>"; // This is trying to find a file called Hello.html
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/goodbye")
	public String sayGoodbye() {
		return "<h1>Goodbye!</h1>";
	}
}
