package com.amdocs.pizzataskms.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * Drink
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class Drink   {
  @JsonProperty("drinkName")
  private String drinkName = null;

  @JsonProperty("drinkPrice")
  private String drinkPrice = null;

  @JsonProperty("drinkPicture")
  private String drinkPicture = null;

  @JsonProperty("drinkIdNumber")
  private String drinkIdNumber = null;

  public Drink drinkName(String drinkName) {
    this.drinkName = drinkName;
    return this;
  }

  public String getDrinkName() {
    return drinkName;
  }

  public void setDrinkName(String drinkName) {
    this.drinkName = drinkName;
  }

  public Drink drinkPrice(String drinkPrice) {
    this.drinkPrice = drinkPrice;
    return this;
  }

  public String getDrinkPrice() {
    return drinkPrice;
  }

  public void setDrinkPrice(String drinkPrice) {
    this.drinkPrice = drinkPrice;
  }

  public Drink drinkPicture(String drinkPicture) {
    this.drinkPicture = drinkPicture;
    return this;
  }

  public String getDrinkPicture() {
    return drinkPicture;
  }

  public void setDrinkPicture(String drinkPicture) {
    this.drinkPicture = drinkPicture;
  }

  public Drink drinkIdNumber(String drinkIdNumber) {
    this.drinkIdNumber = drinkIdNumber;
    return this;
  }


  public String getDrinkIdNumber() {
    return drinkIdNumber;
  }

  public void setDrinkIdNumber(String drinkIdNumber) {
    this.drinkIdNumber = drinkIdNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Drink drink = (Drink) o;
    return Objects.equals(this.drinkName, drink.drinkName) &&
        Objects.equals(this.drinkPrice, drink.drinkPrice) &&
        Objects.equals(this.drinkPicture, drink.drinkPicture) &&
        Objects.equals(this.drinkIdNumber, drink.drinkIdNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(drinkName, drinkPrice, drinkPicture, drinkIdNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Drink {\n");
    
    sb.append("    drinkName: ").append(toIndentedString(drinkName)).append("\n");
    sb.append("    drinkPrice: ").append(toIndentedString(drinkPrice)).append("\n");
    sb.append("    drinkPicture: ").append(toIndentedString(drinkPicture)).append("\n");
    sb.append("    drinkIdNumber: ").append(toIndentedString(drinkIdNumber)).append("\n");
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

