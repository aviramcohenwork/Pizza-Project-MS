package com.amdocs.pizzataskms.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;import org.springframework.stereotype.Service;
import com.amdocs.pizzataskms.model.CartItems;
import com.amdocs.pizzataskms.model.DeliveryDetails;
import com.amdocs.pizzataskms.model.DeliverySaveOrder;
import com.amdocs.pizzataskms.model.GetOrderResponse;
import com.amdocs.pizzataskms.model.GetOrderResponseOrder;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired 
	private DeliveryFeign deliveryFeign;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
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
	}}
