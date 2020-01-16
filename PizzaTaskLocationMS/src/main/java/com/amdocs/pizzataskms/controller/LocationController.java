package com.amdocs.pizzataskms.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.amdocs.pizzataskms.model.Locations;
import com.amdocs.pizzataskms.service.LocationService;


@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationsService;
	
    @GetMapping(path = "/Location/{locationIdNumber}")
	public Locations getNameLocation(@PathVariable("locationIdNumber") Long locationIdNumber) {
    	
		return locationsService.getLocationByIdNumber(locationIdNumber);
	}
    
    @GetMapping(path = "/Locations")
    public ArrayList<Locations> getLocations()
    {
    	return locationsService.getAllLocations();
    }
  
    
}