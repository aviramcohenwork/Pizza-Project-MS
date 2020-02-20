package com.amdocs.pizzataskms.model;

import java.util.Objects;
import com.amdocs.pizzataskms.model.DeliveryDetailsLocations;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class DeliveryDetails   {
  @JsonProperty("fullname")
  private String fullname = null;

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("homenumber")
  private String homenumber = null;

  @JsonProperty("phonenumber")
  private String phonenumber = null;

  @JsonProperty("locations")
  private DeliveryDetailsLocations locations = null;

  public DeliveryDetails fullname(String fullname) {
    this.fullname = fullname;
    return this;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public DeliveryDetails street(String street) {
    this.street = street;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public DeliveryDetails homenumber(String homenumber) {
    this.homenumber = homenumber;
    return this;
  }


  public String getHomenumber() {
    return homenumber;
  }

  public void setHomenumber(String homenumber) {
    this.homenumber = homenumber;
  }

  public DeliveryDetails phonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    return this;
  }


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public DeliveryDetails locations(DeliveryDetailsLocations locations) {
    this.locations = locations;
    return this;
  }


  public DeliveryDetailsLocations getLocations() {
    return locations;
  }

  public void setLocations(DeliveryDetailsLocations locations) {
    this.locations = locations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryDetails deliveryDetails = (DeliveryDetails) o;
    return Objects.equals(this.fullname, deliveryDetails.fullname) &&
        Objects.equals(this.street, deliveryDetails.street) &&
        Objects.equals(this.homenumber, deliveryDetails.homenumber) &&
        Objects.equals(this.phonenumber, deliveryDetails.phonenumber) &&
        Objects.equals(this.locations, deliveryDetails.locations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullname, street, homenumber, phonenumber, locations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryDetails {\n");
    
    sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    homenumber: ").append(toIndentedString(homenumber)).append("\n");
    sb.append("    phonenumber: ").append(toIndentedString(phonenumber)).append("\n");
    sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
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

