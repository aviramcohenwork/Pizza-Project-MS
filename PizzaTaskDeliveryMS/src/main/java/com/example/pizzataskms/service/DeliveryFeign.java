package com.example.pizzataskms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pizzataskms.model.GetOrderResponse;


@FeignClient(name = "PIZZATASKMSORDER")
public interface DeliveryFeign {
	@RequestMapping(method = RequestMethod.GET, value = "/GetOrder/{orderIdNumber}")
	public GetOrderResponse getOrderById(@PathVariable("orderIdNumber")Integer orderIdNumber);
}