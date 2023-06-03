package com.ust.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

	
	
	@GetMapping("/greet")
	public String message() {
		return "Hello welcome Angelin ";
	}
}
