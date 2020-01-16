package com.amdocs.pizzataskms.controller;

import org.springframework.http.ResponseEntity;

import com.amdocs.pizzataskms.api.external.GetDrinkDetailsApi;
import com.amdocs.pizzataskms.api.external.GetPizzaDetailsApi;
import com.amdocs.pizzataskms.model.external.MenuServiceDrinkResponse;
import com.amdocs.pizzataskms.model.external.MenuServicePizzaResponse;

public class MenuController implements GetDrinkDetailsApi,GetPizzaDetailsApi {

	@Override
	public ResponseEntity<MenuServicePizzaResponse> getPizzaDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MenuServiceDrinkResponse> getDrinkDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
