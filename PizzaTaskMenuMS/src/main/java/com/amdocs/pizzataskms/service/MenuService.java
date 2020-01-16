package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.external.MenuServiceDrinkResponse;
import com.amdocs.pizzataskms.model.external.MenuServicePizzaResponse;

public interface MenuService {
	
	MenuServicePizzaResponse pizzaMenuResponse();
	
	MenuServiceDrinkResponse drinkMenuResponse();
	

}
