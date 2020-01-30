package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.GetOrderResponse;

public interface DeliveryService {
	
	GetOrderResponse updateOrderStatus(Integer orderIdNumber);
}
