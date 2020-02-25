package com.example.pizzataskms.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * Pizza
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class Pizza   {
  @JsonProperty("pizzaName")
  private String pizzaName = null;

  @JsonProperty("pizzaPrice")
  private String pizzaPrice = null;

  @JsonProperty("pizzaPicture")
  private String pizzaPicture = null;

  @JsonProperty("pizzaIdNumber")
  private String pizzaIdNumber = null;

  public Pizza pizzaName(String pizzaName) {
    this.pizzaName = pizzaName;
    return this;
  }

  public String getPizzaName() {
    return pizzaName;
  }

  public void setPizzaName(String pizzaName) {
    this.pizzaName = pizzaName;
  }

  public Pizza pizzaPrice(String pizzaPrice) {
    this.pizzaPrice = pizzaPrice;
    return this;
  }

  public String getPizzaPrice() {
    return pizzaPrice;
  }

  public void setPizzaPrice(String pizzaPrice) {
    this.pizzaPrice = pizzaPrice;
  }

  public Pizza pizzaPicture(String pizzaPicture) {
    this.pizzaPicture = pizzaPicture;
    return this;
  }


  public String getPizzaPicture() {
    return pizzaPicture;
  }

  public void setPizzaPicture(String pizzaPicture) {
    this.pizzaPicture = pizzaPicture;
  }

  public Pizza pizzaIdNumber(String pizzaIdNumber) {
    this.pizzaIdNumber = pizzaIdNumber;
    return this;
  }


  public String getPizzaIdNumber() {
    return pizzaIdNumber;
  }

  public void setPizzaIdNumber(String pizzaIdNumber) {
    this.pizzaIdNumber = pizzaIdNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pizza pizza = (Pizza) o;
    return Objects.equals(this.pizzaName, pizza.pizzaName) &&
        Objects.equals(this.pizzaPrice, pizza.pizzaPrice) &&
        Objects.equals(this.pizzaPicture, pizza.pizzaPicture) &&
        Objects.equals(this.pizzaIdNumber, pizza.pizzaIdNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pizzaName, pizzaPrice, pizzaPicture, pizzaIdNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pizza {\n");
    
    sb.append("    pizzaName: ").append(toIndentedString(pizzaName)).append("\n");
    sb.append("    pizzaPrice: ").append(toIndentedString(pizzaPrice)).append("\n");
    sb.append("    pizzaPicture: ").append(toIndentedString(pizzaPicture)).append("\n");
    sb.append("    pizzaIdNumber: ").append(toIndentedString(pizzaIdNumber)).append("\n");
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

