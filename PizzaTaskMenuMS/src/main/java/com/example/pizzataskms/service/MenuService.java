package com.example.pizzataskms.service;

import com.example.pizzataskms.model.external.MenuServiceDrinkResponse;
import com.example.pizzataskms.model.external.MenuServicePizzaResponse;

public interface MenuService {
	
	MenuServicePizzaResponse pizzaMenuResponse();
	
	MenuServiceDrinkResponse drinkMenuResponse();
	

}
