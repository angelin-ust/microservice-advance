package com.ust.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	
	//after
	//Security has two aspect 1)authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//inmemoryAnthication the credential are stored somewhere in the memory
		//where the security manager have to serach for credential
//		auth.inMemoryAuthentication().
//		withUser("bond").
//		password("james").roles("USER").
//		and().
//		withUser("poo").
//		password("bear").roles("ADMIN");
		
		//so we command its so we are using the jdbc as we storing
		//the username and password in data and schemma
		
		
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPassEncoder() 
	{
		//Encryption we are using here thats NoOpPasswordEncoder
		//the code will run but as its old version thats it strikes
		return   NoOpPasswordEncoder.getInstance();
	}
	
	
	//ee method use cheythille user and admin namukuu directly access
	//cheyane pattumm
	//role pro kannuillaa akkum(endpoint pro akkunilla that "/user or "/admin"
	//there will be no pro
	//the use cheyumpolAuthorizeCheyumm 
	//admin credential use cheythall
	//matramm enter cheyane pattullu
	//user credential use cheythall
		//matramm enter cheyane pattullu
	protected void configure(HttpSecurity http) throws Exception
	{  //antMatcher like regularexpression polle akkum
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/").permitAll().
		and().formLogin();
	}
	
	
	
	
	
	
	
}
