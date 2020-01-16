package com.amdocs.pizzataskms.service;

import com.amdocs.pizzataskms.model.Locations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service("LocationService")
public class LocationServiceImpl implements LocationService {

	private MongoTemplate mongoTemplate;
	
	public LocationServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	/**
	 * @desc This function is used to get current location information from data base.
	 * @param {Long} locationIdNumber Location number.
	 * @return {Object} Contain the location details
	 */
	@Override
	public Locations getLocationByIdNumber(Long locationIdNumber) {
		Locations locations = new Locations();
		Query query = new Query();
		query.addCriteria(Criteria.where("locationIdNumber").is(locationIdNumber));
		locations = mongoTemplate.findOne(query, Locations.class, "PizzaTaskMSLocations");
		return locations;
	}

	/**
	 * @desc This function is used to get all location information from data base.
	 * @return {Object} Contain the location details
	 */
	@Override
	public ArrayList<Locations> getAllLocations() {
		List<Locations> locationList = mongoTemplate.findAll(Locations.class, "PizzaTaskMSLocations");
		ArrayList<Locations> locationArray = new ArrayList<>();
		if(locationList.size()>0)
		{
			for(int i=0;i<locationList.size();i++)
			{
				Locations loc = new Locations();
				loc.setLocationDescription(locationList.get(i).getLocationDescription());
				loc.setLocationValueName(locationList.get(i).getLocationValueName());
				locationArray.add(loc);
			}
			System.out.println(locationArray);
		}
		return locationArray;
	}

}
