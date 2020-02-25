package com.example.pizzataskms.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.pizzataskms.model.CartItems;
import com.example.pizzataskms.model.DeliveryDetails;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * Order
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class Order   {
  @JsonProperty("deliveryDetails")
  private DeliveryDetails deliveryDetails = null;

  @JsonProperty("cartItems")
  private CartItems cartItems = null;

  @JsonProperty("totalPrice")
  private String totalPrice = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("orderStatus")
  private String orderStatus = null;

  public Order deliveryDetails(DeliveryDetails deliveryDetails) {
    this.deliveryDetails = deliveryDetails;
    return this;
  }

  @NotNull
  public DeliveryDetails getDeliveryDetails() {
    return deliveryDetails;
  }

  public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
    this.deliveryDetails = deliveryDetails;
  }

  public Order cartItems(CartItems cartItems) {
    this.cartItems = cartItems;
    return this;
  }

  @NotNull
  public CartItems getCartItems() {
    return cartItems;
  }

  public void setCartItems(CartItems cartItems) {
    this.cartItems = cartItems;
  }

  public Order totalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  @NotNull
  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Order id(String id) {
    this.id = id;
    return this;
  }

  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Order orderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
    return this;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.deliveryDetails, order.deliveryDetails) &&
        Objects.equals(this.cartItems, order.cartItems) &&
        Objects.equals(this.totalPrice, order.totalPrice) &&
        Objects.equals(this.id, order.id) &&
        Objects.equals(this.orderStatus, order.orderStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryDetails, cartItems, totalPrice, id, orderStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    deliveryDetails: ").append(toIndentedString(deliveryDetails)).append("\n");
    sb.append("    cartItems: ").append(toIndentedString(cartItems)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderStatus: ").append(toIndentedString(orderStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

