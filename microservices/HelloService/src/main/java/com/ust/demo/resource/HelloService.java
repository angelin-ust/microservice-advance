package com.ust.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/server")
public class HelloService {

	//logging vendiii
	@Autowired
	Environment environment;//is a refernce to properties
	@GetMapping("/logging")
	public String welcome1() {
		String port=environment.getProperty("server.port");
		return "welcome to this port"+ " " +port;
	}
	////logiing
	
	
	
	//1st step giving strmeasage a default value
	//value is coming from the appication.property value we trying to pull 
	//valuee aa spring appication name avide ollu name 
	//pull cheyumm
	@Value("name")
	String strMessage;
	
	@GetMapping
	public String welcome (){
		return "Programming Microservices"+" "+ strMessage;
	}
	
	//2nd steppanne after gatewayy
	@GetMapping("/status")
	public String status() {
		return "Up and running->>>..";
	}
	
	//3rd billing
	@GetMapping("/billing/status")
	public String billstatus() {
		return "billing approved";
	}

	
	
	
	
	
}
