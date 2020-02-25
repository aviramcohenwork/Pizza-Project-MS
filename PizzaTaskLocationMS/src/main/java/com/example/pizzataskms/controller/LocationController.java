package com.example.pizzataskms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzataskms.model.Coupons;
import com.example.pizzataskms.model.CouponsResponse;
import com.example.pizzataskms.model.Locations;
import com.example.pizzataskms.model.LocationsResponse;
import com.example.pizzataskms.service.LocationService;

@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RestController
public class LocationController {
	
	
	private LocationService locationsService;
	
	public LocationController(LocationService locationsService)
	{
		this.locationsService=locationsService;
	}
	
    @GetMapping(path = "/Location/{locationIdNumber}",headers = "Accept=application/json")
	public Locations getNameLocation(@PathVariable("locationIdNumber") Long locationIdNumber) {
    	
		return locationsService.getLocationByIdNumber(locationIdNumber);
	}
    
    @GetMapping(path = "/Locations/GetAllLocations", headers = "Accept=application/json")
    public LocationsResponse getLocations()
    {
    	return locationsService.getAllLocations();
    }
  
    @GetMapping(path = "/Coupons/GetAllCopuns",headers = "Accept=application/json")
	public CouponsResponse getCopuns() {
    	
		return locationsService.getCopuns();
	}
}
