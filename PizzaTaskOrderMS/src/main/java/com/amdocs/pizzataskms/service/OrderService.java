package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.external.GetOrderResponse;
import com.amdocs.pizzataskms.model.external.OrderRequest;
import com.amdocs.pizzataskms.model.external.SaveOrderResponse;

public interface OrderService 
{
	SaveOrderResponse saveOrder(OrderRequest request);
	GetOrderResponse getOrderById(Integer orderId);
	GetOrderResponse getAllOrders();
}
