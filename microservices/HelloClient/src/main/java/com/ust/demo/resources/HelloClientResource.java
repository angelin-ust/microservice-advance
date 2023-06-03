package com.ust.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class HelloClientResource {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/server")
	public String callServer() {
		//helloserver illl poyii ath int url nookumm and then change the port
		// also
		String url="http://localhost:8094/rest/server";// 1st without
		//gateway that means we give the port for the client
		// without gateway but here
//		String url="http://localhost:8093/rest/server/status";
		//the port of gateway inteeaa the client is accesing services
		// for gateaways
		String output=template.getForObject(url, String.class);
		return output;
		
		
	}
	@GetMapping("/billing")
	public String callbilling() {
		String url="http://localhost:8093/rest/billing";
		String output=template.getForObject(url, String.class);
		return output;
	}
}
