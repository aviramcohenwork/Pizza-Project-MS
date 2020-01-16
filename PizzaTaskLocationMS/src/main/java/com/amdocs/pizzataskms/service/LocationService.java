package com.amdocs.pizzataskms.service;
import java.util.ArrayList;

import com.amdocs.pizzataskms.model.Locations;


public interface LocationService {
	
	Locations getLocationByIdNumber(Long locationIdNumber);
	ArrayList<Locations> getAllLocations();

}
