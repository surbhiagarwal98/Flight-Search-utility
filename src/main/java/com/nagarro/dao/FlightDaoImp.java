package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.nagarro.dao.api.FlightDao;
import com.nagarro.dto.FlightSearchRequestDto;

import com.nagarro.model.Flight;
import com.nagarro.util.FareIncrementUtil;
import com.nagarro.util.HibernateUtil;

/**
 * implementation of flight dao
 * 
 * @author surbhiagarwal
 *
 */
public class FlightDaoImp implements FlightDao {

	@SuppressWarnings("unchecked")
	public List<Flight> getAvailableFlights(FlightSearchRequestDto dto) {
		String reqDepLocation = dto.getDepLocation();
		String reqArrLocation = dto.getArrLocation();
		Date reqDate = dto.getTravelDate();
		String reqFlightclass = dto.getFlightClass();

		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Flight.class);
		Criterion depLocation = Restrictions.eq("departureLoc", reqDepLocation);
		Criterion arrLocation = Restrictions.eq("arrivalLoc", reqArrLocation);
		Criterion date = Restrictions.ge("date", reqDate);
		Criterion flightclassE = Restrictions.eq("flightClass", reqFlightclass);
		Criterion flightclassEB = Restrictions.eq("flightClass", "EB");
		LogicalExpression orExp = Restrictions.or(flightclassE, flightclassEB);
		Conjunction andExp = Restrictions.and(depLocation, arrLocation, date, orExp);
		criteria.add(andExp);
		List<Flight> availableFlights = criteria.list();
		for (Flight flight : availableFlights) {
			if (reqFlightclass.equals("B")) {
				flight.setFare(FareIncrementUtil.incrementFare(flight.getFare()));
			}
		}

		return availableFlights;
	}

	@SuppressWarnings("unchecked")
	public List<String> getArrivalLocations() {
		List<String> arrivalLocations;
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Query query = session.createQuery("select distinct f.arrivalLoc from Flight f");
		arrivalLocations = query.list();
		return arrivalLocations;
	}

	@SuppressWarnings("unchecked")
	public List<String> getDepartureLocations() {
		List<String> depLocations;
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Query query = session.createQuery("select distinct f.departureLoc from Flight f");
		depLocations = query.list();
		return depLocations;

	}

}
