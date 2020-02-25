package com.example.pizzataskms.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.pizzataskms.model.DrinkArray;
import com.example.pizzataskms.model.PizzaArray;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * CartItemsInner
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class CartItemsInner   {
  @JsonProperty("PizzaArray")
  private PizzaArray pizzaArray = null;

  @JsonProperty("DrinkArray")
  private DrinkArray drinkArray = null;

  public CartItemsInner pizzaArray(PizzaArray pizzaArray) {
    this.pizzaArray = pizzaArray;
    return this;
  }

  public PizzaArray getPizzaArray() {
    return pizzaArray;
  }

  public void setPizzaArray(PizzaArray pizzaArray) {
    this.pizzaArray = pizzaArray;
  }

  public CartItemsInner drinkArray(DrinkArray drinkArray) {
    this.drinkArray = drinkArray;
    return this;
  }


  public DrinkArray getDrinkArray() {
    return drinkArray;
  }

  public void setDrinkArray(DrinkArray drinkArray) {
    this.drinkArray = drinkArray;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartItemsInner cartItemsInner = (CartItemsInner) o;
    return Objects.equals(this.pizzaArray, cartItemsInner.pizzaArray) &&
        Objects.equals(this.drinkArray, cartItemsInner.drinkArray);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pizzaArray, drinkArray);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartItemsInner {\n");
    
    sb.append("    pizzaArray: ").append(toIndentedString(pizzaArray)).append("\n");
    sb.append("    drinkArray: ").append(toIndentedString(drinkArray)).append("\n");
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

