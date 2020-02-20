package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.SentOrder;

public interface DeliveryService {
	
	SentOrder getOrderUpdate(SentOrder order);
	String updateOrderStatus(String orderIdNumber);
}
