package com.example.pizzataskms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PizzaTaskEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaTaskEurekaServerApplication.class, args);
	}

}
