package com.example.pizzataskms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.pizzataskms.api.external.GetOrderApi;
import com.example.pizzataskms.api.external.GetOrderStatusApi;
import com.example.pizzataskms.api.external.GetOrdersApi;
import com.example.pizzataskms.api.external.SaveOrderApi;
import com.example.pizzataskms.model.external.GetOrderResponse;
import com.example.pizzataskms.model.external.GetOrderStatusResponse;
import com.example.pizzataskms.model.external.OrderRequest;
import com.example.pizzataskms.model.external.SaveOrderResponse;
import com.example.pizzataskms.model.SentOrder;
import com.example.pizzataskms.service.OrderService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RefreshScope
@RestController
public class OrderController implements GetOrderApi,SaveOrderApi,GetOrdersApi,GetOrderStatusApi{

	@Autowired
	private OrderService orderSerivce;
	
	@Override
	@RequestMapping(value = "/Order/SaveOrder", method = RequestMethod.POST)
	public ResponseEntity<SaveOrderResponse> saveOrderPost(OrderRequest request) {
		return new ResponseEntity<SaveOrderResponse>(orderSerivce.saveOrder(request),HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/Order/GetOrder/{orderIdNumber}",headers = "Accept=application/json")
	public ResponseEntity<GetOrderResponse> getOrder(Integer orderIdNumber) {
		return new ResponseEntity<GetOrderResponse>(orderSerivce.getOrderById(orderIdNumber),HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/Order/GetOrders",headers = "Accept=application/json")
	public ResponseEntity<GetOrderResponse> getOrders() {
		return new ResponseEntity<GetOrderResponse>(orderSerivce.getAllOrders(),HttpStatus.OK);
	}

	@Override
	@GetMapping(path="Order/GetOrderStatus/{orderIdNumber}",headers = "Accept=application/json")
	public ResponseEntity<GetOrderStatusResponse> getOrderStatus(Integer orderIdNumber) {
		return new ResponseEntity<GetOrderStatusResponse>(orderSerivce.getOrderStatusForFE(orderIdNumber),HttpStatus.OK);
	}
	

	

}
