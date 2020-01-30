package com.amdocs.pizzataskms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.pizzataskms.api.external.GetDrinkDetailsApi;
import com.amdocs.pizzataskms.api.external.GetPizzaDetailsApi;
import com.amdocs.pizzataskms.model.external.MenuServiceDrinkResponse;
import com.amdocs.pizzataskms.model.external.MenuServicePizzaResponse;
import com.amdocs.pizzataskms.service.MenuService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MenuController implements GetDrinkDetailsApi,GetPizzaDetailsApi {

	@Autowired
	private MenuService menuService;
	
	@Override
	@GetMapping(path = "/Menu/PizzaDetails",headers = "Accept=application/json")
	public ResponseEntity<MenuServicePizzaResponse> getPizzaDetails() {
		return new ResponseEntity<MenuServicePizzaResponse>(menuService.pizzaMenuResponse(),HttpStatus.OK);
	}

	@Override
	@GetMapping(path = "/Menu//DrinkDetails",headers = "Accept=application/json")
	public ResponseEntity<MenuServiceDrinkResponse> getDrinkDetails() {
		return new ResponseEntity<MenuServiceDrinkResponse>(menuService.drinkMenuResponse(),HttpStatus.OK);
	}

}
