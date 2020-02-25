package com.example.pizzataskms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PizzaTaskLocationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaTaskLocationMsApplication.class, args);
	}

}
