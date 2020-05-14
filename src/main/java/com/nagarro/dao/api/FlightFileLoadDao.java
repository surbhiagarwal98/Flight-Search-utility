package com.nagarro.dao.api;

import java.util.List;

/**
 * it loads all the csv files, further files can be added here easily.
 * 
 * @author surbhiagarwal
 *
 */
public interface FlightFileLoadDao {
	public List<String> getFiles();
}
