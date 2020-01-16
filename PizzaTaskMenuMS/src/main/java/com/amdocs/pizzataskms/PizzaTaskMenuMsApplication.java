package com.amdocs.pizzataskms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class PizzaTaskMenuMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaTaskMenuMsApplication.class, args);
	}

}
