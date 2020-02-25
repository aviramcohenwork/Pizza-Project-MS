package com.example.pizzataskms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzataskms.model.GetOrderResponse;
import com.example.pizzataskms.service.DeliveryFeign;
import com.example.pizzataskms.service.DeliveryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping(path = "/GetOrder/{orderIdNumber}",headers = "Accept=application/json")
	public void getNameLocation(@PathVariable String orderIdNumber){
		deliveryService.updateOrderStatus(orderIdNumber);
	}
    
}