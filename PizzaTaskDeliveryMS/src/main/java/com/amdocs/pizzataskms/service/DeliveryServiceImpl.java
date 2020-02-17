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

import com.amdocs.pizzataskms.model.CartItems;
import com.amdocs.pizzataskms.model.DeliveryDetails;
import com.amdocs.pizzataskms.model.DeliverySaveOrder;
import com.amdocs.pizzataskms.model.GetOrderResponse;
import com.amdocs.pizzataskms.model.GetOrderResponseOrder;
import com.amdocs.pizzataskms.model.SentOrder;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired 
	private DeliveryFeign deliveryFeign;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private KafkaTemplate<String,SentOrder> kafkaTemplate;
	
	private boolean checkIfIdExists(GetOrderResponse newResponse)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("orderId").is(newResponse.getOrder().get(0).getId()));
		GetOrderResponseOrder answer = mongoTemplate.findOne(query, GetOrderResponseOrder.class, "PizzaTaskMSDelivery");
		if(answer!=null)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	private String SaveOrderDetails(GetOrderResponse newResponse)
	{
		DeliverySaveOrder deliveryOrder = new DeliverySaveOrder();
		deliveryOrder.setOrderId(newResponse.getOrder().get(0).getId());
		deliveryOrder.setOrderStatus(newResponse.getOrder().get(0).getOrderStatus());
		if(checkIfIdExists(newResponse)==true)
		{
			System.out.println("False");
			return " Error id is exists";
		}
		else {
			mongoTemplate.save(deliveryOrder,"PizzaTaskMSDelivery");
		}
		System.out.println("Success");
		return "Succees";
	}
	
	private GetOrderResponse MappingObjectAndUpdateStatus(GetOrderResponse response)
	{
		GetOrderResponse getOrderResponse = new GetOrderResponse();
		GetOrderResponseOrder getOrderResponseOrder = new GetOrderResponseOrder();
		List<GetOrderResponseOrder> listGetOrderResponseOrder = new ArrayList<GetOrderResponseOrder>();
		
		CartItems cartitems = response.getOrder().get(0).getCartItems();
		DeliveryDetails deliveryDetails =  new DeliveryDetails();
		deliveryDetails.setFullname(response.getOrder().get(0).getDeliveryDetails().getFullname());
		deliveryDetails.setHomenumber(response.getOrder().get(0).getDeliveryDetails().getHomenumber());
		deliveryDetails.setLocations(response.getOrder().get(0).getDeliveryDetails().getLocations());
		deliveryDetails.setPhonenumber(response.getOrder().get(0).getDeliveryDetails().getPhonenumber());
		deliveryDetails.setStreet(response.getOrder().get(0).getDeliveryDetails().getStreet());
		String id = response.getOrder().get(0).getId();
		String orderStatus = "The pizza is arraived to delivery department and we start to preper it for delivery";
		String totalPrice = response.getOrder().get(0).getTotalPrice();
		
		getOrderResponseOrder.setCartItems(cartitems);
		getOrderResponseOrder.setDeliveryDetails(deliveryDetails);
		getOrderResponseOrder.setId(id);
		getOrderResponseOrder.setOrderStatus(orderStatus);
		getOrderResponseOrder.setTotalPrice(totalPrice);
		
		listGetOrderResponseOrder.add(getOrderResponseOrder);
		getOrderResponse.setOrder(listGetOrderResponseOrder);
		
		return getOrderResponse;
		
	}
	
	@Override
	public GetOrderResponse updateOrderStatus(Integer orderIdNumber) {
		GetOrderResponse response = deliveryFeign.getOrderById(orderIdNumber);
		GetOrderResponse newResponse = MappingObjectAndUpdateStatus(response);
		SaveOrderDetails(newResponse);
		return newResponse;
	}

	@KafkaListener(topics="sentorderstatus" , groupId ="group_id")
	@Override
	public SentOrder getOrderUpdate(SentOrder order) {
		SentOrder Order = new SentOrder();
		Order.setOrderIdNumber(order.getOrderIdNumber());
		Order.setOrderIdStatus(order.getOrderIdStatus());
		try {
			Thread.sleep(6000);
			GetOrderStatusTopic(Order);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return Order;
	}
	
	
	public void GetOrderStatusTopic(SentOrder Order ) {
		Order.setOrderIdStatus("The Pizza Is Ready And Packaged Out For Delivery Now Please Be Available The Messenger Will Contact You Soon!");
		try {
			kafkaTemplate.send("getorderstatus",Order);

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
}
