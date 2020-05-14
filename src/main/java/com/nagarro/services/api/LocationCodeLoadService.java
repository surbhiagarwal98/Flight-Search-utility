package com.nagarro.services.api;

import java.util.List;

/**
 * this is location code loader interface, interacts with dao gets departure and
 * arrival locations present in database
 * 
 * @author surbhiagarwal
 *
 */
public interface LocationCodeLoadService {

	List<String> getDepLocations();

	List<String> getArrLocations();
}
