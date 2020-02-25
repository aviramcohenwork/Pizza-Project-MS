package com.example.pizzataskms.service;

import com.example.pizzataskms.model.SentOrder;

public interface DeliveryService {
	
	SentOrder getOrderUpdate(SentOrder order);
	String updateOrderStatus(String orderIdNumber);
}
