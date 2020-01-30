package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.CouponsResponse;
import com.amdocs.pizzataskms.model.Locations;
import com.amdocs.pizzataskms.model.LocationsResponse;


public interface LocationService {
	
	Locations getLocationByIdNumber(Long locationIdNumber);
	LocationsResponse getAllLocations();
	CouponsResponse getCopuns();

}
