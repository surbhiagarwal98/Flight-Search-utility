package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.services.api.FlightLoadService;
import com.nagarro.services.api.LocationCodeLoadService;
import com.nagarro.services.api.UserService;
/**
 * this controller logs in for the given username and password
 * @author surbhiagarwal
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private LocationCodeLoadService locationCodeLoader;
	@Autowired
	private FlightLoadService flightLoader;
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	
	@RequestMapping("/login")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!userService.isValidUser(username, password)) {
			mv.setViewName("index");
			return mv;
		}
		flightLoader.loadFlights();
		List<String> arrLocations = locationCodeLoader.getArrLocations();
		List<String> depLocations = locationCodeLoader.getDepLocations();
		
		mv.addObject("username", username);
		mv.addObject("arrLocations", arrLocations);
		mv.addObject("depLocations", depLocations);
		mv.setViewName("home");
		return mv;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("/reset")
	public ModelAndView reset(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (newPassword.equals(confirmPassword)) {
			if (userService.resetPassword(username, newPassword)) {
				mv.setViewName("index");
			} else {
				System.out.println("password reset failed!");
				mv.setViewName("resetPassword");
			}

		} else {
			System.out.println("Passwords matching failed!");
			mv.setViewName("resetPassword");
		}

		return mv;
	}

}
