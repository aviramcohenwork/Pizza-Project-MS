package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.GetOrderResponse;
import com.amdocs.pizzataskms.model.SentOrder;

public interface DeliveryService {
	
	GetOrderResponse updateOrderStatus(Integer orderIdNumber);
	SentOrder getOrderUpdate(SentOrder order);
}
