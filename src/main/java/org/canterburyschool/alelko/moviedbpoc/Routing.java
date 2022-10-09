package org.canterburyschool.alelko.moviedbpoc;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;

public class Routing {
	
	private static final Logger LOG = LogManager.getLogger(Routing.class);
	
	private static Routing instance;
	
	private Map<String, Class<? extends Controller>> routingMap;
	
	
	private Routing() {
		super();
		
		routingMap = new HashMap<String, Class<? extends Controller>>();
	}
	
	public static Routing getInstance() {
		if (instance == null) {
			instance = new Routing();
		}
		
		return instance;
	}
	
	public void addRoute(String key, Class<? extends Controller> value) {
		routingMap.put(key, value);
	}
	
	public Controller getRoute(String key) {
		Controller toReturn = null;
		try {
			toReturn = routingMap.get(key).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			LOG.debug(e);
		}
		
		return toReturn;
		
	}
}
