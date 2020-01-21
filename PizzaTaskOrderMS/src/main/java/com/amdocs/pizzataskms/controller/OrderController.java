package com.amdocs.pizzataskms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.pizzataskms.api.external.GetOrderApi;
import com.amdocs.pizzataskms.api.external.GetOrdersApi;
import com.amdocs.pizzataskms.api.external.SaveOrderApi;
import com.amdocs.pizzataskms.model.external.GetOrderResponse;
import com.amdocs.pizzataskms.model.external.OrderRequest;
import com.amdocs.pizzataskms.model.external.SaveOrderResponse;
import com.amdocs.pizzataskms.service.OrderService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrderController implements GetOrderApi,SaveOrderApi,GetOrdersApi{

	@Autowired
	private OrderService orderSerivce;
	
	@Override
	@RequestMapping(value = "/SaveOrder", method = RequestMethod.POST)
	public ResponseEntity<SaveOrderResponse> saveOrderPost(OrderRequest request) {
		return new ResponseEntity<SaveOrderResponse>(orderSerivce.saveOrder(request),HttpStatus.OK);
	}

	@Override
	@GetMapping("/GetOrder/{orderIdNumber}")
	public ResponseEntity<GetOrderResponse> getOrder(Integer orderIdNumber) {
		return new ResponseEntity<GetOrderResponse>(orderSerivce.getOrderById(orderIdNumber),HttpStatus.OK);
	}

	@Override
	@GetMapping("/GetOrders")
	public ResponseEntity<GetOrderResponse> getOrders() {
		return new ResponseEntity<GetOrderResponse>(orderSerivce.getAllOrders(),HttpStatus.OK);
	}


	
	

}
