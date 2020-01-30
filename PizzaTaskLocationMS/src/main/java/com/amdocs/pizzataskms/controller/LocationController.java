package com.amdocs.pizzataskms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.pizzataskms.model.Coupons;
import com.amdocs.pizzataskms.model.CouponsResponse;
import com.amdocs.pizzataskms.model.Locations;
import com.amdocs.pizzataskms.model.LocationsResponse;
import com.amdocs.pizzataskms.service.LocationService;

@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationsService;
	
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
