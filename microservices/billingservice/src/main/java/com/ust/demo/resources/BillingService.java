package com.ust.demo.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billing")
public class BillingService {

	
	
	@Value("billing service")
	String strMessage;
	
	@GetMapping
	public String welcome (){
		return "Programming Microservices"+" "+ strMessage;
	}
}
