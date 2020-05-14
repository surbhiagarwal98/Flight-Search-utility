package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.FlightDaoImp;
import com.nagarro.dao.FlightFileLoadDaoImp;
import com.nagarro.dao.FlightLoaderDaoImp;
import com.nagarro.dao.UserDaoImp;
import com.nagarro.dao.api.FlightDao;
import com.nagarro.dao.api.FlightFileLoadDao;
import com.nagarro.dao.api.FlightLoaderDao;
import com.nagarro.dao.api.UserDao;
import com.nagarro.services.FlightLoadServiceImp;
import com.nagarro.services.FlightServiceImp;
import com.nagarro.services.LocationCodeLoaderServiceImp;
import com.nagarro.services.UserServiceImp;
import com.nagarro.services.api.FlightLoadService;
import com.nagarro.services.api.FlightService;
import com.nagarro.services.api.LocationCodeLoadService;
import com.nagarro.services.api.UserService;
/**
 * Configures interfaces implementations
 * @author surbhiagarwal
 *
 */

@Configuration
@EnableScheduling
public class AppConfig {
	
	@Bean
	public FlightFileLoadDao getFlightFileLoadDao() {
		return new FlightFileLoadDaoImp();
	}
	
	@Bean
	public FlightLoaderDao getFlightLoaderService() {
		return new FlightLoaderDaoImp();
	}
	
	@Bean
	public FlightLoadService getFlightLoadService() {
		return new FlightLoadServiceImp();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserServiceImp();
	}
	
	@Bean
	public UserDao getUserDao(){
		return new UserDaoImp();
	}
	
	@Bean
	public FlightService getFlightService() {
		return new FlightServiceImp();
	}
	
	@Bean
	public FlightDao getFlightDao() {
		return new FlightDaoImp();
	}
	
	@Bean
	public LocationCodeLoadService getLocationCodes() {
		return new LocationCodeLoaderServiceImp();
	}
	
	
}
