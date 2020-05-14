package com.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.FlightDao;
import com.nagarro.services.api.LocationCodeLoadService;

/**
 * 
 * @author surbhiagarwal
 *
 */
public class LocationCodeLoaderServiceImp implements LocationCodeLoadService {

	@Autowired
	private FlightDao dao;

	public List<String> getArrLocations() {
		List<String> arrlocations = dao.getArrivalLocations();

		return arrlocations;
	}

	public List<String> getDepLocations() {
		List<String> depLocations = dao.getDepartureLocations();
		return depLocations;
	}

}
