package com.nagarro.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.FlightLoaderDao;
import com.nagarro.services.api.FlightLoadService;

/**
 * implements interface
 * 
 * @author surbhiagarwal
 *
 */
public class FlightLoadServiceImp implements FlightLoadService {

	@Autowired
	private FlightLoaderDao flightLoaderDao;

	public void loadFlights() throws IOException {
		System.out.println("in flightLoader");
		flightLoaderDao.addFlights();

	}

}
