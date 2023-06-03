package com.ust.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignclientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignclientsApplication.class, args);
	}

}
