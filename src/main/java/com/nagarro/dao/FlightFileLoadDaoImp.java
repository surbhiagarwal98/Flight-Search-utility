package com.nagarro.dao;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.dao.api.FlightFileLoadDao;

/**
 * 
 * @author surbhiagarwal
 *
 */
public class FlightFileLoadDaoImp implements FlightFileLoadDao {

	public List<String> getFiles() {

		List<String> fileList = new ArrayList<String>();

		fileList.add(
				"C:\\Users\\surbhiagarwal\\Desktop\\Training@Nagarro\\4Advanced Java\\Assignment Links\\Assignment Links\\AirIndia.csv");
		fileList.add(
				"C:\\Users\\surbhiagarwal\\Desktop\\Training@Nagarro\\4Advanced Java\\Assignment Links\\Assignment Links\\indigo.csv");
		fileList.add(
				"C:\\Users\\surbhiagarwal\\Desktop\\Training@Nagarro\\4Advanced Java\\Assignment Links\\Assignment Links\\JetAir.csv");

		return fileList;
	}

}
