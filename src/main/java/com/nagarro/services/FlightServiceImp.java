package com.nagarro.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.FlightDao;
import com.nagarro.dto.FlightSearchRequestDto;
import com.nagarro.exceptions.InvalidInputException;
import com.nagarro.model.Flight;
import com.nagarro.services.api.FlightService;
import com.nagarro.util.DurationSortCriteria;
import com.nagarro.util.FareDurationSortCriteria;
import com.nagarro.util.FareSortCriteria;

/**
 * 
 * @author surbhiagarwal
 *
 */
public class FlightServiceImp implements FlightService {

	@Autowired
	private FlightDao flightDao;

	public List<Flight> getAvailableFlights(FlightSearchRequestDto dto) {
		List<Flight> availableFlights = flightDao.getAvailableFlights(dto);

		return availableFlights;
	}

	public void sortFlights(List<Flight> availableFlights, String outputPref) throws InvalidInputException {
		try {
			if (outputPref.equalsIgnoreCase("fare")) {
				Collections.sort(availableFlights, new FareSortCriteria());
			} else if (outputPref.equalsIgnoreCase("duration")) {
				Collections.sort(availableFlights, new DurationSortCriteria());
			} else if (outputPref.equalsIgnoreCase("both")) {
				Collections.sort(availableFlights, new FareDurationSortCriteria());
			}
		} catch (Exception e) {
			throw new InvalidInputException("Please enter valid input");
		}

	}

}
