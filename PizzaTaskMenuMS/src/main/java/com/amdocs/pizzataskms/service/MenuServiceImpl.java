package com.amdocs.pizzataskms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.amdocs.pizzataskms.model.external.Drink;
import com.amdocs.pizzataskms.model.external.MenuServiceDrinkResponse;
import com.amdocs.pizzataskms.model.external.MenuServicePizzaResponse;
import com.amdocs.pizzataskms.model.external.Pizza;


@Service
public class MenuServiceImpl implements MenuService{

	private MongoTemplate mongoTemplate;
	
	public MenuServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public MenuServicePizzaResponse pizzaMenuResponse() {
		List<Pizza> pizzaList = mongoTemplate.findAll(Pizza.class, "PizzaTaskMSPizza"); 
		MenuServicePizzaResponse menuServicePizzaResponse = new MenuServicePizzaResponse();
		ArrayList<Pizza> pizzaArrayList = new ArrayList<>();
		
		if(pizzaList.size()>0)
		{
			for (int i=0;i<pizzaList.size();i++) 
			{
				Pizza pizza = new Pizza();
				pizza.setPizzaIdNumber(pizzaList.get(i).getPizzaIdNumber());
				pizza.setPizzaName(pizzaList.get(i).getPizzaName());
				pizza.setPizzaPicture(pizzaList.get(i).getPizzaPicture());
				pizza.setPizzaPrice(pizzaList.get(i).getPizzaPrice());
				pizzaArrayList.add(pizza);
			}
			
			menuServicePizzaResponse.setPizzaArray(pizzaArrayList);
		}
		return menuServicePizzaResponse;
	}

	@Override
	public MenuServiceDrinkResponse drinkMenuResponse() {
		List<Drink> drinkList = mongoTemplate.findAll(Drink.class, "PizzaTaskMSDrinks"); 
		MenuServiceDrinkResponse menuServiceDrinkResponse = new MenuServiceDrinkResponse();
		ArrayList<Drink> drinkArrayList = new ArrayList<>();
		
		if(drinkList.size()>0)
		{
			for(int i=0;i<drinkList.size();i++)
			{
				Drink drink = new Drink();
				drink.setDrinkIdNumber(drinkList.get(i).getDrinkIdNumber());
				drink.setDrinkName(drinkList.get(i).getDrinkName());
				drink.setDrinkPicture(drinkList.get(i).getDrinkPicture());
				drink.setDrinkPrice(drinkList.get(i).getDrinkPrice());
				drinkArrayList.add(drink);
			}
			menuServiceDrinkResponse.setDrinkArray(drinkArrayList);
		}
		return menuServiceDrinkResponse;
		
	}
}
