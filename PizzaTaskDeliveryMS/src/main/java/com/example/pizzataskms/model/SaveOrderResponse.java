package com.example.pizzataskms.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * SaveOrderResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class SaveOrderResponse   {
  @JsonProperty("CreateOrderStatus")
  private String createOrderStatus = null;

  public SaveOrderResponse createOrderStatus(String createOrderStatus) {
    this.createOrderStatus = createOrderStatus;
    return this;
  }

  public String getCreateOrderStatus() {
    return createOrderStatus;
  }

  public void setCreateOrderStatus(String createOrderStatus) {
    this.createOrderStatus = createOrderStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaveOrderResponse saveOrderResponse = (SaveOrderResponse) o;
    return Objects.equals(this.createOrderStatus, saveOrderResponse.createOrderStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createOrderStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaveOrderResponse {\n");
    
    sb.append("    createOrderStatus: ").append(toIndentedString(createOrderStatus)).append("\n");
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

