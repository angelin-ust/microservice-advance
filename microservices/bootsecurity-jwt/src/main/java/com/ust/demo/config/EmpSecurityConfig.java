package com.ust.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {

	//after
	//Security has two aspect 1)authentication
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//inmemoryAnthication the credential are stored somewhere in the memory
//		//where the security manager have to serach for credential
//		auth.inMemoryAuthentication().
//		withUser("bond").
//		password("james").roles("USER").
//		and().
//		withUser("poo").
//		password("bear").roles("ADMIN");
//	}
//	
//	@Bean
//	@SuppressWarnings("deprecation")
//	public PasswordEncoder getPassEncoder() 
//	{
//		//Encryption we are using here thats NoOpPasswordEncoder
//		//the code will run but as its old version thats it strikes
//		return   NoOpPasswordEncoder.getInstance();
//	}
//	
//	
//	//ee method use cheythille user and admin namukuu directly access
//	//cheyane pattumm
//	//role pro kannuillaa akkum(endpoint pro akkunilla that "/user or "/admin"
//	//there will be no pro
//	//the use cheyumpolAuthorizeCheyumm 
//	//admin credential use cheythall
//	//matramm enter cheyane pattullu
//	//user credential use cheythall
//		//matramm enter cheyane pattullu
//	protected void configure(HttpSecurity http) throws Exception
//	{  //antMatcher like regularexpression polle akkum
//		http.authorizeRequests()
//		.antMatchers("/admin").hasRole("ADMIN")
//		.antMatchers("/user").hasRole("USER")
//		.antMatchers("/").permitAll().
//		and().formLogin();
//	}
//	
//	
//
//	 @Bean
//		    public AuthenticationManager getAuthenticationManager() throws Exception {
//		        return super.authenticationManagerBean();
//		    }

	
	
	
	
	
	
	
	
	
	@Autowired
	// DataSource dataSource;
	UserDetailsService userDetailsService;

//@Autowired
//	JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService); 

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
		csrf().
		disable().
		authorizeRequests()
		.antMatchers("/authenticate").
		permitAll().
		anyRequest().
		authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		//http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	
	
	
}
