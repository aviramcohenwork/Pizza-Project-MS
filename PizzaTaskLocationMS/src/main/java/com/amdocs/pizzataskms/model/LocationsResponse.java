package com.amdocs.pizzataskms.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class LocationsResponse {
	private ArrayList<Locations> locations = new ArrayList<Locations>();
}
