package com.nagarro.util;

import java.util.Comparator;

import com.nagarro.model.Flight;

/**
 * compares and sorts flights accroding to their durations
 * 
 * @author surbhiagarwal
 *
 */
public class DurationSortCriteria implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {

		return o1.getDuration().compareTo(o2.getDuration());
	}

}
