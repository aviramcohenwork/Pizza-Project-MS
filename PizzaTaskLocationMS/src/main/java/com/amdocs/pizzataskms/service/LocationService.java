package com.amdocs.pizzataskms.service;
import java.util.ArrayList;

import com.amdocs.pizzataskms.model.Locations;
import com.amdocs.pizzataskms.model.LocationsResponse;


public interface LocationService {
	
	Locations getLocationByIdNumber(Long locationIdNumber);
	LocationsResponse getAllLocations();

}
