package com.amdocs.pizzataskms.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
/**
 * DeliveryDetailsLocations
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-27T12:36:56.679+02:00")

public class DeliveryDetailsLocations   {
  @JsonProperty("locationDescription")
  private String locationDescription = null;

  @JsonProperty("locationValueName")
  private String locationValueName = null;

  public DeliveryDetailsLocations locationDescription(String locationDescription) {
    this.locationDescription = locationDescription;
    return this;
  }

  public String getLocationDescription() {
    return locationDescription;
  }

  public void setLocationDescription(String locationDescription) {
    this.locationDescription = locationDescription;
  }

  public DeliveryDetailsLocations locationValueName(String locationValueName) {
    this.locationValueName = locationValueName;
    return this;
  }

  public String getLocationValueName() {
    return locationValueName;
  }

  public void setLocationValueName(String locationValueName) {
    this.locationValueName = locationValueName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryDetailsLocations deliveryDetailsLocations = (DeliveryDetailsLocations) o;
    return Objects.equals(this.locationDescription, deliveryDetailsLocations.locationDescription) &&
        Objects.equals(this.locationValueName, deliveryDetailsLocations.locationValueName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationDescription, locationValueName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryDetailsLocations {\n");
    
    sb.append("    locationDescription: ").append(toIndentedString(locationDescription)).append("\n");
    sb.append("    locationValueName: ").append(toIndentedString(locationValueName)).append("\n");
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

