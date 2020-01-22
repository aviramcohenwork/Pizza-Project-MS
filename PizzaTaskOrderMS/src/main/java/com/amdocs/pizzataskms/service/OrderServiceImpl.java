package com.amdocs.pizzataskms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.pizzataskms.model.external.CartItems;
import com.amdocs.pizzataskms.model.external.DeliveryDetails;
import com.amdocs.pizzataskms.model.external.GetOrderResponse;
import com.amdocs.pizzataskms.model.external.GetOrderResponseOrder;
import com.amdocs.pizzataskms.model.external.Order;
import com.amdocs.pizzataskms.model.external.OrderRequest;
import com.amdocs.pizzataskms.model.external.SaveOrderResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Order mappingRequest(Order order,OrderRequest request)
	{
		order.setId(request.getOrders().get(0).getId());
		order.setTotalPrice(request.getOrders().get(0).getTotalPrice());
		order.setDeliveryDetails(request.getOrders().get(0).getDeliveryDetails());
		order.setCartItems(request.getOrders().get(0).getCartItems());
		order.setOrderStatus("The pizza delivered to shipping department");
		return order;
	}
	
	@Override
	public SaveOrderResponse saveOrder(OrderRequest request) {

		SaveOrderResponse orderResponse = new SaveOrderResponse();
		if(request.getOrders().get(0).getCartItems()!=null && request.getOrders().get(0).getDeliveryDetails()!=null
				&& request.getOrders().get(0).getId()!=null)
		{
			List<Order> orderList = new ArrayList<Order>();
			Order order = new Order();
			Order currentOrder = mappingRequest(order,request);
			orderList.add(currentOrder);
			orderResponse.setCreateOrderStatus("Success");
			mongoTemplate.save(order,"PizzaTaskMSOrders");
		}
		else {
			orderResponse.setCreateOrderStatus("Failure");
		}
		System.out.println(orderResponse);
		return orderResponse;
	}

	@Override
	public GetOrderResponse getOrderById(Integer orderId) {
		GetOrderResponse orderResponse = new GetOrderResponse();
		GetOrderResponseOrder getOrderResponseOrder = new GetOrderResponseOrder();
		Query query = new Query();
		String orderid = orderId.toString();
		query.addCriteria(Criteria.where("_id").is(orderid));
		getOrderResponseOrder = mongoTemplate.findOne(query, GetOrderResponseOrder.class, "PizzaTaskMSOrders");
		orderResponse.addOrderItem(getOrderResponseOrder);
		return orderResponse;
	}

	@Override
	public GetOrderResponse getAllOrders() {
		GetOrderResponse ordersResponse = new GetOrderResponse();
		List<GetOrderResponseOrder> ordersList =  mongoTemplate.findAll(GetOrderResponseOrder.class, "PizzaTaskMSOrders");
		ordersResponse.setOrder(ordersList);
		return ordersResponse;

	}



}
