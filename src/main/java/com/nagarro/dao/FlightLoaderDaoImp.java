package com.nagarro.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.FlightFileLoadDao;
import com.nagarro.dao.api.FlightLoaderDao;
import com.nagarro.model.Flight;
import com.nagarro.util.HibernateUtil;

/**
 * implements interface
 * 
 * @author surbhiagarwal
 *
 */
public class FlightLoaderDaoImp implements FlightLoaderDao {

	@Autowired
	private FlightFileLoadDao fileLoader;

	public void addFlights() throws IOException {
		
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();

		List<String> fileList = fileLoader.getFiles();
		
		String line = "";

		for (String file : fileList) {

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.readLine();

				while ((line = br.readLine()) != null) {

					StringTokenizer st = new StringTokenizer(line, "|");
					Flight flight = new Flight();
					try {
						String no = st.nextToken();
						flight.setFlightNo(no);
						flight.setDepartureLoc(st.nextToken());
						flight.setArrivalLoc(st.nextToken());

						try {
							DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
							flight.setDate(dateformat.parse(st.nextToken()));
						} catch (ParseException e) {
							System.out.println("Couldn't parse date");
						}

						flight.setTime(st.nextToken());

						flight.setDuration(st.nextToken());

						flight.setFare(Double.parseDouble(st.nextToken()));

						flight.setSeatAvailability(st.nextToken());

						flight.setFlightClass(st.nextToken());
						session.save(flight);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("ArrayIndex Out of bounds");
					}
					System.out.println(flight);

				}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}

		}

		session.getTransaction().commit();
	}
}