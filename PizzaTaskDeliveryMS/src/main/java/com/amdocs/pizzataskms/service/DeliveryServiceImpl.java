package com.amdocs.pizzataskms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.amdocs.pizzataskms.model.Order;
import com.amdocs.pizzataskms.model.SentOrder;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired 
	private DeliveryFeign deliveryFeign;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private KafkaTemplate<String,SentOrder> kafkaTemplate;
	
		
	private String SaveOrderDetails(String orderIdNumber)
	{

		Order order = new Order();
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(orderIdNumber));
		order = mongoTemplate.findOne(query, Order.class, "PizzaTaskMSOrders");
		order.setOrderStatus("The pizza has arrived at the shipping department and is starting to prepare and pack it for delivery.");
		try {
			Thread.sleep(4000);
			mongoTemplate.save(order,"PizzaTaskMSOrders");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Succees";
	}
	
	
	@Override
	public String updateOrderStatus(String orderIdNumber) 
	{
		System.out.println("hdsfdsfsd============================================================dsfdsfds");
		if(orderIdNumber!=null)
		{
			SaveOrderDetails(orderIdNumber);
			return "success to update status";
		}
		else {
			return "Faild to update status";
		}
		
	}

	@KafkaListener(topics="sentorderstatus" , groupId ="group_id")
	@Override
	public SentOrder getOrderUpdate(SentOrder order) {
		SentOrder Order = new SentOrder();
		Order.setOrderIdNumber(order.getOrderIdNumber());
		Order.setOrderIdStatus(order.getOrderIdStatus());
//		updateOrderStatus(order.getOrderIdNumber());
		try {
			Thread.sleep(6000);
			GetOrderStatusTopic(Order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Order;
	}
	
	
	public void GetOrderStatusTopic(SentOrder Order ) {
		Order.setOrderIdStatus("The Pizza Has Arrived At The Shipping Department And Is Starting To Prepare And Pack It For Delivery.!");
		try {
			kafkaTemplate.send("updateorderstatus",Order);

		} catch (Exception e) {
			e.getMessage();
		}
		
		try {
			Thread.sleep(9000);
			Order.setOrderIdStatus("The Pizza Is Ready And Packaged Out For Delivery Now Please Be Available The Messenger Will Contact You Soon!");
			kafkaTemplate.send("updateorderstatus",Order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
