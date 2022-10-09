package org.canterburyschool.alelko.moviedbpoc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MovieDBServiceFactory {
	
	private static final Logger LOG = LogManager.getLogger(MovieDBServiceFactory.class);
	
	public static ServiceType SERVICE_TYPE = ServiceType.HARD_CODED;
	
	public MovieDBServiceFactory() {
		
	}
	
	public static MovieDBService getService() {
		MovieDBService toReturn; 
		
		switch (SERVICE_TYPE) {
		case HARD_CODED:
			toReturn = new MovieDBHardCodedService();
			break;
		case LIST:
			toReturn = new MovieDBListService();
			break;
		case SQLITE:
			toReturn = new MovieDBSQLiteService();
			break;
		default:
			toReturn = new MovieDBHardCodedService();
			break;
		
		}
		
		return toReturn;
	}
	
}
