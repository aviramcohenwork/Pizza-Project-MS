package com.example.pizzataskms.service;

import com.example.pizzataskms.model.external.GetOrderResponse;
import com.example.pizzataskms.model.external.GetOrderStatusResponse;
import com.example.pizzataskms.model.external.OrderRequest;
import com.example.pizzataskms.model.external.SaveOrderResponse;
import com.example.pizzataskms.model.SentOrder;

public interface OrderService 
{
	SaveOrderResponse saveOrder(OrderRequest request);
	GetOrderResponse getOrderById(Integer orderId);
	GetOrderResponse getAllOrders();
	void getOrderStatusFromKafka(SentOrder getOrderStatus);
	GetOrderStatusResponse getOrderStatusForFE(Integer orderIdNumber);
}
