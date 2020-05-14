package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  this controller logs out of the system
 * @author surbhiagarwal
 *
 */

@Controller
public class LogoutController {
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		System.out.println("You have been logged out successfully.");
		return mv;
	}
	
}
