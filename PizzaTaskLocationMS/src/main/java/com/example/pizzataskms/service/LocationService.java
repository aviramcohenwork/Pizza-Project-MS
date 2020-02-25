package com.example.pizzataskms.service;

import com.example.pizzataskms.model.CouponsResponse;
import com.example.pizzataskms.model.Locations;
import com.example.pizzataskms.model.LocationsResponse;


public interface LocationService {
	
	Locations getLocationByIdNumber(Long locationIdNumber);
	LocationsResponse getAllLocations();
	CouponsResponse getCopuns();

}
