package com.nagarro.services.api;

import java.util.List;

import com.nagarro.dto.FlightSearchRequestDto;
import com.nagarro.exceptions.InvalidInputException;
import com.nagarro.model.Flight;

/**
 * this is flight service interface , interacts with dao layer it checks for the
 * available flights and sorts them as per the criteria
 * 
 * @author surbhiagarwal
 *
 */

public interface FlightService {

	List<Flight> getAvailableFlights(FlightSearchRequestDto dto);

	void sortFlights(List<Flight> availableFlights, String sortBy) throws InvalidInputException;

}
