package com.nagarro.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.FlightSearchRequestDto;
import com.nagarro.exceptions.InvalidInputException;
import com.nagarro.model.Flight;
import com.nagarro.services.api.FlightService;
import com.nagarro.util.DateParser;

/**
 * this controller checks for the available flights in database according to search
 *  parameters and sorts according to given output preference
 * @author surbhiagarwal
 *
 */

@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws InvalidInputException
	 */

	@RequestMapping("/search")
	public ModelAndView getAvailableFlights(HttpServletRequest request, HttpServletResponse response)
			throws InvalidInputException {

		FlightSearchRequestDto dto = new FlightSearchRequestDto();

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		String date = request.getParameter("date");
		Date validatedDate = DateParser.getValidatedDate(date);
		System.out.println(validatedDate);
		String flightclass = request.getParameter("flightclass");
		String outputPref = request.getParameter("sortBy");

		dto.setDepLocation(from);

		dto.setArrLocation(to);

		dto.setTravelDate(validatedDate);

		dto.setFlightClass(flightclass);

		dto.setOutputPreference(outputPref);

		List<Flight> availableFlights = flightService.getAvailableFlights(dto);
		if (availableFlights.size() > 0) {
			flightService.sortFlights(availableFlights, outputPref);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("availableFlights", availableFlights);
		mv.setViewName("result");

		return mv;
	}

}
