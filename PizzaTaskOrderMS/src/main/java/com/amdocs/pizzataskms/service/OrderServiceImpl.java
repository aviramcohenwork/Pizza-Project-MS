package com.amdocs.pizzataskms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.amdocs.pizzataskms.model.GetOrderStatus;
import com.amdocs.pizzataskms.model.SentOrder;
import com.amdocs.pizzataskms.model.external.GetOrderResponse;
import com.amdocs.pizzataskms.model.external.GetOrderResponseOrder;
import com.amdocs.pizzataskms.model.external.GetOrderStatusResponse;
import com.amdocs.pizzataskms.model.external.Order;
import com.amdocs.pizzataskms.model.external.OrderRequest;
import com.amdocs.pizzataskms.model.external.SaveOrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private KafkaTemplate<String,SentOrder> kafkaTemplate;
		
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
		
		SentOrderStatusTopic(request);

		return orderResponse;
	}
	
	public void SentOrderStatusTopic(OrderRequest request) {
		SentOrder order = new SentOrder();
		order.setOrderIdNumber(request.getOrders().get(0).getId());
		order.setOrderIdStatus("The pizza was sent to the delivery department for preparation and wrapping to be shipped");
		try {
			kafkaTemplate.send("sentorderstatus",order);

		} catch (Exception e) {
			e.getMessage();
		}
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

	@KafkaListener(topics="updateorderstatus" , groupId ="group_id")
	@Override
	public void getOrderStatusFromKafka(SentOrder getOrderStatus) {
		Order reciveOrder = new Order();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(getOrderStatus.getOrderIdNumber()));
		reciveOrder = mongoTemplate.findOne(query, Order.class, "PizzaTaskMSOrders");
		reciveOrder.setOrderStatus(getOrderStatus.getOrderIdStatus());
		mongoTemplate.save(reciveOrder,"PizzaTaskMSOrders");
//		System.out.println(reciveOrder);
	}



	@Override
	public GetOrderStatusResponse getOrderStatusForFE(Integer orderIdNumber) {
		GetOrderStatusResponse getOrderStatusResponse = new GetOrderStatusResponse();
		if(orderIdNumber!=null)
		{
			GetOrderResponseOrder reciveOrder = new GetOrderResponseOrder();
			Query query = new Query();
			String orderid = orderIdNumber.toString();
			query.addCriteria(Criteria.where("_id").is(orderid));
			reciveOrder = mongoTemplate.findOne(query, GetOrderResponseOrder.class, "PizzaTaskMSOrders");
			getOrderStatusResponse.setOrderStatus(reciveOrder.getOrderStatus());
			System.out.println(reciveOrder.getOrderStatus());
			return getOrderStatusResponse;
		}else
		{
			return getOrderStatusResponse;
		}
		
	}
}