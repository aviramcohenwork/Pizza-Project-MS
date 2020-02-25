package com.example.pizzataskms.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.pizzataskms.model.GetOrderResponseOrder;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class GetOrderResponse   {
  @JsonProperty("Order")
  private List<GetOrderResponseOrder> order = new ArrayList<GetOrderResponseOrder>();

  public GetOrderResponse order(List<GetOrderResponseOrder> order) {
    this.order = order;
    return this;
  }

  public GetOrderResponse addOrderItem(GetOrderResponseOrder orderItem) {
    this.order.add(orderItem);
    return this;
  }


  public List<GetOrderResponseOrder> getOrder() {
    return order;
  }

  public void setOrder(List<GetOrderResponseOrder> order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetOrderResponse getOrderResponse = (GetOrderResponse) o;
    return Objects.equals(this.order, getOrderResponse.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetOrderResponse {\n");
    
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

