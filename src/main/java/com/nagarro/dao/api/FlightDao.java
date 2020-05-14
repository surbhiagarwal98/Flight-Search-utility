package com.nagarro.dao.api;

import java.util.List;

import com.nagarro.dto.FlightSearchRequestDto;
import com.nagarro.model.Flight;

/**
 * interface to get availableFlights , arrival location codes and departure
 * location codes interacting with database
 * 
 * @author surbhiagarwal
 *
 */
public interface FlightDao {

	List<Flight> getAvailableFlights(FlightSearchRequestDto dto);

	List<String> getArrivalLocations();

	List<String> getDepartureLocations();
}
