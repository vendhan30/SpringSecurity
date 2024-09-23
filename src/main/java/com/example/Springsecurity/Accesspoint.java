package com.example.Springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//AUTHENDICATION

@RestController
public class Accesspoint {
    
	@GetMapping(value="/student")
	public String getStudent() {
		return "hello Student";
	}

	
//AUTHORIZATION
@GetMapping(value="/trainer")
public String getTrainer() {
	return "hello trainer";
}

@GetMapping(value="/manager")
public String getManager() {
	return "hello Manager";
}
}

