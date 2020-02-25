package com.example.pizzataskms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.pizzataskms.model.Coupons;
import com.example.pizzataskms.model.CouponsResponse;
import com.example.pizzataskms.model.Locations;
import com.example.pizzataskms.model.LocationsResponse;

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
	public LocationsResponse getAllLocations() {
		List<Locations> locationList = mongoTemplate.findAll(Locations.class, "PizzaTaskMSLocations");
		LocationsResponse Locations = new LocationsResponse();
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
		}
		
		Locations.setLocations(locationArray);
		
		return Locations;
	}

	@Override
	public CouponsResponse getCopuns() {
		List<Coupons> couponsList = mongoTemplate.findAll(Coupons.class, "PizzaTaskMSCoupons");
		CouponsResponse copuns = new CouponsResponse();
		ArrayList<Coupons> couponArray = new ArrayList<>();
		if(couponsList.size()>0)
		{
			for(int i=0;i<couponsList.size();i++)
			{
				Coupons coup = new Coupons();
				coup.setCouponCode(couponsList.get(i).getCouponCode());
				coup.setCouponId(couponsList.get(i).getCouponId());
				couponArray.add(coup);
			}
		}
		copuns.setCoupons(couponArray);
		return copuns;
	}

}
