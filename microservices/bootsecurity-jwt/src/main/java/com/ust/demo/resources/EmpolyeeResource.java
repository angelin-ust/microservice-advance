package com.ust.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.demo.MyUserDetailsService;
import com.ust.demo.model.AuthenticationRequest;
import com.ust.demo.model.AuthenticationResponse;
import com.ust.demo.util.JwtUtil;

@RestController
public class EmpolyeeResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@GetMapping("/greet")
	public String greet() {
		return "working";
	}
	
//	@GetMapping
//	@RequestMapping("/admin")
//	public String greetAdmin() {
//		return "Admin@work";
//	}
//	
//	@GetMapping
//	@RequestMapping("/user")
//	public String greetUser() {
//		return "User@work";
//	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
               System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

	
	
	
	
}
